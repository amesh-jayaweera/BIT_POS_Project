/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private final static String dbPath = "jdbc:mysql://localhost/orderprocessing";
    private final static String dbUsername = "root";
    private final static String dbPassword = "1234";
    private static Connection connection;
    
    private Database(){
        
    }

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbPath, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
