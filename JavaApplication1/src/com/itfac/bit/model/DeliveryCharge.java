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
public class DeliveryCharge {
    
    private String districtCode;
    private String districtName;
    private double charge;

    public DeliveryCharge() {
    }

    public DeliveryCharge(String districtCode, String districtName, double charge) {
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.charge = charge;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
    
    
}
