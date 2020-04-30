/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import java.sql.Date;

/**
 *
 * @author Amesh M Jayaweera
 */
public class Customer extends SuperModel{
    private String id;
    private String firstName;
    private String lastName;
    private String addressNumber;
    private String addressStreet;
    private String addressCity;
    private String deliveryAddressNumber;
    private String deliveryAddressStreet;
    private String deliveryAddressCity;
    private String deliveryAddressDistrict;
    private String email;
    private int telephoneNumber;
    private int faxNo;
    private Date registrationDate;

    public Customer() {
    }
   

    public Customer(String id, String firstName, String lastName, String addressNumber, String addressStreet, String addressCity, String deliveryAddressNumber, String deliveryAddressStreet, String deliveryAddressCity, String deliveryAddressDistrict, String email, int telephoneNumber, int faxNo, Date registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressNumber = addressNumber;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.deliveryAddressNumber = deliveryAddressNumber;
        this.deliveryAddressStreet = deliveryAddressStreet;
        this.deliveryAddressCity = deliveryAddressCity;
        this.deliveryAddressDistrict = deliveryAddressDistrict;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.faxNo = faxNo;
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getDeliveryAddressNumber() {
        return deliveryAddressNumber;
    }

    public void setDeliveryAddressNumber(String deliveryAddressNumber) {
        this.deliveryAddressNumber = deliveryAddressNumber;
    }

    public String getDeliveryAddressStreet() {
        return deliveryAddressStreet;
    }

    public void setDeliveryAddressStreet(String deliveryAddressStreet) {
        this.deliveryAddressStreet = deliveryAddressStreet;
    }

    public String getDeliveryAddressCity() {
        return deliveryAddressCity;
    }

    public void setDeliveryAddressCity(String deliveryAddressCity) {
        this.deliveryAddressCity = deliveryAddressCity;
    }

    public String getDeliveryAddressDistrict() {
        return deliveryAddressDistrict;
    }

    public void setDeliveryAddressDistrict(String deliveryAddressDistrict) {
        this.deliveryAddressDistrict = deliveryAddressDistrict;
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

    public int getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(int faxNo) {
        this.faxNo = faxNo;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    
}
