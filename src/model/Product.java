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
public class Product {
    
    int id;
    String name;
    String code;
    
    // FORMAT=  [{"id":"2","name":"Intel Core i5","code":"PR_385FHK"}, ... ,{"id":"4","name":"Intel Core i7","code":"CORDSF87"}]
    
    public Product (int id, String name, String code){
        this.id = id;
        this.name = name;
        this.code = code;
    }

    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String toString(){
        return code+ "-"+ name;
    }
    
    
}
