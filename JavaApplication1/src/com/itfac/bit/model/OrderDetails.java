/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

/**
 *
 * @author Amesh M Jayaweera
 */
public class OrderDetails {
    
    private String orderNo;
    private String itemCode;
    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(String orderNo, String itemCode, int quantity) {
        this.orderNo = orderNo;
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
