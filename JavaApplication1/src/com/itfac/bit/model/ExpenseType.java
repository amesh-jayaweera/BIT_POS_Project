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
public class ExpenseType {
    
    private String expenseCode;
    private String expenseDescription;

    public ExpenseType() {
    }

    public ExpenseType(String expenseCode, String expenseDescription) {
        this.expenseCode = expenseCode;
        this.expenseDescription = expenseDescription;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }
    
    
}
