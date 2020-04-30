/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import javax.swing.JFrame;

public class BIT_PROJECT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login loginInterface = new Login();
        loginInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginInterface.setLocationRelativeTo(null);
        loginInterface.setVisible(true);
    }
}
