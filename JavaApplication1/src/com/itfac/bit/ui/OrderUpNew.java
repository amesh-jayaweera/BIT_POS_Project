/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import com.itfac.bit.database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderUpNew extends javax.swing.JFrame {

    /**
     * Creates new form OrderUpNew
     */
    Connection con;
    Statement st1, st2, st3, st4, st5, st6, st7, st8, st9, st10;
    ResultSet rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10;
    String a, b, c, d, f, g, format, format2, ba, format3, ototString, dcString, gtotString;
    DefaultTableModel modelo;
    Double ot = 0.0, del = 0.0, gt = 0.0;
    ButtonGroup bg;
    MainNew mmm;
   

    public OrderUpNew() {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
    }

    public OrderUpNew(MainNew mm, String ordNo) {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        mmm = mm;
        modelo = (DefaultTableModel) table_orders.getModel();
        bg = new ButtonGroup();
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.clearSelection();

        try {
           
            con = Database.openConnection();
            st2 = con.createStatement();
            rs2 = st2.executeQuery("SELECT * FROM orders_header WHERE ord_No = '" + ordNo + "'");
            txt_orderNumber.setText(ordNo);

            while (rs2.next()) {
                String cusID = rs2.getString(7);
                st5 = con.createStatement();
                rs5 = st5.executeQuery("SELECT * FROM customer_master WHERE cus_ID = '" + cusID + "'");

                while (rs5.next()) {
                    txt_customerID.setText(rs5.getString(1));
                    txt_firstName.setText(rs5.getString(2));
                    txt_lastName.setText(rs5.getString(3));
                    txt_addressNumber.setText(rs5.getString(4));
                    txt_addressStreet.setText(rs5.getString(5));
                    txt_addressCity.setText(rs5.getString(6));
                    txt_deliveryAddressNumber.setText(rs5.getString(7));
                    txt_deliveryAddressStreet.setText(rs5.getString(8));
                    txt_deliveryAddressCity.setText(rs5.getString(9));
                    txt_deliveryAddressDistrict.setText(rs5.getString(10));
                    txt_email.setText(rs5.getString(11));
                    txt_contactNumber.setText(String.valueOf(rs5.getInt(12)));
                    txt_faxNo.setText(String.valueOf(rs5.getInt(13)));
                }
                
                st3 = con.createStatement();
                rs3 = st3.executeQuery("SELECT item_Name FROM item_master");

                while (rs3.next()) {
                    cmb_itemName.addItem(rs3.getString(1));
                }

                cmb_itemName.setSelectedIndex(-1);

                ot = rs2.getDouble(3);
                gt = rs2.getDouble(4);
                ototString = String.valueOf(ot);
                txt_orderTotal.setText(ototString);
                txt_deliveryCharges.setText("");
                gtotString = String.valueOf(gt);
                txt_grandTotal.setText(gtotString);

                String delReq = rs2.getString(5);
                String disCode = rs2.getString(9);

                if (delReq.equals("Yes")) {
                    jRadioButton1.setSelected(true);
                    st3 = con.createStatement();
                    Double delch = 0.0;

                    st6 = con.createStatement();
                    rs6 = st6.executeQuery("SELECT del_ch FROM delivery_charges_master WHERE dis_Code = '" + disCode + "'");

                    if (rs6.next()) {
                        delch = rs6.getDouble(1);
                    }

                    dcString = String.valueOf(delch);
                    txt_deliveryCharges.setText(dcString);
                    del = Double.parseDouble(txt_deliveryCharges.getText());
                } else {
                    jRadioButton2.setSelected(true);
                    dcString = String.format("%06d", 0);
                    txt_deliveryCharges.setText(dcString);
                    del = Double.parseDouble(txt_deliveryCharges.getText());
                }

                st7 = con.createStatement();
                rs7 = st7.executeQuery("SELECT * FROM orders_details WHERE ord_No = '" + ordNo + "'");

                while (rs7.next()) {
                    modelo = (DefaultTableModel) table_orders.getModel();;
                    String in = null, ic = null, unit = null;
                    Double up = 0.0, tota1 = 0.0;

                    String itemCode = rs7.getString(2);
                    int qty = rs7.getInt(3);
                    st8 = con.createStatement();
                    rs8 = st8.executeQuery("SELECT * FROM item_master WHERE item_Code = '" + itemCode + "'");

                    if (rs8.next()) {
                        in = rs8.getString(2);
                        up = rs8.getDouble(4);
                        unit = rs8.getString(5);
                    }
                    
                    tota1 = qty * up;
                    modelo.addRow(new Object[]{itemCode, in, qty, unit, tota1});
                    cmb_itemName.removeItem(in);

                    jLabel2.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        jLabel2.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_firstName = new javax.swing.JTextField();
        txt_addressNumber = new javax.swing.JTextField();
        txt_deliveryAddressNumber = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        txt_addressStreet = new javax.swing.JTextField();
        txt_deliveryAddressStreet = new javax.swing.JTextField();
        txt_addressCity = new javax.swing.JTextField();
        txt_deliveryAddressCity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_faxNo = new javax.swing.JTextField();
        txt_deliveryAddressDistrict = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_contactNumber = new javax.swing.JTextField();
        txt_customerID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmb_itemName = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txt_orderTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_deliveryCharges = new javax.swing.JTextField();
        txt_grandTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btn_updateOrder = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        txt_orderNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 212, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(4, 19));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Order Number");

        jPanel2.setBackground(new java.awt.Color(218, 247, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("Customer ID");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 153));
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 153));
        jLabel6.setText("Delivery Address");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 153));
        jLabel7.setText("Email");

        txt_firstName.setEditable(false);

        txt_addressNumber.setEditable(false);

        txt_deliveryAddressNumber.setEditable(false);

        txt_email.setEditable(false);

        txt_lastName.setEditable(false);

        txt_addressStreet.setEditable(false);

        txt_deliveryAddressStreet.setEditable(false);

        txt_addressCity.setEditable(false);

        txt_deliveryAddressCity.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 153));
        jLabel8.setText("Contact Number");

        txt_faxNo.setEditable(false);

        txt_deliveryAddressDistrict.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 153));
        jLabel12.setText("Fax");

        txt_contactNumber.setEditable(false);
        txt_contactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactNumberActionPerformed(evt);
            }
        });

        txt_customerID.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_contactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(txt_firstName)
                                        .addComponent(txt_addressNumber)
                                        .addComponent(txt_deliveryAddressNumber)
                                        .addComponent(txt_email))
                                    .addComponent(txt_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_addressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_addressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_deliveryAddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_deliveryAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_deliveryAddressDistrict)))
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_faxNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_addressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_addressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_addressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_deliveryAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_deliveryAddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_deliveryAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_deliveryAddressDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_faxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
        );

        jPanel3.setBackground(new java.awt.Color(218, 247, 220));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(51, 102, 153));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 102, 153));
        jLabel9.setText("Item Name");

        cmb_itemName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_itemNameItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 102, 153));
        jLabel10.setText("Quantity");

        btn_add.setBackground(new java.awt.Color(0, 88, 50));
        btn_add.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_add.setForeground(java.awt.Color.white);
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(255, 103, 125));
        btn_remove.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_remove.setForeground(java.awt.Color.white);
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Quantity", "Unit", "Item Total"
            }
        ));
        jScrollPane1.setViewportView(table_orders);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 153));
        jLabel11.setText("Order Total");

        txt_orderTotal.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 153));
        jLabel13.setText("Delivery Charges");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 102, 153));
        jLabel14.setText("Grand Total");

        txt_deliveryCharges.setEditable(false);
        txt_deliveryCharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_deliveryChargesActionPerformed(evt);
            }
        });

        txt_grandTotal.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 102, 153));
        jLabel15.setText("Delivery Required");

        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 102, 153));
        jRadioButton1.setText("Yes");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 102, 153));
        jRadioButton2.setText("No");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmb_itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_remove)))
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deliveryCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_remove))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_deliveryCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        btn_updateOrder.setBackground(new java.awt.Color(0, 88, 50));
        btn_updateOrder.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_updateOrder.setForeground(java.awt.Color.white);
        btn_updateOrder.setText("Update Order");
        btn_updateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateOrderActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(51, 102, 153));
        btn_clear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_clear.setForeground(java.awt.Color.white);
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 103, 125));
        btn_cancel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_cancel.setForeground(java.awt.Color.white);
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        txt_orderNumber.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_clear)
                        .addGap(76, 76, 76)
                        .addComponent(btn_updateOrder)
                        .addGap(65, 65, 65)
                        .addComponent(btn_cancel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_orderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_orderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear)
                    .addComponent(btn_updateOrder)
                    .addComponent(btn_cancel))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactNumberActionPerformed

    private void txt_deliveryChargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deliveryChargesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deliveryChargesActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        modelo = (DefaultTableModel) table_orders.getModel();
        String in = null, ic = null, unit = null;
        Double up = 0.0, tota1 = 0.0;

        if (cmb_itemName.getSelectedIndex() != -1) {
            try {
                st3 = con.createStatement();
                String aa = cmb_itemName.getSelectedItem().toString();
                String qtyString = txt_quantity.getText();

                if (qtyString.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    int d1 = Integer.parseInt(qtyString);
                    rs3 = st3.executeQuery("SELECT * FROM item_master WHERE item_Name = '" + aa + "'");

                    if (rs3.next()) {
                        ic = rs3.getString(1);
                        in = rs3.getString(2);
                        up = rs3.getDouble(4);
                        unit = rs3.getString(5);
                    }
                    tota1 = d1 * up;
                    modelo.addRow(new Object[]{ic, in, d1, unit, tota1});

                    ot = ot + tota1;
                    txt_orderTotal.setText(String.valueOf(ot));
                    del = Double.parseDouble(txt_deliveryCharges.getText());
                    txt_grandTotal.setText(String.valueOf(ot + del));
                    
                    cmb_itemName.removeItem(aa);
                    cmb_itemName.setSelectedIndex(-1);
                    txt_quantity.setText("");
                    jLabel2.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an Item", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        try {
            st3 = con.createStatement();
            String aa = txt_deliveryAddressDistrict.getText();
            Double delch = 0.0;

            rs3 = st3.executeQuery("SELECT del_ch FROM delivery_charges_master WHERE district = '" + aa + "'");

            if (rs3.next()) {
                delch = rs3.getDouble(1);
            }

            txt_deliveryCharges.setText(String.valueOf(delch));
            del = Double.parseDouble(txt_deliveryCharges.getText());
            txt_grandTotal.setText(String.valueOf(ot + del));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txt_deliveryCharges.setText(String.format("%06d", 0));
        del = Double.parseDouble(txt_deliveryCharges.getText());
        txt_grandTotal.setText(String.valueOf(ot + del));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        if (table_orders.getSelectedRow() != -1) {
            if (table_orders.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String aa = String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(), 4));
                double ab = Double.parseDouble(aa);
                ot = ot - ab;
                txt_grandTotal.setText(String.valueOf(ot + del));
                txt_orderTotal.setText(String.valueOf(ot));
                
                String itemName = String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(), 1));
                cmb_itemName.addItem(itemName);
                modelo.removeRow(table_orders.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void cmb_itemNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_itemNameItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            try {
                st4 = con.createStatement();
                String aa = cmb_itemName.getSelectedItem().toString();
                String unit = "";

                rs4 = st4.executeQuery("SELECT * FROM item_master WHERE item_Name = '" + aa + "'");

                if (rs4.next()) {
                    unit = rs4.getString(5);
                }
                jLabel2.setText(unit);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cmb_itemNameItemStateChanged

    private void btn_updateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateOrderActionPerformed
        try {
            String ordNo = txt_orderNumber.getText();
            Double ot = Double.parseDouble(txt_orderTotal.getText());
            Double gt = Double.parseDouble(txt_grandTotal.getText());
            String del = "";

            if (jRadioButton1.isSelected()) {
                del = jRadioButton1.getText();
            }
            if (jRadioButton2.isSelected()) {
                del = jRadioButton2.getText();
            }

            int rows = table_orders.getRowCount();
            if (rows != 0) {
                String query1 = "UPDATE orders_header SET ord_Total = '" + ot + "', grand_Total = '" + gt + "', del_Req = '" + del + "' WHERE ord_No = '" + ordNo + "'";

                st2 = con.createStatement();
                st2.executeUpdate(query1);

                st4 = con.createStatement();
                String query4 = "DELETE FROM orders_details WHERE ord_No = '" + ordNo + "'";
                st4.executeUpdate(query4);

                for (int i = 0; i < rows; i++) {
                    String aa = String.valueOf(table_orders.getValueAt(i, 0));
                    String ab = String.valueOf(table_orders.getValueAt(i, 2));
                    String query2 = "INSERT INTO orders_details VALUES('" + ordNo + "','" + aa + "','" + ab + "')";
                    st3 = con.createStatement();
                    st3.executeUpdate(query2);
                }

                JOptionPane.showMessageDialog(this, "Order Successfully Updated", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                mmm.getOrdData();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Order Should Contain Atleast One Item", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btn_updateOrderActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        cmb_itemName.setSelectedIndex(-1);
        txt_quantity.setText("");
        txt_orderTotal.setText(String.format("%06d", 0));
        txt_deliveryCharges.setText(String.format("%06d", 0));
        txt_grandTotal.setText(String.format("%06d", 0));
        bg.clearSelection();
        
        int rows = table_orders.getRowCount();
        for (int i = 0; i < rows; i++) {
            String itemName = String.valueOf(table_orders.getValueAt(i, 1));
            cmb_itemName.addItem(itemName);
        }
        
        modelo.setRowCount(0);
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(OrderUpNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderUpNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderUpNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderUpNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderUpNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_updateOrder;
    private javax.swing.JComboBox cmb_itemName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_orders;
    private javax.swing.JTextField txt_addressCity;
    private javax.swing.JTextField txt_addressNumber;
    private javax.swing.JTextField txt_addressStreet;
    private javax.swing.JTextField txt_contactNumber;
    private javax.swing.JTextField txt_customerID;
    private javax.swing.JTextField txt_deliveryAddressCity;
    private javax.swing.JTextField txt_deliveryAddressDistrict;
    private javax.swing.JTextField txt_deliveryAddressNumber;
    private javax.swing.JTextField txt_deliveryAddressStreet;
    private javax.swing.JTextField txt_deliveryCharges;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_faxNo;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_grandTotal;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_orderNumber;
    private javax.swing.JTextField txt_orderTotal;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
