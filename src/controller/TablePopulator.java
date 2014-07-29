/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DataAccess;
import model.Operation;

/**
 *
 * @author Linas
 */
public class TablePopulator {

    JTable table;
    ArrayList<Operation> opList;
    DataAccess da = DataAccess.getInstance();
    int rows;
    String columns[] = {"Operation ID", "Invoice ID", "Date", "Quantity", "Price", "Stock ID"};

    public TablePopulator(JTable table) {
        this.table = table;
    }

    public TablePopulator() {

    }

    /**
     * Populates a table with Operation objects.
     *
     * @param table the JTable to be populated.
     */
    public void populateTable(JTable table) {

        JTable operationTable = table;
        ArrayList<Operation> opL = da.getOperationList();
        rows = da.getOperationList().size();

        DefaultTableModel dtm = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Operation o : opL) {

            int operationID = o.getId();
            int invoiceID = o.getInvoice_id();
            Date unformattedDate = da.toDateObject(o.getDate());
            int qnt = o.getQnt();
            int price = o.getPrice();
            int stockID = o.getStock_id();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            String date = dateFormat.format(unformattedDate);
            Object[] data = {operationID, invoiceID, date, qnt, price, stockID};
            dtm.addRow(data);
        }
        operationTable.setModel(dtm);
    }

    /**
     *
     * @return a String[] representation of the table columns.
     */
    public String[] getColumns() {
        return columns;
    }

    /**
     * Sets a list of columns to be shown to the user.
     *
     * @param columns
     */
    public void setColumns(String[] columns) {
        this.columns = columns;
    }

}
