/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.system;

import Provider.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thuso Maps
 */
public class WriteExamSelectModule extends javax.swing.JFrame {
    public String registrationNumber;
    String ModuleTable;

    /**
     * Creates new form WriteExam
     */
    public WriteExamSelectModule() {
        initComponents();
    }
    
    public WriteExamSelectModule(String registration) {
        initComponents();
        
        registrationNumber = registration;
        
        // Database connection
        Connection con = DBConnection.getCon();
        try
        {
            // query statement for retriving data from moduless table
            PreparedStatement ps = con.prepareStatement("SELECT * FROM modules");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            //number of modules
            int numberOfModules = 0;
            
            // loop inside the modules table
            while(rs.next())
            {
                // assign value from table
                String optionValue = rs.getString("ModuleName");
                
                jComboBoxModules.addItem(optionValue);
                
                numberOfModules = numberOfModules + 1;
            }
            
            // hide button
            if(numberOfModules == 0)
            {
                btnDone.setVisible(false);
                lblUnavailable.setText("No Module Available");
            }
            else
            {
                btnDone.setVisible(true);
                lblUnavailable.setText("");
            }
            
            // close resources
            rs.close();
            ps.close();
            con.close();
        }
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No Module Is Available");
            System.out.println(ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxModules = new javax.swing.JComboBox<>();
        btnDone = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblUnavailable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(82, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 34, 45));
        jPanel1.setPreferredSize(new java.awt.Dimension(1284, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_cancel_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WRITE EXAM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(551, 551, 551)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 558, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("SELECT A MODULE TO WRITE");

        jComboBoxModules.setBackground(new java.awt.Color(0, 204, 153));

        btnDone.setBackground(new java.awt.Color(0, 204, 153));
        btnDone.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_forward_button_48px.png"))); // NOI18N
        btnDone.setText("DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 204, 153));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_back_arrow_48px.png"))); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblUnavailable.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblUnavailable.setForeground(new java.awt.Color(0, 204, 154));
        lblUnavailable.setText("No Module Available");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblUnavailable)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(lblUnavailable)
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnDone))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // close icon
        Home.open = 0;
        setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // back icon
        setVisible(false);
        new WriteExamInstructions(registrationNumber).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // done icon
        
        Connection con = DBConnection.getCon();
        try
        {
            // declare variables
            String selectedModule = (String) jComboBoxModules.getSelectedItem();
            
            // execute the query statement
            try ( // query statement for retriving data from moduless table
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM modules"); // execute the query statement
                    ResultSet rs = ps.executeQuery()) 
            {
                
                // loop inside the modules table
                while(rs.next())
                {
                    if(selectedModule.equals(rs.getString("ModuleName")))
                    {
                        // assign value from table
                        ModuleTable = rs.getString("ModuleTable");
                        
                        break;
                    }
                }
                
            }
            con.close();
            
            setVisible(false);
            new WriteExam(registrationNumber,ModuleTable,selectedModule).setVisible(true);
        }
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No Module Is Available");
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_btnDoneActionPerformed

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
            java.util.logging.Logger.getLogger(WriteExamSelectModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteExamSelectModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteExamSelectModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteExamSelectModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteExamSelectModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDone;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBoxModules;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUnavailable;
    // End of variables declaration//GEN-END:variables
}
