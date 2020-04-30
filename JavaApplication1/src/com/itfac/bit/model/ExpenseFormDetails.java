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
public class ExpenseFormDetails {
    private String formNo;
    private String expenseCode;
    private double totalAmount;

    public ExpenseFormDetails() {
    }

    public ExpenseFormDetails(String formNo, String expenseCode, double totalAmount) {
        this.formNo = formNo;
        this.expenseCode = expenseCode;
        this.totalAmount = totalAmount;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    
}
