/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import com.itfac.bit.util.enum_types.UnitTypes;

/**
 *
 * @author Amesh M Jayaweera
 */
public class Item {
    private String itemCode;
    private String ittemName;
    private int quantityInHand;
    private double unitPrice;
    private UnitTypes unit;

    public Item() {
    }

    public Item(String itemCode, String ittemName, int quantityInHand, double unitPrice, UnitTypes unit) {
        this.itemCode = itemCode;
        this.ittemName = ittemName;
        this.quantityInHand = quantityInHand;
        this.unitPrice = unitPrice;
        this.unit = unit;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getIttemName() {
        return ittemName;
    }

    public void setIttemName(String ittemName) {
        this.ittemName = ittemName;
    }

    public int getQuantityInHand() {
        return quantityInHand;
    }

    public void setQuantityInHand(int quantityInHand) {
        this.quantityInHand = quantityInHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public UnitTypes getUnit() {
        return unit;
    }

    public void setUnit(UnitTypes unit) {
        this.unit = unit;
    }
    
    
}
