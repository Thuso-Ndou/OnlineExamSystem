
package online.exam.system;

import Provider.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thuso Maps
 */
public class ModuleModification extends javax.swing.JFrame {
    // declaration of variables
    String ModuleName;
    String ModuleTable;
    String RegistrationNumber;
    /**
     * Creates new form SetExam
     */
    public ModuleModification() {
        initComponents();
        
    }
    
    public ModuleModification(String registrationNumber) {
        initComponents();
        
        lblError.setText("");
        RegistrationNumber = registrationNumber;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtModuleName = new javax.swing.JTextField();
        btnDeleteModule = new javax.swing.JButton();
        btnExistingModule = new javax.swing.JButton();
        btnAddModule = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 153));
        setLocation(new java.awt.Point(82, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 34, 45));
        jPanel1.setPreferredSize(new java.awt.Dimension(1284, 45));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODULE MODIFICATION");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_cancel_48px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(454, 454, 454)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        jLabel3.setText("MODULE NAME");

        btnDeleteModule.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteModule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteModule.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_waste_48px.png")); // NOI18N
        btnDeleteModule.setText("DELETE MODULE");
        btnDeleteModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteModuleActionPerformed(evt);
            }
        });

        btnExistingModule.setBackground(new java.awt.Color(102, 204, 255));
        btnExistingModule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExistingModule.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_update_left_rotation_48px.png")); // NOI18N
        btnExistingModule.setText("EXISTING MODULE");
        btnExistingModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistingModuleActionPerformed(evt);
            }
        });

        btnAddModule.setBackground(new java.awt.Color(0, 204, 153));
        btnAddModule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddModule.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_add_new_48px.png")); // NOI18N
        btnAddModule.setText("NEW MODULE");
        btnAddModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddModuleActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(589, 589, 589)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtModuleName, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddModule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeleteModule)
                                .addGap(26, 26, 26)
                                .addComponent(btnExistingModule)))))
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtModuleName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteModule)
                    .addComponent(btnExistingModule)
                    .addComponent(btnAddModule))
                .addContainerGap(391, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // close icon
        Home.open = 0;
        setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnAddModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddModuleActionPerformed
        // button to add module
        ModuleName = txtModuleName.getText();
        ModuleTable = ModuleName.replaceAll("\\s", "_");
        
        // Database connection
        Connection con = DBConnection.getCon();
        
        try 
        {  
            if(ModuleName.isEmpty())
            {
                lblError.setText("Please Provide a Module Name");
            }
            else
            {
                // create a module table
                String sql = "CREATE TABLE "+ModuleTable+" (QuestionNo VARCHAR(255) PRIMARY KEY, Question VARCHAR(255),OptionA VARCHAR(255),OptionB VARCHAR(255),OptionC VARCHAR(255),OptionD VARCHAR(255),Answer VARCHAR(255))";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                
                // insert the module into the module table
                // query statement for inserting data into moduless table
                PreparedStatement ps = con.prepareStatement("INSERT INTO modules VALUES(?,?,?)");
                
                ps.setString(1, ModuleName);
                ps.setString(2, ModuleTable);
                ps.setString(3, RegistrationNumber);
            
                // add details to the database when the input is setisfied
                ps.executeUpdate();
                
                //open the set exam frame
                setVisible(false);
                new SetExam(RegistrationNumber,ModuleTable).setVisible(true);
            }
        } 
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(ModuleModification.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(ex);
            lblError.setText("Module Name Already Exist");
        }       
    }//GEN-LAST:event_btnAddModuleActionPerformed

    private void btnDeleteModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteModuleActionPerformed
        // button to delete module
        ModuleName = txtModuleName.getText();
        ModuleTable = ModuleName.replaceAll("\\s", "_");
        
        // Database connection
        Connection con = DBConnection.getCon();
        
        try 
        {  
            if(ModuleName.isEmpty())
            {
                lblError.setText("Please Provide a Module Name");
            }
            else
            {
                // query statement for retriving data from students table
                PreparedStatement ps = con.prepareStatement("SELECT * FROM modules");
                
                // execute the query statement
                ResultSet rs = ps.executeQuery();
            
                // loop inside the lecturers table
                while(rs.next())
                {
                    // valid users login details
                    if(rs.getString("ModuleName").equals(ModuleName) && rs.getString("RegistrationNumber").equals(RegistrationNumber))
                    {
                       
                        // delete a module table
                        String sql = "DROP TABLE "+ModuleTable+"";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        
                        // delete a module record
                        PreparedStatement prepSt = con.prepareStatement("DELETE FROM modules WHERE ModuleName = ?");
                        prepSt.setString(1, ModuleName);
                        prepSt.executeUpdate();
                        
                        // display success message
                        lblError.setText("Module Deleted");
                        break;
                    }
                }
            }
        } 
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(ModuleModification.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(ex);
            lblError.setText("Module Deletion Failed");
        }   
    }//GEN-LAST:event_btnDeleteModuleActionPerformed

    private void btnExistingModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistingModuleActionPerformed
        // button to work on existing module
        ModuleName = txtModuleName.getText();
        ModuleTable = ModuleName.replaceAll("\\s", "_");
        
        // Database connection
        Connection con = DBConnection.getCon();
        
        try 
        {  
            if(ModuleName.isEmpty())
            {
                lblError.setText("Please Provide a Module Name");
            }
            else
            { 
                // query statement for retriving data from students table
                PreparedStatement ps = con.prepareStatement("SELECT * FROM modules");
                
                // execute the query statement
                ResultSet rs = ps.executeQuery();
            
                // loop inside the lecturers table
                while(rs.next())
                {
                    // valid users login details
                    if(rs.getString("ModuleTable").equals(ModuleTable) && rs.getString("RegistrationNumber").equals(RegistrationNumber))
                    {
                       
                        //open the set exam frame
                        setVisible(false);
                        new SetExam(RegistrationNumber,ModuleTable).setVisible(true);
                        break;
                    }
                }
                
                // error message
                lblError.setText("Module Does Not Exist");
            }
        } 
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(ModuleModification.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(ex);
            lblError.setText("Module Retrival Failed");
        }   
    }//GEN-LAST:event_btnExistingModuleActionPerformed

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
            java.util.logging.Logger.getLogger(ModuleModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuleModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuleModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuleModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuleModification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddModule;
    private javax.swing.JButton btnDeleteModule;
    private javax.swing.JButton btnExistingModule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtModuleName;
    // End of variables declaration//GEN-END:variables
}
