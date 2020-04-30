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
public class DeliveryDeliveryRepresentator {
    
    private String deliveryNo;
    private String employeeID;

    public DeliveryDeliveryRepresentator() {
    }

    public DeliveryDeliveryRepresentator(String deliveryNo, String employeeID) {
        this.deliveryNo = deliveryNo;
        this.employeeID = employeeID;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    
}
