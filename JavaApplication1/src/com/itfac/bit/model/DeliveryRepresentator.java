/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import com.itfac.bit.util.enum_types.DeliveryRepresentatorStatus;
import com.itfac.bit.util.enum_types.DeliveryRepresentatorType;

/**
 *
 * @author Amesh M Jayaweera
 */
public class DeliveryRepresentator {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private int telephoneNumber;
    private DeliveryRepresentatorType deliveryRepresentatorType;
    private DeliveryRepresentatorStatus deliveryRepresentatorStatus;

    public DeliveryRepresentator() {
    }

    public DeliveryRepresentator(String employeeID, String firstName, String lastName, String email, int telephoneNumber, DeliveryRepresentatorType deliveryRepresentatorType, DeliveryRepresentatorStatus deliveryRepresentatorStatus) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.deliveryRepresentatorType = deliveryRepresentatorType;
        this.deliveryRepresentatorStatus = deliveryRepresentatorStatus;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public DeliveryRepresentatorType getDeliveryRepresentatorType() {
        return deliveryRepresentatorType;
    }

    public void setDeliveryRepresentatorType(DeliveryRepresentatorType deliveryRepresentatorType) {
        this.deliveryRepresentatorType = deliveryRepresentatorType;
    }

    public DeliveryRepresentatorStatus getDeliveryRepresentatorStatus() {
        return deliveryRepresentatorStatus;
    }

    public void setDeliveryRepresentatorStatus(DeliveryRepresentatorStatus deliveryRepresentatorStatus) {
        this.deliveryRepresentatorStatus = deliveryRepresentatorStatus;
    }
    
    
}
