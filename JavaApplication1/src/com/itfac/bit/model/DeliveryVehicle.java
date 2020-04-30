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
public class DeliveryVehicle {
    private String deliveryNo;
    private String vehicleNo;

    public DeliveryVehicle() {
    }

    public DeliveryVehicle(String deliveryNo, String vehicleNo) {
        this.deliveryNo = deliveryNo;
        this.vehicleNo = vehicleNo;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    
    
}
