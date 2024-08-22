
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
public class ExamGrade extends javax.swing.JFrame {

    /**
     * Creates new form ExamGrade
     */
    public String RegistrationNo;
    public String firstName;
    public String lastName;
    public String email;
    public int examsTaken = 0;
    
    public ExamGrade() {
        initComponents();
    }
    
    public ExamGrade(String registration, String first, String last, String Email) {
        initComponents();
        
        // assign passed data
        RegistrationNo = registration;
        firstName = first;
        lastName = last;
        email = Email;
        
        // Database connection
        Connection con = DBConnection.getCon();
        try
        {
            // query statement for retriving data from exams table
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exammark");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            // loop inside the modules table
            while(rs.next())
            {
                if(RegistrationNo.equals(rs.getString("RegistrationNo")))
                {
                    // assign value from table
                    String optionValue = rs.getString("ModuleName");
                
                    jComboBoxModules.addItem(optionValue);
                
                    examsTaken = examsTaken + 1;
                }
            }

        }
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No Module Is Available");
            System.out.println(ex);
        }
        
        try
        {
            // declare variables
            String selectedModule = (String) jComboBoxModules.getSelectedItem();
            
            // execute the query statement
            try ( // query statement for retriving data from moduless table
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM exammark"); // execute the query statement
                    ResultSet rs = ps.executeQuery()) 
            {
                
                // loop inside the modules table
                while(rs.next())
                {
                    if(selectedModule.equals(rs.getString("ModuleName")) && RegistrationNo.equals(rs.getString("RegistrationNo")))
                    {
                        // assign value from table
                        lblMark.setText(rs.getString("Mark"));
                        lblTotal.setText(rs.getString("Total"));
                        
                        break;
                    }
                }
                
            }
        }
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No Module Is Available");
            System.out.println(ex);
        }
        
        // set the labels to new text
        lblRegistration.setText(RegistrationNo);
        lblFirst.setText(firstName);
        lblLast.setText(lastName);
        lblEmail.setText(email);
        lblExamTaken.setText(String.valueOf(examsTaken));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblRegistration = new javax.swing.JLabel();
        lblFirst = new javax.swing.JLabel();
        lblLast = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblExamTaken = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxModules = new javax.swing.JComboBox<>();

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
        jLabel2.setText("EXAM GRADE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(511, 511, 511)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
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

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Email");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Exams Taken");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Last Number");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("First Name");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Registration Number");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText(":");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText(":");

        lblRegistration.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRegistration.setText("jLabel20");

        lblFirst.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblFirst.setText("jLabel21");

        lblLast.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblLast.setText("jLabel22");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblEmail.setText("jLabel23");

        lblExamTaken.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblExamTaken.setText("jLabel24");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16))
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExamTaken)
                    .addComponent(lblEmail)
                    .addComponent(lblLast)
                    .addComponent(lblRegistration)
                    .addComponent(lblFirst))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(lblRegistration))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(lblFirst))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(lblLast))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(lblEmail))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel19)
                    .addComponent(lblExamTaken))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 34, 45));
        jLabel3.setText("Student Marks");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Mark");

        lblMark.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblMark.setText("00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText(":");

        lblTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTotal.setText("00");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setText("/");

        jComboBoxModules.setBackground(new java.awt.Color(0, 204, 153));
        jComboBoxModules.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModulesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMark)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(403, 403, 403)
                                .addComponent(jLabel3)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(lblMark)
                            .addComponent(lblTotal)
                            .addComponent(jLabel35))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Home.open = 0;
        setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jComboBoxModulesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModulesItemStateChanged
        // TODO add your handling code here:
        // Database connection
        Connection con = DBConnection.getCon();
        
        try
        {
            // declare variables
            String selectedModule = (String) jComboBoxModules.getSelectedItem();
            
            // execute the query statement
            try ( // query statement for retriving data from moduless table
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM exammark"); // execute the query statement
                    ResultSet rs = ps.executeQuery()) 
            {
                
                // loop inside the modules table
                while(rs.next())
                {
                    if(selectedModule.equals(rs.getString("ModuleName")) && RegistrationNo.equals(rs.getString("RegistrationNo")))
                    {
                        // assign value from table
                        lblMark.setText(rs.getString("Mark"));
                        lblTotal.setText(rs.getString("Total"));
                        
                        break;
                    }
                }
                
            }
        }
        catch (SQLException ex) 
        {
            // display message
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No Module Is Available");
            System.out.println(ex);
        }
    }//GEN-LAST:event_jComboBoxModulesItemStateChanged

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
            java.util.logging.Logger.getLogger(ExamGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamGrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxModules;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblExamTaken;
    private javax.swing.JLabel lblFirst;
    private javax.swing.JLabel lblLast;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
