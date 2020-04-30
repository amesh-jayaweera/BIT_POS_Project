/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.model;

import java.util.Date;
import com.itfac.bit.util.enum_types.DeliveryHeaderStatus;
import com.itfac.bit.util.enum_types.DeliveryStatus;

/**
 *
 * @author Amesh M Jayaweera
 */
public class DeliveryHeader {
    private String deliveryNo;
    private Date deliveryDate;
    private DeliveryStatus deliveryStatus;
    private DeliveryHeaderStatus deliveryHeaderStatus;

    public DeliveryHeader() {
    }

    public DeliveryHeader(String deliveryNo, Date deliveryDate, DeliveryStatus deliveryStatus, DeliveryHeaderStatus deliveryHeaderStatus) {
        this.deliveryNo = deliveryNo;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.deliveryHeaderStatus = deliveryHeaderStatus;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public DeliveryHeaderStatus getDeliveryHeaderStatus() {
        return deliveryHeaderStatus;
    }

    public void setDeliveryHeaderStatus(DeliveryHeaderStatus deliveryHeaderStatus) {
        this.deliveryHeaderStatus = deliveryHeaderStatus;
    }
    
    
}
