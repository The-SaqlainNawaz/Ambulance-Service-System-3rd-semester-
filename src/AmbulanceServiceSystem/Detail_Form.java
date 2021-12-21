/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Hassan Nawaz
 */
public class Detail_Form extends javax.swing.JFrame {

    CRIclass cri=CRIclass.getInst();
    ASI asi = ASI.getInst();
    private JButton butti;
    EMTs emt = null;
    Drivers driver;
    CTWOs ctwo=null;
    int size = 0;

    /**
     * Creates new form Detail_Form
     */
    public Detail_Form(Object obj, JButton button, int i) throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        Detail_Form_Function(button, obj, i);
        butti = button;
        size = i;
        asi.Show_Table_Drivers(new ASI_GUI().getjTable());

    }

    Detail_Form() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Detail_Form_Function(JButton button, Object object, int i) throws IOException, FileNotFoundException, ClassNotFoundException {

        if (object.getClass().equals(EMTs.class)) {
            EMTs obj = (EMTs) object;
            emt = obj;

            jTextField5.setText(obj.getName());
            jTextField6.setText(obj.ID_Card);
            jTextField7.setText(obj.Contact_Number);
            jTextField8.setText(obj.gender);
            String id = String.valueOf(obj.special_ID);
            jTextField9.setText(id);
            jTextField11.setText(obj.getShift());
        }

            if (button.getText() == new ASI_GUI().getjButton2().getText() || button.getText() == new ASI_GUI().getjButton3().getText() || button.getText()== new ASI_GUI().getjButton4().getText() || button.getText()== new ASI_GUI().getjButton8().getText()|| button.getText()== new CRI().getjButton4().getText()) {
                jLabel54.setVisible(false);
                jTextField10.setVisible(false);
                Update.setVisible(false);
                upadte_Profile.setVisible(false);
            }
            if (button.getText() == new ASI_GUI().getupdate().getText() || button.getText() == new ASI_GUI().getupdate1().getText()||button.getText() == new CRI().getjButton3().getText() )  {
                jLabel54.setVisible(false);
                jTextField10.setVisible(false);
                Update.setVisible(false);
                upadte_Profile.setVisible(true);
            }
        
        if (object.getClass().equals(Drivers.class)) {
            Drivers obj = (Drivers) object;
            driver = obj;

            jTextField5.setText(obj.Name);
            jTextField6.setText(obj.ID_Card);
            jTextField7.setText(obj.Contact_Number);
            jTextField8.setText(obj.gender);
            String id = String.valueOf(obj.special_ID);
            jTextField9.setText(id);
            jTextField11.setText(obj.getShift());
}
        
        if(object.getClass().equals(CTWOs.class))
        {
         CTWOs obj = (CTWOs) object;
            ctwo = obj;

            jTextField5.setText(obj.Name);
            jTextField6.setText(obj.ID_Card);
            jTextField7.setText(obj.Contact_Number);
            jTextField8.setText(obj.gender);
            String id = String.valueOf(obj.special_ID);
            jTextField9.setText(id);
            jTextField11.setText(obj.getShift());
        }

    }

    public void changecolor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
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
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        upadte_Profile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        exittt = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 100, 162));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Account Details");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 125, 25));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Full Name:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(26, 100, 162));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField5.setSelectionEnd(50);
        jTextField5.setSelectionStart(12);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 215, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID_Card:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(26, 100, 162));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField6.setSelectionEnd(50);
        jTextField6.setSelectionStart(12);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 215, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Contact No:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(26, 100, 162));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField7.setSelectionEnd(50);
        jTextField7.setSelectionStart(12);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 215, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Gender:");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(26, 100, 162));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField8.setSelectionEnd(50);
        jTextField8.setSelectionStart(12);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 215, -1));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Picture:");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        upadte_Profile.setBackground(new java.awt.Color(51, 51, 255));
        upadte_Profile.setForeground(new java.awt.Color(255, 255, 255));
        upadte_Profile.setText("Upade");
        upadte_Profile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        upadte_Profile.setBorderPainted(false);
        upadte_Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upadte_Profile.setFocusPainted(false);
        upadte_Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseExited(evt);
            }
        });
        upadte_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upadte_ProfileActionPerformed(evt);
            }
        });
        jPanel1.add(upadte_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 90, 30));

        jButton1.setBackground(new java.awt.Color(43, 43, 43));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 90, 30));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Special ID:");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(26, 100, 162));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField9.setSelectionEnd(50);
        jTextField9.setSelectionStart(12);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 210, -1));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Password:");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(26, 100, 162));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField10.setSelectionEnd(50);
        jTextField10.setSelectionStart(12);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 210, -1));

        Update.setBackground(new java.awt.Color(43, 43, 43));
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Change");
        Update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update.setBorderPainted(false);
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.setFocusPainted(false);
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 63, 30));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Shift");
        jPanel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jTextField11.setBackground(new java.awt.Color(26, 100, 162));
        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField11.setSelectionEnd(50);
        jTextField11.setSelectionStart(12);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 210, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("X");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 30, 30));

        exittt.setBackground(new java.awt.Color(52, 152, 219));
        exittt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitttexitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitttexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitttexitMouseExited(evt);
            }
        });
        exittt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(exittt, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void upadte_ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseClicked

    private void upadte_ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseEntered

    private void upadte_ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseExited

    private void upadte_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upadte_ProfileActionPerformed
        if (butti.getText().equals("Change Shift")) {
            String shift = jTextField11.getText();
            emt.setShift(shift);
            asi.getEmt_List().replaceNode(emt,size);
        }
         if (butti.getText().equals("Change_Shift")) {
            String shift = jTextField11.getText();
            driver.setShift(shift);
            asi.getDrivers_List().replaceNode(driver,size);
        } 
if (butti.getText().equals("Update")) {
            String shift = jTextField11.getText();
            ctwo.setShift(shift);
            cri.getCtwo_List().replaceNode(ctwo, size);

        }
        this.setVisible(false);
       

    }//GEN-LAST:event_upadte_ProfileActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        changecolor(jButton1, new Color(255, 51, 153));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        changecolor(jButton1, new Color(43, 43, 43));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Type", "jpg", "png", "jpeg", "gif");
        file.addChoosableFileFilter(filter);
        file.showSaveDialog(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseClicked

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseEntered

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseExited

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void exitttexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitttexitMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_exitttexitMouseClicked

    private void exitttexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitttexitMouseEntered
        changecolor(exittt, new Color(69, 73, 74));
    }//GEN-LAST:event_exitttexitMouseEntered

    private void exitttexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitttexitMouseExited
        changecolor(exittt, new Color(52, 152, 219));
    }//GEN-LAST:event_exitttexitMouseExited

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
            java.util.logging.Logger.getLogger(Detail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JPanel exittt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton upadte_Profile;
    // End of variables declaration//GEN-END:variables
}
