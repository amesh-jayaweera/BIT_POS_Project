/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import java.util.Date;

/**
 *
 * @author Amesh M Jayaweera
 */
public class ExpenseFormHeader {
    private String formNo;
    private Date formDate;
    private double totalAmount;
    private String deliveryNo;
    private String employeeID;

    public ExpenseFormHeader() {
    }

    public ExpenseFormHeader(String formNo, Date formDate, double totalAmount, String deliveryNo, String employeeID) {
        this.formNo = formNo;
        this.formDate = formDate;
        this.totalAmount = totalAmount;
        this.deliveryNo = deliveryNo;
        this.employeeID = employeeID;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
