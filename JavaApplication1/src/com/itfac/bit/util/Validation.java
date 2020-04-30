/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.util;

import com.itfac.bit.model.Customer;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.itfac.bit.model.SuperModel;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hisan Hunais
 */
public class Validation {    
   
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmailvalid(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    
    public static boolean isContactNumberValid(String contactNumber) {
        String contactNnumber_regex = "0[0-9]{9}";
        return contactNumber.matches(contactNnumber_regex);
    } 
    
    public static boolean isAmountValid(String amount) {
        String amount_regex = "((\\d{1,4})(((\\.)(\\d{0,2})){0,1}))";
        return amount.matches(amount_regex);
    }
    
    public static boolean isNumberValid(String number) {
        String number_regex = "[0-9]+";
        return number.matches(number_regex);
    }
    
    public static boolean isEmployeeIDValid(String employeeID) {
        String employeeID_regex = "[0-9]{6}";
        return employeeID.matches(employeeID_regex);
    }
    
    public static boolean isItemCodeValid(String itemCode) {
        String itemCode_regex = "[0-9]{6}";
        return itemCode.matches(itemCode_regex);
    }
    
    public static boolean isNameValid(String streetName) {
        String streetName_regex = "^[\\p{L} .'-]+$";
        return streetName.matches(streetName_regex);
    }
    
    public static boolean isVehicleNumberValid(String vehicleNumber) {
        return vehicleNumber.matches("[a-zA-Z]+");
    }
    
//    public static void isEmpty(Object object) throws IllegalArgumentException, IllegalAccessException{
//       Class<? extends Object> obj = object.getClass();
//       Field[] fields = obj.getDeclaredFields();
//        for (Field field : fields) {
//            
//             field.setAccessible(true);
//             System.out.println(field.get(obj));
//        }
//        //return false;
//    }
    
    
//    public static void main(String[] args){
//         Customer customer = new Customer();
//            
//            customer.setFirstName("Amesh");
//            customer.setLastName("Jayaweera");
//            customer.setAddressNumber("123");
//            customer.setAddressStreet("STY");
//            customer.setAddressCity("Colombo");
//            customer.setTelephoneNumber(90007898);
//            customer.setEmail("dwdndnd");
//            customer.setDeliveryAddressNumber("7878");
//            customer.setDeliveryAddressStreet("dmedme");
//            customer.setDeliveryAddressCity("dejf");
//            //customer.setFaxNo(53458);
//            //customer.setDeliveryAddressDistrict("wfjwjf");
//            customer.setId("3757345");
//            
//            isEmpty(customer);
//            
//          //  System.out.println(" Test = " + isEmpty(customer));
//    }
    
}
