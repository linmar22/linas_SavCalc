/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import com.google.gson.*;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Linas
 */
public class DataAccess {

    private static DataAccess instance = null;
    URL productURL;
    URL operationURL;
    ArrayList<Product> productList;
    ArrayList<Operation> operationList;
    boolean reachable;

    protected DataAccess() {

    }
    /**
     * Singleton for the DataAccess class.
     * @return an instance of the class.
     */
    public static DataAccess getInstance() {
        if (instance == null) {
            instance = new DataAccess();
        }
        return instance;
    }

    /**
     * Gets the product list from the server as JSON objects and de-serializes them into an ArrayList.
     */
    public void updateProductList() {
        try {
            productURL = new URL("http://erpnew.alex.fabricums.com/gateway/cards");

            InputStream in = productURL.openStream();
            String json1 = IOUtils.toString(in);
            Gson gson = new Gson();

            JsonElement json = new JsonParser().parse(json1);
            JsonArray array = json.getAsJsonArray();

            Iterator iterator = array.iterator();

            productList = new ArrayList<Product>();

            while (iterator.hasNext()) {
                JsonElement json2 = (JsonElement) iterator.next();
                Product product = gson.fromJson(json2, Product.class);
                productList.add(product);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Gets the product list according to a criterion, from the server as JSON objects and de-serializes them into an ArrayList.
     * @param crit the criterion to match.
     */
    public void updateProductListByCrit(String crit) {
        try {
            productURL = new URL("http://erpnew.alex.fabricums.com/gateway/cards?codename=" + crit);

            InputStream in = productURL.openStream();
            String json1 = IOUtils.toString(in);
            Gson gson = new Gson();

            JsonElement json = new JsonParser().parse(json1);
            JsonArray array = json.getAsJsonArray();

            Iterator iterator = array.iterator();

            productList = new ArrayList<Product>();

            while (iterator.hasNext()) {
                JsonElement json2 = (JsonElement) iterator.next();
                Product product = gson.fromJson(json2, Product.class);
                productList.add(product);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Gets the list of operations as JSON objects within a period of time, and de-serializes them into an ArrayList.
     * 
     * @param fromDate unix time stamp representation of the start date.
     * @param toDate unix time stamp representation of the end date.
     * @param id the id of the product of which to retrieve the operations.
     */
    public void updateOperationList(long fromDate, long toDate, int id) {
        try {
            operationURL = new URL("http://erpnew.alex.fabricums.com/gateway/ops?from=" + fromDate + "&to=" + toDate + "&id=" + id);
            InputStream opIN = operationURL.openStream();
            String jsonOP1 = IOUtils.toString(opIN);

            JsonElement jsonOP = new JsonParser().parse(jsonOP1);
            JsonArray arrayOP = jsonOP.getAsJsonArray();

            Iterator iterator = arrayOP.iterator();

            operationList = new ArrayList<Operation>();

            while (iterator.hasNext()) {
                JsonElement jsonOP2 = (JsonElement) iterator.next();
                JsonObject jsonOB = jsonOP2.getAsJsonObject();

                JsonElement id_Element = jsonOB.get("id");
                JsonElement product_card_id_Element = jsonOB.get("product_card_id");
                JsonElement invoice_id_Element = jsonOB.get("invoice_id");
                JsonElement qnt_Element = jsonOB.get("qnt");
                JsonElement date_Element = jsonOB.get("date");
                JsonElement price_Element = jsonOB.get("price");
                JsonElement stock_id_Element = jsonOB.get("stock_id");
                JsonElement stock_qnt_after_op_Element = jsonOB.get("stock_qnt_after_op");
                JsonElement client_id_Element = jsonOB.get("client_id");

                int ID = id_Element.getAsInt();
                int PRODUCTID = product_card_id_Element.getAsInt();
                int INVOICEID = invoice_id_Element.getAsInt();
                int QNT = qnt_Element.getAsInt();
                long DATE = date_Element.getAsLong();
                int PRICE = price_Element.getAsInt();
                int STOCK = stock_id_Element.getAsInt();
                int STOCKAFTEROP = stock_qnt_after_op_Element.getAsInt();
                int CLIENTID = client_id_Element.getAsInt();

                Operation toAdd = new Operation(ID, PRODUCTID, INVOICEID, QNT, DATE, PRICE, STOCK, STOCKAFTEROP, CLIENTID);

                operationList.add(toAdd);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * 
     * @return an ArrayList of Product objects.
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
    /**
     * 
     * @return an ArrayList of Operation objects.
     */
    public ArrayList<Operation> getOperationList() {
        return operationList;
    }
    
    /**
     * Creates a Date object from a Unix time stamp.
     * @param d the date in Unix time stamp form.
     * @return the Date object.
     */
    public Date toDateObject(long d) {
        d = d * 1000;
        Date date = new Date((long) d);
        return date;
    }
    
    /**
     * Formats a Date object into a Unix time stamp.
     * @param d the Date object.
     * @return the Unix time stamp.
     */
    public long toUnixTimeStamp(Date d) {
        long unixdate;
        unixdate = d.getTime() / 1000;
        return unixdate;
    }
}
