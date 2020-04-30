/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import java.util.Date;
import com.itfac.bit.util.enum_types.OrderStatus;

/**
 *
 * @author Amesh M Jayaweera
 */
public class OrdersHeader {
    
    private String orderID;
    private Date orderDate;
    private double totalAmount;
    private double grandTotalAmount;
    private String deliverRequest; // "YES or NO"
    private OrderStatus orderStatus; 
    private String customerID;
    private String deliveryNO;
    private String discountCode;

    public OrdersHeader() {
    }

    public OrdersHeader(String orderID, Date orderDate, double totalAmount, double grandTotalAmount, String deliverRequest, OrderStatus orderStatus, String customerID, String deliveryNO, String discountCode) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.grandTotalAmount = grandTotalAmount;
        this.deliverRequest = deliverRequest;
        this.orderStatus = orderStatus;
        this.customerID = customerID;
        this.deliveryNO = deliveryNO;
        this.discountCode = discountCode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getGrandTotalAmount() {
        return grandTotalAmount;
    }

    public void setGrandTotalAmount(double grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    public String getDeliverRequest() {
        return deliverRequest;
    }

    public void setDeliverRequest(String deliverRequest) {
        this.deliverRequest = deliverRequest;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDeliveryNO() {
        return deliveryNO;
    }

    public void setDeliveryNO(String deliveryNO) {
        this.deliveryNO = deliveryNO;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
    
    
}
