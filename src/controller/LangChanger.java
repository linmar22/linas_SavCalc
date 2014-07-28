/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.TreeMap;

/**
 *
 * @author Linas
 */
public class LangChanger {

    Connection c = null;
    Statement stmt = null;
    
    TreeMap<String,String> labels = new TreeMap<String,String>();
    
    String menu_file;
    String menu_file_refreshProductList;
    String menu_language;
    String search;
    String from;
    String to;
    String table_operationID;
    String table_invoiceID;
    String table_date;
    String table_quantity;
    String table_price;
    String table_stockID;
    String totals;
    String totals_operations;
    String totals_quantity;
    String totals_income;
    String average_sales_price;
    String load;

    /**
     * Retrieves String values from a local SQLite database to be used in translations. 
     * The labels are added to a TreeMap<String, String> in <label name, translation> format.
     * 
     * @param lang the language of labels to be retrieved in ("lang_xx") format where "xx" is the two first letters of the language. Ex: "lang_ru" is Russian.
     * "lang_xx" corresponds to the SQLite table.
     */
    public void changeLang(String lang) {
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:languages.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT label, value FROM "+lang+";");
            
            while(rs.next()){
                labels.put(rs.getString("label"), rs.getString("value"));
            }
            rs.close();
            stmt.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public String toString() {
        return "LangChanger{" + "menu_file=" + menu_file + ", menu_file_refreshProductList=" + menu_file_refreshProductList + ", menu_language=" + menu_language + ", search=" + search + ", from=" + from + ", to=" + to + ", table_operationID=" + table_operationID + ", table_invoiceID=" + table_invoiceID + ", table_date=" + table_date + ", table_quantity=" + table_quantity + ", table_price=" + table_price + ", table_stockID=" + table_stockID + ", totals=" + totals + ", totals_operations=" + totals_operations + ", totals_quantity=" + totals_quantity + ", totals_income=" + totals_income + ", average_sales_price=" + average_sales_price + ", load=" + load + '}';
    }
    
    /**
     * 
     * @return a populated TreeMap with string values to be used in translation.
     */
    public TreeMap<String, String> getLabels() {
        return labels;
    }
    
    
    
}
