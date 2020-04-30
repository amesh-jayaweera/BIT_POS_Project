/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import com.itfac.bit.util.enum_types.VehicleStatus;

/**
 *
 * @author Amesh M Jayaweera
 */
public class Vehicle {
    
    private String vehicleNo;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleType;
    private VehicleStatus vehicleStatus;

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, String vehicleBrand, String vehicleModel, String vehicleType, VehicleStatus vehicleStatus) {
        this.vehicleNo = vehicleNo;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
   
    
}
