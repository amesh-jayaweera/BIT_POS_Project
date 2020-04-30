/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import com.itfac.bit.database.Database;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class MainNew extends javax.swing.JFrame {

    /**
     * Creates new form MainNew
     */
    String user;
    Connection con, con2;
    Statement st2, st3, stde, st4, st5, st6, st7, st8, st9,st10;
    ResultSet rs2, rs3, rs5, rs6, rs7, rs8, rs9,rs10;
    DefaultTableModel modelexp, modeldel, modelveh, modelcus, modelord, modelitm, modeldeli, modelinv;
    
    public MainNew() {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
    }

    public MainNew(String username) {
        
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false); //Disable the Resize Button  
// Disable the Close button
this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
//        this.setResizable(false); 
//        this.setLocationRelativeTo(null);
        jButton30.setVisible(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        jTextField1.setText(dateFormat.format(cal.getTime()));
        jTextField1.setEditable(false);      
        
        
//        
//        frame.addWindowListener(new java.awt.event.WindowAdapter() {
//    @Override
//    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//        if (JOptionPane.showConfirmDialog(frame, 
//            "Are you sure you want to close this window?", "Close Window?", 
//            JOptionPane.YES_NO_OPTION,
//            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
//            System.exit(0);
//        }
//    }
//});
        
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
                 
                 showErrorMsg();
            } 
        });
        
        
        
        
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setMaximumSize(DimMax);
//
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Listen for changes in the text
        txt_employeeSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
               String empID = txt_employeeSearch.getText();
               getDelData(empID);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        // Listen for changes in the text
        txt_vehicleSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String vehNo = txt_vehicleSearch.getText();
                getVehData(vehNo);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        
        // Listen for changes in the text
        txt_customerSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String cusID = txt_customerSearch.getText();
                getCusData(cusID);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        
        // Listen for changes in the text
        txt_itemSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String itemCode = txt_itemSearch.getText();
                getItemData(itemCode);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        
        // Listen for changes in the text
        txt_orderSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String orderNo = txt_orderSearch.getText();
                getOrdData(orderNo);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        
        // Listen for changes in the text
        txt_deliveryNumberSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String delNo = txt_deliveryNumberSearch.getText();
                getDeliveryData(delNo);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
        
        
        // Listen for changes in the text
        txt_invoiceSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
               String invNo = txt_invoiceSearch.getText();
               getInvData(invNo);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        
       
        
        
        // Listen for changes in the text
        txt_expenseSearch.getDocument().addDocumentListener(new DocumentListener() {
       
            public void update() {
                String formNo = txt_expenseSearch.getText();
                getExpData(formNo);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               update();
            }
        });
        

               
        try {
            con = Database.openConnection();
            modelveh = (DefaultTableModel) jTable2.getModel();
            setUserDetails(username);
            this.getDelData();
            this.getVehData();
            this.getCusData();
            this.getOrdData();
            this.getItemData();
            this.getDeliveryData();
            this.getExpData();
            this.getInvData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
    
    private void showErrorMsg(){
        JOptionPane.showMessageDialog(this, "Please sign out", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void getExpData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM expense_form_header");
            modelexp = (DefaultTableModel) jTable11.getModel();
            modelexp.setRowCount(0);
            
            while (rs3.next()) {
                if (rs3.getDate(2) != null) {
                    modelexp.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), String.valueOf(rs3.getDouble(3)), rs3.getString(4)});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getExpData(String formNo) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM expense_form_header WHERE form_No LIKE '%"+formNo+"%'");
            modelexp = (DefaultTableModel) jTable11.getModel();
            modelexp.setRowCount(0);
            
            while (rs3.next()) {
                if (rs3.getDate(2) != null) {
                    modelexp.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), String.valueOf(rs3.getDouble(3)), rs3.getString(4)});
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getInvData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM invoice_master");
            modelinv = (DefaultTableModel) jTable5.getModel();
            modelinv.setRowCount(0);
            
            while (rs3.next()) {
                modelinv.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), rs3.getString(3), String.valueOf(rs3.getDouble(4)), rs3.getString(5), rs3.getString(6)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getInvData(String invNo) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM invoice_master WHERE inv_No LIKE '%"+invNo+"%'");
            modelinv = (DefaultTableModel) jTable5.getModel();
            modelinv.setRowCount(0);
            
            while (rs3.next()) {
                modelinv.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), rs3.getString(3), String.valueOf(rs3.getDouble(4)), rs3.getString(5), rs3.getString(6)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getDeliveryData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM delivery_header");
            modeldeli = (DefaultTableModel) jTable6.getModel();
            modeldeli.setRowCount(0);
            
            while (rs3.next()) {
                modeldeli.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), rs3.getString(3), rs3.getString(4)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getDeliveryData(String delNo) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM delivery_header WHERE del_No LIKE '%"+delNo+"%'");
            modeldeli = (DefaultTableModel) jTable6.getModel();
            modeldeli.setRowCount(0);
            
            while (rs3.next()) {
                modeldeli.addRow(new Object[]{rs3.getString(1), String.valueOf(rs3.getDate(2)), rs3.getString(3), rs3.getString(4)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getVehData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM vehicle_master");
            modelveh = (DefaultTableModel) jTable2.getModel();
            modelveh.setRowCount(0);
            
            while (rs3.next()) {
                modelveh.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getVehData(String vehNo) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM vehicle_master WHERE veh_No LIKE '%"+vehNo+"%'");
            modelveh = (DefaultTableModel) jTable2.getModel();
            modelveh.setRowCount(0);
            
            while (rs3.next()) {
                modelveh.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getOrdData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM orders_header");
            modelord = (DefaultTableModel) tblord.getModel();
            modelord.setRowCount(0);
            
            while (rs3.next()) {
                modelord.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getDouble(3), rs3.getDouble(4), rs3.getString(5), rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getString(9)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getOrdData(String orderNo) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM orders_header WHERE ord_No LIKE '%"+orderNo+"%'");
            modelord = (DefaultTableModel) tblord.getModel();
            modelord.setRowCount(0);
            
            while (rs3.next()) {
                modelord.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getDouble(3), rs3.getDouble(4), rs3.getString(5), rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getString(9)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getDelData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM delivery_representative_master");
            modeldel = (DefaultTableModel) tbldel.getModel();
            modeldel.setRowCount(0);

            while (rs3.next()) {
                modeldel.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getInt(5), rs3.getString(6), rs3.getString(7)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getDelData(String empID) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM delivery_representative_master WHERE emp_ID LIKE '%"+empID+"%'");
            modeldel = (DefaultTableModel) tbldel.getModel();
            modeldel.setRowCount(0);

            while (rs3.next()) {
                modeldel.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getInt(5), rs3.getString(6), rs3.getString(7)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getItemData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM item_master");
            modelitm = (DefaultTableModel) tblitm.getModel();
            modelitm.setRowCount(0);
            
            while (rs3.next()) {
                modelitm.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getInt(3), rs3.getString(5), rs3.getDouble(4)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getItemData(String itemCode) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM item_master WHERE item_Code LIKE '%"+itemCode+"%'");
            modelitm = (DefaultTableModel) tblitm.getModel();
            modelitm.setRowCount(0);
            
            while (rs3.next()) {
                modelitm.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getInt(3), rs3.getString(5), rs3.getDouble(4)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getCusData() {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM customer_master");
            modelcus = (DefaultTableModel) jTable3.getModel();
            modelcus.setRowCount(0);
            
            while (rs3.next()) {
                modelcus.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6), rs3.getInt(12), rs3.getString(11), rs3.getString(13), rs3.getString(7), rs3.getString(8), rs3.getString(9), rs3.getString(10)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void getCusData(String cusID) {
        try {
            st3 = con.createStatement();
            rs3 = st3.executeQuery("SELECT * FROM customer_master WHERE cus_ID LIKE '%"+cusID+"%'");
            modelcus = (DefaultTableModel) jTable3.getModel();
            modelcus.setRowCount(0);
            
            while (rs3.next()) {
                modelcus.addRow(new Object[]{rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6), rs3.getInt(12), rs3.getString(11), rs3.getString(13), rs3.getString(7), rs3.getString(8), rs3.getString(9), rs3.getString(10)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    public void setUserDetails(String usna) {
        user = usna;
        jTextField6.setText(usna);
        
        if (usna.equals("Admin")) {
            jButton30.setVisible(true);
        }
        
        try {
            st2 = con.createStatement();
            rs2 = st2.executeQuery("SELECT * FROM system_operator_master WHERE username = '" + user + "'");
            
            if (rs2.next()) {
                jTextField3.setText(rs2.getString(1));
                jTextField4.setText(rs2.getString(2));
                jTextField5.setText(rs2.getString(3));

            }
            
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldel = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_employeeSearch = new javax.swing.JTextField();
        btn_employeeSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_vehicleSearch = new javax.swing.JTextField();
        btn_vehicleSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_customerSearch = new javax.swing.JTextField();
        btn_customerSearch = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblitm = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_itemSearch = new javax.swing.JTextField();
        btn_itemSearch = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblord = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_orderSearch = new javax.swing.JTextField();
        btn_orderSearch = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txt_deliveryNumberSearch = new javax.swing.JTextField();
        btn_deliveryNumberSearch = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton24 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txt_invoiceSearch = new javax.swing.JTextField();
        btn_invoiceSearch = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txt_expenseSearch = new javax.swing.JTextField();
        btn_expenseSearch = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);

        jPanel12.setBackground(new java.awt.Color(218, 247, 220));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 88, 50));
        jLabel15.setText("ORDER PROCESSING AND EXPENSE MANAGEMENT SYSTEM");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 153));
        jLabel6.setText("Date");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/itfac/bit/companylogo.jpg"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 153));
        jLabel12.setText("Tel    : +94 11 2700988 , +94 77 7734234");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fax   : +94 11 2701636");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 102, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Email : csp@cic.lk");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(213, 213, 213)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(376, 376, 376))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(64, 224, 208));

        jTabbedPane1.setBackground(new java.awt.Color(97, 212, 179));

        jPanel1.setBackground(new java.awt.Color(97, 212, 179));

        jTextArea1.setBackground(new java.awt.Color(218, 247, 220));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 88, 50));
        jTextArea1.setRows(5);
        jTextArea1.setText("\t   WELCOME TO THE\n\tORDER PROCESSING AND\n      EXPENSE MANAGEMENT SYSTEM\n\t\t OF\n      CISCO SPECIALITY PACKAGING\n\t       PVT LTD");
        jScrollPane8.setViewportView(jTextArea1);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 102, 153));
        jLabel16.setText("Employee ID");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 102, 153));
        jLabel17.setText("Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 102, 153));
        jLabel18.setText("Username");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(51, 102, 153));
        jButton28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton28.setForeground(java.awt.Color.white);
        jButton28.setText("Change User Password");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 103, 125));
        jButton29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton29.setForeground(java.awt.Color.white);
        jButton29.setText("Sign-Out");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 88, 50));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton30.setForeground(java.awt.Color.white);
        jButton30.setText("Create New Account");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(220, 220, 220))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton29)
                .addGap(268, 268, 268))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton30))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton29)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(97, 212, 179));

        tbldel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Contact No", "Email", "Type", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbldel);

        jButton10.setText("Add New");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel9.setText("Employee ID");

        btn_employeeSearch.setText("Search");
        btn_employeeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeeSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jButton10)
                        .addGap(142, 142, 142)
                        .addComponent(jButton12)
                        .addGap(137, 137, 137)
                        .addComponent(jButton11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_employeeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_employeeSearch)
                .addGap(22, 985, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employeeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_employeeSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Delivery Representative", jPanel2);

        jPanel3.setBackground(new java.awt.Color(97, 212, 179));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Brand", "Model", "Type", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton13.setText("Add New");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Delete");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel10.setText("Vehicle Number");

        btn_vehicleSearch.setText("Search");
        btn_vehicleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vehicleSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jButton13)
                        .addGap(150, 150, 150)
                        .addComponent(jButton14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_vehicleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_vehicleSearch)
                .addGap(27, 957, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_vehicleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btn_vehicleSearch))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton13))
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Vehicle", jPanel3);

        jPanel4.setBackground(new java.awt.Color(97, 212, 179));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Address1", "Address2", "Address3", "Contact No", "Email", "Fax", "Delivery Ad1", "Delivery Ad2", "Delivery Ad3", "District"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton15.setText("Add New");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel11.setText("Customer ID");

        btn_customerSearch.setText("Search");
        btn_customerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customerSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jButton15)
                        .addGap(153, 153, 153)
                        .addComponent(jButton17)
                        .addGap(162, 162, 162)
                        .addComponent(jButton16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_customerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_customerSearch)
                .addGap(29, 977, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_customerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customerSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(jButton17)))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Customer", jPanel4);

        jPanel13.setBackground(new java.awt.Color(97, 212, 179));

        tblitm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Quantity In Hand", "Unit", "Unit Price"
            }
        ));
        jScrollPane7.setViewportView(tblitm);

        jButton18.setText("Add New Item");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton31.setText("Record Item Received Details");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton19.setText("Update Item");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton33.setText("Generate Stock Status Report");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jLabel22.setText("Item Code");

        btn_itemSearch.setText("Search");
        btn_itemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_itemSearchActionPerformed(evt);
            }
        });

        jButton43.setText("Show All");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Delete Item");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_itemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_itemSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton43)
                .addGap(26, 26, 26))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton18)
                .addGap(69, 69, 69)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(jButton44)
                .addGap(62, 62, 62)
                .addComponent(jButton31)
                .addGap(57, 57, 57)
                .addComponent(jButton33)
                .addGap(53, 53, 53))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_itemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_itemSearch)
                    .addComponent(jButton43))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton33)
                    .addComponent(jButton31)
                    .addComponent(jButton44))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Item", jPanel13);

        jPanel5.setBackground(new java.awt.Color(97, 212, 179));

        tblord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Date", "Total", "Grand Total", "Delivery Required", "Order Status", "Customer ID", "Delivery No", "District Code"
            }
        ));
        jScrollPane4.setViewportView(tblord);

        jButton20.setText("Place Order");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Update Order");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton23.setText("Cancel Order");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton32.setText("View Details");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jLabel5.setText("Order Number");

        btn_orderSearch.setText("Search");
        btn_orderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderSearchActionPerformed(evt);
            }
        });

        jButton4.setText("Show All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addGap(105, 105, 105)
                .addComponent(jButton32)
                .addGap(107, 107, 107)
                .addComponent(jButton21)
                .addGap(87, 87, 87)
                .addComponent(jButton23)
                .addGap(174, 174, 174))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_orderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_orderSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_orderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_orderSearch)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton23)
                    .addComponent(jButton32))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Orders", jPanel5);

        jPanel7.setBackground(new java.awt.Color(97, 212, 179));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Date", "Status", "Expense Slip Status"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jButton22.setText("Assign Delivery Resources");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton34.setText("View Details");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel20.setText("Delivery Number");

        btn_deliveryNumberSearch.setText("Search");
        btn_deliveryNumberSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deliveryNumberSearchActionPerformed(evt);
            }
        });

        jButton39.setText("Show All");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jButton22)
                        .addGap(157, 157, 157)
                        .addComponent(jButton34)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_deliveryNumberSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_deliveryNumberSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton39)
                .addGap(26, 26, 26))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_deliveryNumberSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deliveryNumberSearch)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton34))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Delivery", jPanel7);

        jPanel6.setBackground(new java.awt.Color(97, 212, 179));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Date", "Time", "Total", "Notes", "Order No"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jButton24.setText("Generate Invoice");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel19.setText("Invoice Number");

        btn_invoiceSearch.setText("Search");
        btn_invoiceSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_invoiceSearchActionPerformed(evt);
            }
        });

        jButton37.setText("Show All");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(jButton24)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_invoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_invoiceSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton37)
                .addGap(25, 25, 25))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_invoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_invoiceSearch)
                    .addComponent(jButton37))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Invoice", jPanel6);

        jPanel8.setBackground(new java.awt.Color(97, 212, 179));

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Date", "Expense Total", "Delivery No"
            }
        ));
        jScrollPane11.setViewportView(jTable11);

        jButton25.setText("Generate Expense Form");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Record Expense Details");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Generate Payment Slip");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel21.setText("Expense Form Number");

        btn_expenseSearch.setText("Search");
        btn_expenseSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_expenseSearchActionPerformed(evt);
            }
        });

        jButton41.setText("Show All");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton25)
                        .addGap(115, 115, 115)
                        .addComponent(jButton26)
                        .addGap(116, 116, 116)
                        .addComponent(jButton27)
                        .addGap(0, 409, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_expenseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_expenseSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton41)
                .addGap(27, 27, 27))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_expenseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_expenseSearch)
                    .addComponent(jButton41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton26)
                    .addComponent(jButton27))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Expense Form", jPanel8);

        jPanel9.setBackground(new java.awt.Color(97, 212, 179));

        jPanel10.setBackground(new java.awt.Color(218, 247, 220));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monthly Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel2.setText("Report Type");

        jLabel3.setText("Month");

        jLabel4.setText("Year");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sales Report", "Expense Report", "Items Sold Report" }));
        jComboBox1.setSelectedIndex(-1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox2.setSelectedIndex(-1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        jComboBox3.setSelectedIndex(-1);

        jButton1.setText("Generate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 174, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(218, 247, 220));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yearly Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel8.setText("Report Type");

        jLabel7.setText("Year");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sales Report", "Expense Report", "Items Sold Report" }));
        jComboBox4.setSelectedIndex(-1);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        jComboBox5.setSelectedIndex(-1);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton2.setText("Generate Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, 0, 174, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel9);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        ChangePassword cp = new ChangePassword();
        cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cp.setVisible(true);
        cp.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");

        Login ll = new Login();
        ll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ll.setVisible(true);
        ll.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        NewAccount nu = new NewAccount();
        nu.setVisible(true);
        nu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        DelRep dr = new DelRep(this);
        dr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dr.setVisible(true);
        dr.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (tbldel.getRowCount() != 0) {
            if (tbldel.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String status = String.valueOf(tbldel.getModel().getValueAt(tbldel.getSelectedRow(), 6));
                if (status.equals("Available")) {
                    int res = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Delete The  Selected Record ?", "DELETE", JOptionPane.YES_NO_OPTION);
                    if (res == 0) {
                        try {
                            String de = String.valueOf(tbldel.getModel().getValueAt(tbldel.getSelectedRow(), 0));
                            stde = con.createStatement();
                            stde.executeUpdate("DELETE FROM delivery_representative_master WHERE emp_ID = '" + de + "'");
                            modeldel.removeRow(tbldel.getSelectedRow());
                            JOptionPane.showMessageDialog(this, "Record Has Been Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        } catch (HeadlessException | SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                            System.out.println(ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This Delivery Representative Record Cannot be Deleted. Status - Not Available", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Delete", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (tbldel.getRowCount() != 0) {
            if (tbldel.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String de = String.valueOf(tbldel.getModel().getValueAt(tbldel.getSelectedRow(), 0));
                DelRepUpdate dru = new DelRepUpdate(this, de);
                dru.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dru.setVisible(true);
                dru.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Update", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btn_employeeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeeSearchActionPerformed
        String empID = txt_employeeSearch.getText();
        getDelData(empID);
        txt_employeeSearch.setText("");
    }//GEN-LAST:event_btn_employeeSearchActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Vehicle veh = new Vehicle(this);
        veh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        veh.setVisible(true);
        veh.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (jTable2.getRowCount() != 0) {
            if (jTable2.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String status = String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 4));
                if (status.equals("Available")) {
                    int res = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Delete The  Selected Record ?", "DELETE", JOptionPane.YES_NO_OPTION);
                    if (res == 0) {
                        try {
                            String de = String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0));
                            st4 = con.createStatement();
                            st4.executeUpdate("DELETE FROM vehicle_master WHERE veh_No = '" + de + "'");
                            modelveh.removeRow(jTable2.getSelectedRow());
                            JOptionPane.showMessageDialog(this, "Record Has Been Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                            System.out.println(ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This Vehicle Record Cannot be Deleted. Status - Not Available", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Delete", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btn_vehicleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vehicleSearchActionPerformed
        String vehNo = txt_vehicleSearch.getText();
        getVehData(vehNo);
        txt_vehicleSearch.setText("");
    }//GEN-LAST:event_btn_vehicleSearchActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        CustomerUI cus = new CustomerUI(this);
        cus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cus.setVisible(true);
        cus.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (jTable3.getRowCount() != 0) {
            if (jTable3.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                int res = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Delete The  Selected Record ?", "DELETE", JOptionPane.YES_NO_OPTION);
                if (res == 0) {
                    try {
                        String de = String.valueOf(jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0));
                        st4 = con.createStatement();
                        st4.executeUpdate("DELETE FROM customer_master WHERE cus_ID = '" + de + "'");
                        modelcus.removeRow(jTable3.getSelectedRow());
                        JOptionPane.showMessageDialog(this, "Record Has Been Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.out.println(ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Delete", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (jTable3.getRowCount() != 0) {
            if (jTable3.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String de = String.valueOf(jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0));
                CustomerUpdate cu = new CustomerUpdate(this, de);
                cu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cu.setVisible(true);
                cu.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Update", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btn_customerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customerSearchActionPerformed
        String cusID = txt_customerSearch.getText();
        getCusData(cusID);
        txt_customerSearch.setText("");
    }//GEN-LAST:event_btn_customerSearchActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Item it = new Item(this);
        it.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        it.setVisible(true);
        it.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        ItemReceived ir = new ItemReceived(this);
        ir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (tblitm.getRowCount() != 0) {
            if (tblitm.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String de = String.valueOf(tblitm.getModel().getValueAt(tblitm.getSelectedRow(), 0));
                ItemUpdate iu = new ItemUpdate(this, de);
                iu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                iu.setVisible(true);
                iu.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Update", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        generateStockStatusReport();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void btn_itemSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_itemSearchActionPerformed
        String itemCode = txt_itemSearch.getText();
        getItemData(itemCode);
        txt_itemSearch.setText("");
    }//GEN-LAST:event_btn_itemSearchActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        getItemData();
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        if (tblitm.getRowCount() != 0) {
            if (tblitm.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                int res = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Delete The  Selected Record ?", "DELETE", JOptionPane.YES_NO_OPTION);
                if (res == 0) {
                    try {
                        String de = String.valueOf(tblitm.getModel().getValueAt(tblitm.getSelectedRow(), 0));
                        st10 = con.createStatement();
                        st10.executeUpdate("DELETE FROM item_master WHERE item_Code = '" + de + "'");
                        modelitm.removeRow(tblitm.getSelectedRow());
                        JOptionPane.showMessageDialog(this, "Record Has Been Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.out.println(ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Delete", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Order or = new Order(this);
        or.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        or.setVisible(true);
        or.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (tblord.getRowCount() != 0) {
            if (tblord.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String ordStatus = String.valueOf(tblord.getModel().getValueAt(tblord.getSelectedRow(), 5));

                if (ordStatus.equals("Placed")) {
                    String de = String.valueOf(tblord.getModel().getValueAt(tblord.getSelectedRow(), 0));
                    OrderUpNew orup = new OrderUpNew(this, de);
                    orup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    orup.setVisible(true);
                    orup.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(this, "This order cannot be updated", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Update", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (tblord.getRowCount() != 0) {
            if (tblord.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String ordStatus = String.valueOf(tblord.getModel().getValueAt(tblord.getSelectedRow(), 5));
                if (ordStatus.equals("Placed")) {
                    int res = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Cancel This Order ?", "DELETE", JOptionPane.YES_NO_OPTION);
                    if (res == 0) {
                        try {
                            String de = String.valueOf(tblord.getModel().getValueAt(tblord.getSelectedRow(), 0));
                            st8 = con.createStatement();
                            st8.executeUpdate("UPDATE orders_header SET ord_Status = 'Cancelled' WHERE ord_No = '" + de + "'");
                            modelord.removeRow(tblord.getSelectedRow());
                            JOptionPane.showMessageDialog(this, "Record Has Been Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                            System.out.println(ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This order cannot be Cancelled", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Records Available to Delete", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        if (tblord.getRowCount() != 0) {
            if (tblord.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String de = String.valueOf(tblord.getModel().getValueAt(tblord.getSelectedRow(), 0));
                ViewOrder vo = new ViewOrder(this, de);
                vo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                vo.setVisible(true);
                vo.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Table is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void btn_orderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderSearchActionPerformed
        String orderNo = txt_orderSearch.getText();
        getOrdData(orderNo);
        txt_orderSearch.setText("");
    }//GEN-LAST:event_btn_orderSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        getOrdData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        DelResoNew dreso = new DelResoNew(this);
        dreso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dreso.setVisible(true);
        dreso.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        if (jTable6.getRowCount() != 0) {
            if (jTable6.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String de = String.valueOf(jTable6.getModel().getValueAt(jTable6.getSelectedRow(), 0));
                ViewDelivery vd = new ViewDelivery(this, de);
                vd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                vd.setVisible(true);
                vd.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Table is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void btn_deliveryNumberSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deliveryNumberSearchActionPerformed
        String delNo = txt_deliveryNumberSearch.getText();
        getDeliveryData(delNo);
        txt_deliveryNumberSearch.setText("");
    }//GEN-LAST:event_btn_deliveryNumberSearchActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        getDeliveryData();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        Invoice inv = new Invoice(this);
        inv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inv.setVisible(true);
        inv.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void btn_invoiceSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_invoiceSearchActionPerformed
        String invNo = txt_invoiceSearch.getText();
        getInvData(invNo);
        txt_invoiceSearch.setText("");
    }//GEN-LAST:event_btn_invoiceSearchActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        getInvData();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        ExpenseForm ef = new ExpenseForm(this);
        ef.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ef.setVisible(true);
        ef.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        ExpenseNew en = new ExpenseNew(this);
        en.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        en.setVisible(true);
        en.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        PaymentSlip ps = new PaymentSlip(this);
        ps.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ps.setVisible(true);
        ps.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void btn_expenseSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_expenseSearchActionPerformed
        String formNo = txt_expenseSearch.getText();
        getExpData(formNo);
        txt_expenseSearch.setText("");
    }//GEN-LAST:event_btn_expenseSearchActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        getExpData();
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSelectedIndex() != -1) {
            if (jComboBox2.getSelectedIndex() != -1) {
                if (jComboBox3.getSelectedIndex() != -1) {
                    generateMonthlyReport();
                    jComboBox1.setSelectedIndex(-1);
                    jComboBox2.setSelectedIndex(-1);
                    jComboBox3.setSelectedIndex(-1);
                } else {
                    JOptionPane.showMessageDialog(this, "Please Select a Year", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select a Month", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Report Type", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jComboBox4.getSelectedIndex() != -1) {
            if (jComboBox5.getSelectedIndex() != -1) {
                generateYearlyReport();
                jComboBox4.setSelectedIndex(-1);
                jComboBox5.setSelectedIndex(-1);
            } else {
                JOptionPane.showMessageDialog(this, "Please Select a Year", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Report Type", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void generateMonthlyReport() {
        String reportType = String.valueOf(jComboBox1.getSelectedItem());
        String month = String.valueOf(jComboBox2.getSelectedItem());
        String year = String.valueOf(jComboBox3.getSelectedItem());

        if (reportType.equals("Sales Report")) {
            generateSalesReport(month, year);
        }

        if (reportType.equals("Expense Report")) {
            generateExpenseReport(month, year);
        }

        if (reportType.equals("Items Sold Report")) {
            generateItemsSoldReport(month, year);
        }
    }

    private void generateYearlyReport() {
        String reportType = String.valueOf(jComboBox4.getSelectedItem());
        String year = String.valueOf(jComboBox5.getSelectedItem());

        if (reportType.equals("Sales Report")) {
            generateSalesReport(year);
        }

        if (reportType.equals("Expense Report")) {
            generateExpenseReport(year);
        }

        if (reportType.equals("Items Sold Report")) {
            generateItemsSoldReport(year);
        }
    }

    private int getIntMonth(String month) {
        int intMonth = 0;
        switch (month) {
            case "Janaury":
                intMonth = 1;
                break;
            case "February":
                intMonth = 2;
                break;
            case "March":
                intMonth = 3;
                break;
            case "April":
                intMonth = 4;
                break;
            case "May":
                intMonth = 5;
                break;
            case "June":
                intMonth = 6;
                break;
            case "July":
                intMonth = 7;
                break;
            case "August":
                intMonth = 8;
                break;
            case "September":
                intMonth = 9;
                break;
            case "October":
                intMonth = 10;
                break;
            case "Novemebr":
                intMonth = 11;
                break;
            case "Decemebr":
                intMonth = 12;
                break;
        }

        return intMonth;
    }

    private void generateStockStatusReport() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());
        String appendNumber = reportDate.replace("/", "-");

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("StockStatusReport-" + appendNumber + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Stock Status Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));

            PdfPTable table = new PdfPTable(6); // 6 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Item Code"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Item Name"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Quantity In Hand"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Unit"));
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_LEFT);
            cell4.setFixedHeight(30f);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Unit Price (Rs.)"));
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_LEFT);
            cell5.setFixedHeight(30f);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Item Total (Rs.)"));
            cell6.setPaddingLeft(10);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_LEFT);
            cell6.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);

            st5 = con.createStatement();
            String query = "SELECT * FROM item_master";
            rs5 = st5.executeQuery(query);

            Double total = 0.0;

            while (rs5.next()) {
                String itemCode = rs5.getString(1);
                String itemName = rs5.getString(2);
                int qty = rs5.getInt(3);
                String unit = rs5.getString(5);
                Double unitPrice = rs5.getDouble(4);
                Double itemTotal = qty * unitPrice;
                total = total + itemTotal;

                PdfPCell cell7 = new PdfPCell(new Paragraph(itemCode));
                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_LEFT);
                cell7.setFixedHeight(30f);

                PdfPCell cell8 = new PdfPCell(new Paragraph(itemName));
                cell8.setPaddingLeft(10);
                cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell8.setVerticalAlignment(Element.ALIGN_LEFT);
                cell8.setFixedHeight(30f);

                PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(qty)));
                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_LEFT);
                cell9.setFixedHeight(30f);

                PdfPCell cell10 = new PdfPCell(new Paragraph(unit));
                cell10.setPaddingLeft(10);
                cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell10.setVerticalAlignment(Element.ALIGN_LEFT);
                cell10.setFixedHeight(30f);

                PdfPCell cell11 = new PdfPCell(new Paragraph(String.valueOf(unitPrice)));
                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_LEFT);
                cell11.setFixedHeight(30f);

                PdfPCell cell12 = new PdfPCell(new Paragraph(String.valueOf(itemTotal)));
                cell12.setPaddingLeft(10);
                cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell12.setVerticalAlignment(Element.ALIGN_LEFT);
                cell12.setFixedHeight(30f);

                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total : " + total);
            p1.setSpacingBefore(20f);
            p1.setSpacingAfter(20f);
            document.add(p1);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("StockStatusReport-" + appendNumber + ".pdf"));
        } catch (DocumentException | IOException | SQLException e) {
            
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + System.getProperty("user.dir"), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateItemsSoldReport(String month, String year) {
        int intMonth = getIntMonth(month);
        HashMap<String, Integer> hmap = new HashMap<>();
        // HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ItemsSoldReport-" + month + "-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Items Sold Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Month : " + month));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(6); // 6 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Item Code"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Item Name"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Quantity Sold"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Unit"));
            cell6.setPaddingLeft(10);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_LEFT);
            cell6.setFixedHeight(30f);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Unit Prie (Rs.)"));
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_LEFT);
            cell4.setFixedHeight(30f);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Total Amount (Rs.)"));
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_LEFT);
            cell5.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell6);
            table.addCell(cell4);
            table.addCell(cell5);

            st5 = con.createStatement();
            String query1 = "SELECT * FROM orders_header WHERE ord_Status = 'Completed'";
            rs5 = st5.executeQuery(query1);

            while (rs5.next()) {
                String orderNo = rs5.getString(1);

                Date date = rs5.getDate(2);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                int dbMonth = calendar.get(Calendar.MONTH) + 1;
                int dbYear = calendar.get(Calendar.YEAR);

                if (dbMonth == intMonth && dbYear == Integer.parseInt(year)) {
                    st6 = con.createStatement();
                    String query2 = "SELECT * FROM orders_details WHERE ord_No = '" + orderNo + "'";
                    rs6 = st6.executeQuery(query2);

                    while (rs6.next()) {
                        String itemCode = rs6.getString(2);
                        int qty = rs6.getInt(3);

                        if (hmap.containsKey(itemCode)) {
                            int previousQty = hmap.get(itemCode);
                            int newQty = previousQty + qty;
                            hmap.remove(itemCode);
                            hmap.put(itemCode, newQty);
                        } else {
                            hmap.put(itemCode, qty);
                        }

                    }
                }
            }
            
            Map<String, Integer> map = new TreeMap<String, Integer>(hmap);
            Set set2 = map.entrySet();
            Iterator iterator2 = set2.iterator();

            String itemName = "";
            String unit = "";
            Double unitPrice = 0.0;
            Double itemTotal = 0.0;
            Double allTotal = 0.0;

            while (iterator2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) iterator2.next();
                String itemCode = mentry2.getKey().toString();
                int qtySold = Integer.parseInt(mentry2.getValue().toString());
                st7 = con.createStatement();
                String query3 = "SELECT * FROM item_master WHERE item_Code = '" + itemCode + "'";
                rs7 = st7.executeQuery(query3);

                while (rs7.next()) {
                    itemName = rs7.getString(2);
                    unit = rs7.getString(5);
                    unitPrice = rs7.getDouble(4);
                }

                itemTotal = unitPrice * qtySold;
                allTotal = allTotal + itemTotal;

                PdfPCell cell7 = new PdfPCell(new Paragraph(itemCode));
                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_LEFT);
                cell7.setFixedHeight(30f);

                PdfPCell cell8 = new PdfPCell(new Paragraph(itemName));
                cell8.setPaddingLeft(10);
                cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell8.setVerticalAlignment(Element.ALIGN_LEFT);
                cell8.setFixedHeight(30f);

                PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(qtySold)));
                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_LEFT);
                cell9.setFixedHeight(30f);

                PdfPCell cell10 = new PdfPCell(new Paragraph(unit));
                cell10.setPaddingLeft(10);
                cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell10.setVerticalAlignment(Element.ALIGN_LEFT);
                cell10.setFixedHeight(30f);

                PdfPCell cell11 = new PdfPCell(new Paragraph(String.valueOf(unitPrice)));
                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_LEFT);
                cell11.setFixedHeight(30f);

                PdfPCell cell12 = new PdfPCell(new Paragraph(String.valueOf(itemTotal)));
                cell12.setPaddingLeft(10);
                cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell12.setVerticalAlignment(Element.ALIGN_LEFT);
                cell12.setFixedHeight(30f);

                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total : " + allTotal);
            p1.setSpacingBefore(20f);
            p1.setSpacingAfter(20f);
            document.add(p1);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("ItemsSoldReport-" + month + "-" + year + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateItemsSoldReport(String year) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ItemsSoldReport-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Items Sold Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(6); // 6 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Item Code"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Item Name"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Quantity Sold"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Unit"));
            cell6.setPaddingLeft(10);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_LEFT);
            cell6.setFixedHeight(30f);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Unit Prie (Rs.)"));
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_LEFT);
            cell4.setFixedHeight(30f);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Total Amount (Rs.)"));
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_LEFT);
            cell5.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell6);
            table.addCell(cell4);
            table.addCell(cell5);

            st5 = con.createStatement();
            String query1 = "SELECT * FROM orders_header WHERE ord_Status = 'Completed'";
            rs5 = st5.executeQuery(query1);

            while (rs5.next()) {
                String orderNo = rs5.getString(1);

                Date date = rs5.getDate(2);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                int dbYear = calendar.get(Calendar.YEAR);

                if (dbYear == Integer.parseInt(year)) {
                    st6 = con.createStatement();
                    String query2 = "SELECT * FROM orders_details WHERE ord_No = '" + orderNo + "'";
                    rs6 = st6.executeQuery(query2);

                    while (rs6.next()) {
                        String itemCode = rs6.getString(2);
                        int qty = rs6.getInt(3);

                        if (hmap.containsKey(itemCode)) {
                            int previousQty = hmap.get(itemCode);
                            int newQty = previousQty + qty;
                            hmap.remove(itemCode);
                            hmap.put(itemCode, newQty);
                        } else {
                            hmap.put(itemCode, qty);
                        }
                    }
                }
            }
            
            Map<String, Integer> map = new TreeMap<String, Integer>(hmap);
            Set set2 = map.entrySet();
            Iterator iterator2 = set2.iterator();

            String itemName = "";
            String unit = "";
            Double unitPrice = 0.0;
            Double itemTotal = 0.0;
            Double allTotal = 0.0;

            while (iterator2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) iterator2.next();
                String itemCode = mentry2.getKey().toString();
                int qtySold = Integer.parseInt(mentry2.getValue().toString());
                st7 = con.createStatement();
                String query3 = "SELECT * FROM item_master WHERE item_Code = '" + itemCode + "'";
                rs7 = st7.executeQuery(query3);

                while (rs7.next()) {
                    itemName = rs7.getString(2);
                    unit = rs7.getString(5);
                    unitPrice = rs7.getDouble(4);
                }

                itemTotal = unitPrice * qtySold;
                allTotal = allTotal + itemTotal;

                PdfPCell cell7 = new PdfPCell(new Paragraph(itemCode));
                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_LEFT);
                cell7.setFixedHeight(30f);

                PdfPCell cell8 = new PdfPCell(new Paragraph(itemName));
                cell8.setPaddingLeft(10);
                cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell8.setVerticalAlignment(Element.ALIGN_LEFT);
                cell8.setFixedHeight(30f);

                PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(qtySold)));
                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_LEFT);
                cell9.setFixedHeight(30f);

                PdfPCell cell10 = new PdfPCell(new Paragraph(unit));
                cell10.setPaddingLeft(10);
                cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell10.setVerticalAlignment(Element.ALIGN_LEFT);
                cell10.setFixedHeight(30f);

                PdfPCell cell11 = new PdfPCell(new Paragraph(String.valueOf(unitPrice)));
                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_LEFT);
                cell11.setFixedHeight(30f);

                PdfPCell cell12 = new PdfPCell(new Paragraph(String.valueOf(itemTotal)));
                cell12.setPaddingLeft(10);
                cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell12.setVerticalAlignment(Element.ALIGN_LEFT);
                cell12.setFixedHeight(30f);

                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total : " + allTotal);
            p1.setSpacingBefore(20f);
            p1.setSpacingAfter(20f);
            document.add(p1);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("ItemsSoldReport-" + year + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateSalesReport(String month, String year) {
        int intMonth = getIntMonth(month);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("SalesReport-" + month + "-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Sales Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Month : " + month));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(5); // 5 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Invoice Number"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Order Number"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);
            
            PdfPCell cell3 = new PdfPCell(new Paragraph("Order Total (Rs.)"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);
            
            PdfPCell cell4 = new PdfPCell(new Paragraph("Delivery Charge (Rs.)"));
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_LEFT);
            cell4.setFixedHeight(30f);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Invoice Total (Rs.)"));
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_LEFT);
            cell5.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            
            st5 = con.createStatement();
            String query = "SELECT * FROM invoice_master";
            rs5 = st5.executeQuery(query);

            Double total = 0.0;
            Double deliveryChargeTotal = 0.0;
            Double orderTotal = 0.0;

            while (rs5.next()) {
                String invNo = rs5.getString(1);
                String orderNo = rs5.getString(6);
                Double invTotal = rs5.getDouble(4);
                String ordNo = rs5.getString(6);
                Double ordTotal = 0.0;
                Double delCharge = 0.0;
                
                st6 = con.createStatement();
                String query2 = "SELECT * FROM orders_header WHERE ord_No = '"+ordNo+"'";
                rs6 = st6.executeQuery(query2);
                
                while(rs6.next()){
                    ordTotal = rs6.getDouble(3);
                    delCharge = rs6.getDouble(4) - rs6.getDouble(3);
                }

                Date date = rs5.getDate(2);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int dbMonth = calendar.get(Calendar.MONTH) + 1;
                int dbYear = calendar.get(Calendar.YEAR);

                if (dbMonth == intMonth && dbYear == Integer.parseInt(year)) {
                    total = total + invTotal;
                    orderTotal = orderTotal + ordTotal;
                    deliveryChargeTotal = deliveryChargeTotal + delCharge;

                    PdfPCell cell6 = new PdfPCell(new Paragraph(invNo));
                    cell6.setPaddingLeft(10);
                    cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell6.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell6.setFixedHeight(30f);

                    PdfPCell cell7 = new PdfPCell(new Paragraph(orderNo));
                    cell7.setPaddingLeft(10);
                    cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell7.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell7.setFixedHeight(30f);

                    PdfPCell cell8 = new PdfPCell(new Paragraph(String.valueOf(ordTotal)));
                    cell8.setPaddingLeft(10);
                    cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell8.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell8.setFixedHeight(30f);
                    
                    PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(delCharge)));
                    cell9.setPaddingLeft(10);
                    cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell9.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell9.setFixedHeight(30f);

                    PdfPCell cell10 = new PdfPCell(new Paragraph(String.valueOf(invTotal)));
                    cell10.setPaddingLeft(10);
                    cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell10.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell10.setFixedHeight(30f);

                    table.addCell(cell6);
                    table.addCell(cell7);
                    table.addCell(cell8);
                    table.addCell(cell9);
                    table.addCell(cell10);
                }
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total Order Value : " + orderTotal);
            Paragraph p2 = new Paragraph("Total Delivery Charges Value : " + deliveryChargeTotal);
            Paragraph p3 = new Paragraph("Total Invoice Value : " + total);
            p1.setSpacingBefore(20f);
            p3.setSpacingAfter(20f);
            document.add(p1);
            document.add(p2);
            document.add(p3);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("SalesReport-" + month + "-" + year + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateSalesReport(String year) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("SalesReport-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Sales Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(5); // 5 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Invoice Number"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Order Number"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);
            
            PdfPCell cell3 = new PdfPCell(new Paragraph("Order Total (Rs.)"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);
            
            PdfPCell cell4 = new PdfPCell(new Paragraph("Delivery Charge (Rs.)"));
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_LEFT);
            cell4.setFixedHeight(30f);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Invoice Total (Rs.)"));
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_LEFT);
            cell5.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);

            st5 = con.createStatement();
            String query = "SELECT * FROM invoice_master";
            rs5 = st5.executeQuery(query);

            Double total = 0.0;
            Double deliveryChargeTotal = 0.0;
            Double orderTotal = 0.0;

            while (rs5.next()) {
                String invNo = rs5.getString(1);
                String orderNo = rs5.getString(6);
                Double invTotal = rs5.getDouble(4);
                String ordNo = rs5.getString(6);
                Double ordTotal = 0.0;
                Double delCharge = 0.0;
                
                st6 = con.createStatement();
                String query2 = "SELECT * FROM orders_header WHERE ord_No = '"+ordNo+"'";
                rs6 = st6.executeQuery(query2);
                
                while(rs6.next()){
                    ordTotal = rs6.getDouble(3);
                    delCharge = rs6.getDouble(4) - rs6.getDouble(3);
                }

                Date date = rs5.getDate(2);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int dbYear = calendar.get(Calendar.YEAR);

                if (dbYear == Integer.parseInt(year)) {
                    total = total + invTotal;
                    orderTotal = orderTotal + ordTotal;
                    deliveryChargeTotal = deliveryChargeTotal + delCharge;

                    PdfPCell cell6 = new PdfPCell(new Paragraph(invNo));
                    cell6.setPaddingLeft(10);
                    cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell6.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell6.setFixedHeight(30f);

                    PdfPCell cell7 = new PdfPCell(new Paragraph(orderNo));
                    cell7.setPaddingLeft(10);
                    cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell7.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell7.setFixedHeight(30f);

                    PdfPCell cell8 = new PdfPCell(new Paragraph(String.valueOf(ordTotal)));
                    cell8.setPaddingLeft(10);
                    cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell8.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell8.setFixedHeight(30f);
                    
                    PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(delCharge)));
                    cell9.setPaddingLeft(10);
                    cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell9.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell9.setFixedHeight(30f);

                    PdfPCell cell10 = new PdfPCell(new Paragraph(String.valueOf(invTotal)));
                    cell10.setPaddingLeft(10);
                    cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell10.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell10.setFixedHeight(30f);

                    table.addCell(cell6);
                    table.addCell(cell7);
                    table.addCell(cell8);
                    table.addCell(cell9);
                    table.addCell(cell10);
                }
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total Order Value : " + orderTotal);
            Paragraph p2 = new Paragraph("Total Delivery Charges Value : " + deliveryChargeTotal);
            Paragraph p3 = new Paragraph("Total Invoice Value : " + total);
            p1.setSpacingBefore(20f);
            p3.setSpacingAfter(20f);
            document.add(p1);
            document.add(p2);
            document.add(p3);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("SalesReport-" + year + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateExpenseReport(String month, String year) {
        int intMonth = getIntMonth(month);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ExpenseReport-" + month + "-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Expense Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Month : " + month));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(3); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Form Number"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Delivery Number"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Total Expenses (Rs.)"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            st5 = con.createStatement();
            String query = "SELECT * FROM expense_form_header";
            rs5 = st5.executeQuery(query);

            Double total = 0.0;

            while (rs5.next()) {
                String formNo = rs5.getString(1);
                String delNo = rs5.getString(4);
                Double expenseTotal = rs5.getDouble(3);

                Date date = rs5.getDate(2);
                int dbMonth = 0;
                int dbYear = 0;

                if (date != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    dbMonth = calendar.get(Calendar.MONTH) + 1;
                    dbYear = calendar.get(Calendar.YEAR);
                } else {
                    continue;
                }

                if (dbMonth == intMonth && dbYear == Integer.parseInt(year)) {
                    total = total + expenseTotal;

                    PdfPCell cell4 = new PdfPCell(new Paragraph(formNo));
                    cell4.setPaddingLeft(10);
                    cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell4.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell4.setFixedHeight(30f);

                    PdfPCell cell5 = new PdfPCell(new Paragraph(delNo));
                    cell5.setPaddingLeft(10);
                    cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell5.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell5.setFixedHeight(30f);

                    PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(expenseTotal)));
                    cell6.setPaddingLeft(10);
                    cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell6.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell6.setFixedHeight(30f);

                    table.addCell(cell4);
                    table.addCell(cell5);
                    table.addCell(cell6);
                }
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total : " + total);
            p1.setSpacingBefore(20f);
            p1.setSpacingAfter(20f);
            document.add(p1);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("ExpenseReport-" + month + "-" + year + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void generateExpenseReport(String year) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String reportDate = dateFormat.format(cal.getTime());

        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ExpenseReport-" + year + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Expense Report", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            document.add(new Paragraph("Date : " + reportDate));
            document.add(new Paragraph("Year : " + year));

            PdfPTable table = new PdfPTable(3); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Form Number"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Delivery Number"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Total Expenses (Rs.)"));
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_LEFT);
            cell3.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            st5 = con.createStatement();
            String query = "SELECT * FROM expense_form_header";
            rs5 = st5.executeQuery(query);

            Double total = 0.0;

            while (rs5.next()) {
                String formNo = rs5.getString(1);
                String delNo = rs5.getString(4);
                Double expenseTotal = rs5.getDouble(3);

                Date date = rs5.getDate(2);
                int dbMonth = 0;
                int dbYear = 0;

                if (date != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    dbYear = calendar.get(Calendar.YEAR);
                } else {
                    continue;
                }

                if (dbYear == Integer.parseInt(year)) {
                    total = total + expenseTotal;

                    PdfPCell cell4 = new PdfPCell(new Paragraph(formNo));
                    cell4.setPaddingLeft(10);
                    cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell4.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell4.setFixedHeight(30f);

                    PdfPCell cell5 = new PdfPCell(new Paragraph(delNo));
                    cell5.setPaddingLeft(10);
                    cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell5.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell5.setFixedHeight(30f);

                    PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(expenseTotal)));
                    cell6.setPaddingLeft(10);
                    cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell6.setVerticalAlignment(Element.ALIGN_LEFT);
                    cell6.setFixedHeight(30f);

                    table.addCell(cell4);
                    table.addCell(cell5);
                    table.addCell(cell6);
                }
            }

            document.add(table);

            Paragraph p1 = new Paragraph("Total : " + total);
            p1.setSpacingBefore(20f);
            p1.setSpacingAfter(20f);
            document.add(p1);

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("ExpenseReport-" + year + ".pdf"));
        } catch (DocumentException | IOException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

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
            java.util.logging.Logger.getLogger(MainNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainNew().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_customerSearch;
    private javax.swing.JButton btn_deliveryNumberSearch;
    private javax.swing.JButton btn_employeeSearch;
    private javax.swing.JButton btn_expenseSearch;
    private javax.swing.JButton btn_invoiceSearch;
    private javax.swing.JButton btn_itemSearch;
    private javax.swing.JButton btn_orderSearch;
    private javax.swing.JButton btn_vehicleSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tbldel;
    private javax.swing.JTable tblitm;
    private javax.swing.JTable tblord;
    private javax.swing.JTextField txt_customerSearch;
    private javax.swing.JTextField txt_deliveryNumberSearch;
    private javax.swing.JTextField txt_employeeSearch;
    private javax.swing.JTextField txt_expenseSearch;
    private javax.swing.JTextField txt_invoiceSearch;
    private javax.swing.JTextField txt_itemSearch;
    private javax.swing.JTextField txt_orderSearch;
    private javax.swing.JTextField txt_vehicleSearch;
    // End of variables declaration//GEN-END:variables
}
