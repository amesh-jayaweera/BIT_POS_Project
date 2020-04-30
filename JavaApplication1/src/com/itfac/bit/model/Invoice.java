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
public class Invoice {
    
    private String invoiceNo;
    private Date invoiceDate;
    private String invoiceTime;
    private double totalAmount;
    private String note;
    private String orderNo;

    public Invoice() {
    }
    
    

    public Invoice(String invoiceNo, Date invoiceDate, String invoiceTime, double totalAmount, String note, String orderNo) {
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.invoiceTime = invoiceTime;
        this.totalAmount = totalAmount;
        this.note = note;
        this.orderNo = orderNo;
    }
    
   
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    
}
