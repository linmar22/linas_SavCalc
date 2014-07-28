/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Linas
 */
public class Operation {
    //FORMAT = [{"id":"1","product_card_id":"2","invoice_id":"1","qnt":"1","date":"1405692681","price":"20000","stock_id":"1","stock_qnt_after_op":"1","client_id":"2"},

    int id;
    int product_card_id;
    int invoice_id;
    int qnt;
    long date;
    int price;
    int stock_id;
    int stock_qnt_after_op;
    int client_id;
    
    public Operation(int id, int product_card_id, int invoice_id, int qnt, long date, int price, int stock_id, int stock_qnt_after_op, int client_id){
        this.id=id;
        this.product_card_id = product_card_id;
        this.invoice_id = invoice_id;
        this.qnt = qnt;
        this.date = date;
        this.price = price;
        this.stock_id = stock_id;
        this.stock_qnt_after_op = stock_qnt_after_op;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_card_id() {
        return product_card_id;
    }

    public void setProduct_card_id(int product_card_id) {
        this.product_card_id = product_card_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getStock_qnt_after_op() {
        return stock_qnt_after_op;
    }

    public void setStock_qnt_after_op(int stock_qnt_after_op) {
        this.stock_qnt_after_op = stock_qnt_after_op;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    
    @Override
    public String toString() {
        return "Operation{" + "id=" + id + ", product_card_id=" + product_card_id + ", invoice_id=" + invoice_id + ", qnt=" + qnt + ", date=" + date + ", price=" + price + ", stock_id=" + stock_id + ", stock_qnt_after_op=" + stock_qnt_after_op + ", client_id=" + client_id + '}';
    }

}
