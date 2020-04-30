/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import com.itfac.bit.database.Database;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
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
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class PaymentSlip extends javax.swing.JFrame {

    /**
     * Creates new form PaymentSlip
     */
    Connection con;
    Statement st1, st2, st3, st4, st5, st6, st7, st8, st9;
    PreparedStatement statement;
    ResultSet rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs9,resultSet;
    int res;
    DefaultTableModel modelo;
    String del2 = "";
    String emp = "";
    MainNew mmm;


    public PaymentSlip() {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
    }

    public PaymentSlip(MainNew mm) {
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        mmm = mm;
        initComponents();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            txt_date.setText(dateFormat.format(cal.getTime()));
            txt_date.setEditable(false);

            con = Database.openConnection();
            modelo = (DefaultTableModel) table_expenses.getModel();
            st9 = con.createStatement();
            rs9 = st9.executeQuery("SELECT del_No FROM delivery_header WHERE del_Status = 'Completed' AND es_Status = 'Not Generated'");
            st1 = con.createStatement();

            while (rs9.next()) {
                String ddn = rs9.getString(1);
                rs1 = st1.executeQuery("SELECT form_No FROM expense_form_header WHERE del_No = '" + ddn + "'");

                while (rs1.next()) {
                    cmb_formNumber.addItem(rs1.getString(1));
                }
            }

            cmb_formNumber.setSelectedIndex(-1);
            txt_total.setText("");
            txt_deliveryNumber.setText("");
            txt_id.setText("");
            txt_firstName.setText("");
            txt_lastName.setText("");
            txt_contactNumber.setText("");
            modelo.setRowCount(0);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_firstName = new javax.swing.JTextField();
        txt_contactNumber = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_expenses = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_deliveryNumber = new javax.swing.JTextField();
        btn_generatepaymentSlip = new javax.swing.JButton();
        cmb_formNumber = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 212, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Slip Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(4, 19));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Delivery Number");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Date");

        txt_date.setEditable(false);
        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(218, 247, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivery Representative Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 153));
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 153));
        jLabel6.setText("Contact Number");

        txt_id.setEditable(false);

        txt_firstName.setEditable(false);

        txt_contactNumber.setEditable(false);

        txt_lastName.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id)
                    .addComponent(txt_firstName)
                    .addComponent(txt_contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(218, 247, 220));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        table_expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expense Code", "Expense Description", "Amount"
            }
        ));
        jScrollPane1.setViewportView(table_expenses);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 153));
        jLabel8.setText("Total");

        txt_total.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 102, 153));
        jLabel9.setText("Form Number");

        txt_deliveryNumber.setEditable(false);
        txt_deliveryNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_deliveryNumberActionPerformed(evt);
            }
        });

        btn_generatepaymentSlip.setBackground(new java.awt.Color(0, 88, 50));
        btn_generatepaymentSlip.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_generatepaymentSlip.setForeground(java.awt.Color.white);
        btn_generatepaymentSlip.setText("Generate Payment Slip");
        btn_generatepaymentSlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generatepaymentSlipActionPerformed(evt);
            }
        });

        cmb_formNumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_formNumberItemStateChanged(evt);
            }
        });
        cmb_formNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_formNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_deliveryNumber)
                            .addComponent(cmb_formNumber, 0, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_generatepaymentSlip)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGap(84, 84, 84)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_formNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deliveryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_clear)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_generatepaymentSlip)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txt_deliveryNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deliveryNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deliveryNumberActionPerformed

    private void btn_generatepaymentSlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generatepaymentSlipActionPerformed
        try {
            String deli = txt_deliveryNumber.getText();

            st8 = con.createStatement();
            st8.executeUpdate("UPDATE delivery_header SET es_Status = 'Generated' WHERE del_No = '" + deli + "'");

            
            statement = con.prepareStatement("UPDATE delivery_header SET del_Status = 'Completed' WHERE del_No=?");
            statement.setString(1, deli);
            res = statement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Payment Slip Successfully Generated", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            createExpenseSlipPDF();
            mmm.getDeliveryData();
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_generatepaymentSlipActionPerformed

    private void createExpenseSlipPDF() {
        Document document = new Document();
        try {
            String formNo = String.valueOf(cmb_formNumber.getSelectedItem());
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ExpenseSlip-" + formNo + ".pdf"));
            document.open();

            //Add Image
            Image image1 = Image.getInstance(System.getProperty("user.dir") + "\\src\\com\\itfac\\bit\\companylogo.jpg");
            //Scale to new height and new width of image
            image1.scaleAbsolute(200, 100);
            //Add to document
            document.add(image1);

            Font blueFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(255, 0, 0, 0));
            document.add(new Paragraph("Expense Slip", blueFont));

            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));

            String del = txt_deliveryNumber.getText();
            String empId = txt_id.getText();
            String firstName = txt_firstName.getText();
            String lastName = txt_lastName.getText();
            String contactNo = txt_contactNumber.getText();

            document.add(new Paragraph("Form Number : " + formNo));
            document.add(new Paragraph("Employee ID : " + empId));
            document.add(new Paragraph("Delivery Representative Name : " + firstName + " " + lastName));
            document.add(new Paragraph("Contact Number : " + contactNo));
            document.add(new Paragraph("Delivery Number : " + del));

            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(20f); //Space before table
            table.setSpacingAfter(20f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Expense Description"));
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
            cell1.setFixedHeight(30f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Amount"));
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_LEFT);
            cell2.setFixedHeight(30f);

            table.addCell(cell1);
            table.addCell(cell2);

            int rows = table_expenses.getRowCount();

            for (int i = 0; i < rows; i++) {
                String aa = String.valueOf(table_expenses.getValueAt(i, 1));
                String ab = String.valueOf(table_expenses.getValueAt(i, 2));
                
                PdfPCell cell3 = new PdfPCell(new Paragraph(aa));
                cell3.setPaddingLeft(10);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setVerticalAlignment(Element.ALIGN_LEFT);
                cell3.setFixedHeight(30f);

                PdfPCell cell4 = new PdfPCell(new Paragraph(ab));
                cell4.setPaddingLeft(10);
                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell4.setVerticalAlignment(Element.ALIGN_LEFT);
                cell4.setFixedHeight(30f);

                table.addCell(cell3);
                table.addCell(cell4);
            }

            document.add(table);

            String total = txt_total.getText();
            document.add(new Paragraph("Expense Total : " + total));

            document.close();
            writer.close();
            Desktop.getDesktop().open(new File("ExpenseSlip-" + formNo + ".pdf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    private void cmb_formNumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_formNumberItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String desc = "";
            String delNo = "";
            String empID = "";

            try {
                String fno = String.valueOf(cmb_formNumber.getSelectedItem());
                st3 = con.createStatement();
                rs3 = st3.executeQuery("SELECT * FROM expense_form_header WHERE form_No = '" + fno + "'");
                if (rs3.next()) {
                    delNo = rs3.getString(4);
                    empID = rs3.getString(5);
                    txt_deliveryNumber.setText(delNo);
                    txt_total.setText(String.valueOf(rs3.getDouble(3)));
                }
                
                st4 = con.createStatement();
                rs4 = st4.executeQuery("SELECT * FROM delivery_representative_master WHERE emp_ID = '" + empID + "'");
                    
                
                
                
                while(rs4.next()) {
                    txt_id.setText(rs4.getString(1));
                    txt_firstName.setText(rs4.getString(2));
                    txt_lastName.setText(rs4.getString(3));
                    txt_contactNumber.setText(String.valueOf(rs4.getInt(5)));
                }

                st6 = con.createStatement();
                rs6 = st6.executeQuery("SELECT * FROM expense_form_detail WHERE form_No = '" + fno + "'");

                while (rs6.next()) {
                    String ec = rs6.getString(2);
                    String amt = String.valueOf(rs6.getDouble(3));
                    st7 = con.createStatement();
                    rs7 = st7.executeQuery("SELECT * FROM expense_type_master WHERE exp_Code = '" + ec + "'");

                    if (rs7.next()) {
                        desc = rs7.getString(2);
                    }

                    modelo.addRow(new Object[]{ec, desc, amt});
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cmb_formNumberItemStateChanged

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        cmb_formNumber.setSelectedIndex(-1);
        txt_total.setText("");
        txt_deliveryNumber.setText("");
        txt_id.setText("");
        txt_firstName.setText("");
        txt_lastName.setText("");
        txt_contactNumber.setText("");
        modelo.setRowCount(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void cmb_formNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_formNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_formNumberActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentSlip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_generatepaymentSlip;
    private javax.swing.JComboBox<String> cmb_formNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_expenses;
    private javax.swing.JTextField txt_contactNumber;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_deliveryNumber;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}