/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import com.itfac.bit.util.Password_Util;
import com.itfac.bit.database.Database;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {

    Connection connection;
    ResultSet resultSet;
 
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        listener();
    }
    
    
    void listener(){
        txt_username.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
                    txt_currentPassword.requestFocusInWindow();
                }
            }  
        });
        
        txt_currentPassword.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
                    txt_newPassword.requestFocusInWindow();
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    txt_username.requestFocusInWindow();
                }
            }  
        });
        
        txt_newPassword.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
                    txt_confirmPassword.requestFocusInWindow();
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    txt_currentPassword.requestFocusInWindow();
                }
            }  
        });
        
        txt_confirmPassword.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
                    btn_submit.requestFocusInWindow();
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    txt_newPassword.requestFocusInWindow();
                }
            }  
        });
        
        btn_submit.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    btn_clear.requestFocusInWindow();
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    btn_cancel.requestFocusInWindow();
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    txt_confirmPassword.requestFocusInWindow();
                }
            }  
        });
        
        
        btn_clear.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    btn_submit.requestFocusInWindow();
                }
            }  
        });
        
        btn_cancel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    btn_submit.requestFocusInWindow();
                }
            }  
        });
        
        
    }
    
    private void clearUsernameAndCurrentPassword(){
        txt_currentPassword.setText("");
        txt_username.setText("");
    }
    
    private void clearNewPasswordAndConfirmedPassword(){
        txt_newPassword.setText("");
        txt_confirmPassword.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        txt_currentPassword = new javax.swing.JPasswordField();
        txt_newPassword = new javax.swing.JPasswordField();
        txt_confirmPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(218, 247, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 88, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Current Password");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("New Password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("Confirm New Password");

        btn_submit.setBackground(new java.awt.Color(0, 88, 50));
        btn_submit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_submit.setForeground(java.awt.Color.white);
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(51, 102, 153));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_clear.setForeground(java.awt.Color.white);
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 103, 125));
        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_cancel.setForeground(java.awt.Color.white);
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txt_currentPassword)
                            .addComponent(txt_newPassword)
                            .addComponent(txt_confirmPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btn_clear)
                        .addGap(50, 50, 50)
                        .addComponent(btn_submit)
                        .addGap(57, 57, 57)
                        .addComponent(btn_cancel)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_currentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancel)
                    .addComponent(btn_clear)
                    .addComponent(btn_submit))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
       clearUsernameAndCurrentPassword();
       clearNewPasswordAndConfirmedPassword();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        try {
           
            connection = Database.openConnection();

            String newPassword = String.valueOf(txt_newPassword.getPassword());
            String confirmNewPassword = String.valueOf(txt_confirmPassword.getPassword());

            if (newPassword.equals(confirmNewPassword)) {
                
                String username = txt_username.getText();
                String password = String.valueOf(txt_currentPassword.getPassword());
                String securePassword = Password_Util.getSecurePassword(password);

                
                if(username.isEmpty() || password.isEmpty() || securePassword.isEmpty()){
                    
                   JOptionPane.showMessageDialog(this, "All fields required", "ERROR", JOptionPane.ERROR_MESSAGE); 
                }else {
                      String query1 = "SELECT username,password FROM system_operator_master WHERE username=? and password=?";
                
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,securePassword);
                resultSet = preparedStatement.executeQuery();
                

                if (resultSet.first()) {
                    String newSecurePassword = Password_Util.getSecurePassword(newPassword);
                    String query2 = "UPDATE system_operator_master SET password=? WHERE username=?";
                    preparedStatement = connection.prepareStatement(query2);
                    preparedStatement.setString(1,newSecurePassword);
                    preparedStatement.setString(2,username);
                    
                    if(preparedStatement.executeUpdate() == 1){
                        JOptionPane.showMessageDialog(this, "Password Successfully Changed", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        clearNewPasswordAndConfirmedPassword();
                        clearUsernameAndCurrentPassword();
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "Cannot Update Password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
            
                } else {
                    JOptionPane.showMessageDialog(this, "Username or Password Incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
                    clearUsernameAndCurrentPassword();
                }
                   
                   
                }
                
                
            } else {
                JOptionPane.showMessageDialog(this, "Password and Confirm Password do not Match", "ERROR", JOptionPane.ERROR_MESSAGE);
                clearNewPasswordAndConfirmedPassword();
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChangePassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_confirmPassword;
    private javax.swing.JPasswordField txt_currentPassword;
    private javax.swing.JPasswordField txt_newPassword;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}