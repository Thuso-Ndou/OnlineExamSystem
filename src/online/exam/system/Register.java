
package online.exam.system;

import Provider.DBConnection;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        CheckBoxShowPassword.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                // show password
                txtPassword.setEchoChar((char) 0);
            }
            else
            {
                // hide password
                txtPassword.setEchoChar('*');
            }
        }
    });
        
        // when the button is clicked
        btnRegisterActionPerformed(null);
        
        // error messages
        lblErrorName.setText("");
        lblErrorSurname.setText("");
        lblErrorPassword.setText("");
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        name6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        ComboBoxRole = new javax.swing.JComboBox<>();
        accountID = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxGender = new javax.swing.JComboBox<>();
        CheckBoxShowPassword = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblEmail = new javax.swing.JLabel();
        name7 = new javax.swing.JLabel();
        name8 = new javax.swing.JLabel();
        name9 = new javax.swing.JLabel();
        name10 = new javax.swing.JLabel();
        name11 = new javax.swing.JLabel();
        name12 = new javax.swing.JLabel();
        name13 = new javax.swing.JLabel();
        lblErrorName = new javax.swing.JLabel();
        lblErrorSurname = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel2.setText("Complete the Form Below");

        name.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name.setText("Name");

        name1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name1.setText("Gender");

        name2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name2.setText("Surname");

        name3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name3.setText("Role");

        name4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name4.setText("Registration ID");

        name5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name5.setText("E-Mail");

        name6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name6.setText("Password");

        ComboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Lecturer" }));

        accountID.setText("********");

        btnRegister.setBackground(new java.awt.Color(18, 34, 47));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel4.setText("Already have an Account?");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 174));
        jLabel3.setText("Login");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        ComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        ComboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxGenderActionPerformed(evt);
            }
        });

        CheckBoxShowPassword.setText("Show Password");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_schedule_26px.png")); // NOI18N
        jLabel5.setText("ONLINE EXAM SYSTEM");

        jSeparator2.setAlignmentY(-2.0F);

        lblEmail.setText("*********");

        name7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name7.setText(":");

        name8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name8.setText(":");

        name9.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name9.setText(":");

        name10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name10.setText(":");

        name11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name11.setText(":");

        name12.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name12.setText(":");

        name13.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name13.setText(":");

        lblErrorName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblErrorName.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorName.setText("jLabel1");

        lblErrorSurname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblErrorSurname.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorSurname.setText("jLabel1");

        lblErrorPassword.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblErrorPassword.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorPassword.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(498, 498, 498)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(name)
                                            .addComponent(name3)
                                            .addComponent(name1)
                                            .addComponent(name2)
                                            .addComponent(name5))
                                        .addGap(66, 66, 66))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(name4)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(name6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(name8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(accountID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSurname, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ComboBoxGender, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBoxRole, javax.swing.GroupLayout.Alignment.TRAILING, 0, 268, Short.MAX_VALUE)
                                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblErrorName)
                                            .addComponent(txtName)
                                            .addComponent(lblErrorSurname)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(name13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblErrorPassword)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBoxShowPassword))
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(535, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name7)
                                    .addComponent(name))
                                .addGap(45, 45, 45)
                                .addComponent(name2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorName)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorSurname)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name9)
                            .addComponent(name1))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name10))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name12)
                            .addComponent(lblEmail))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(name3)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name4)
                            .addComponent(name11)
                            .addComponent(accountID))
                        .addGap(34, 34, 34)
                        .addComponent(name5)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name6)
                            .addComponent(name13))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckBoxShowPassword)
                            .addComponent(lblErrorPassword))
                        .addGap(31, 31, 31)))
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(315, 315, 315))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // register button
        // generate random student Number
        Random random = new Random();
        StringBuilder builder = new StringBuilder("22");
        for(int i = 0; i < 6; i++){
            builder.append(random.nextInt(10));
        }
        
        String RegistrationNumber = builder.toString();
        
        // retrive othet data from gui components
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String gender = (String) ComboBoxGender.getSelectedItem();
        String role = (String) ComboBoxRole.getSelectedItem();
        String password = txtPassword.getText();
        String email = RegistrationNumber + "@oes.ac.za";
        
        try 
        {   
            // store student details to the database based on role
            if(role.equals("Student"))
            {
                Connection con = DBConnection.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, RegistrationNumber);
                ps.setString(2, name);
                ps.setString(3, surname);
                ps.setString(4, gender);
                ps.setString(5, role);
                ps.setString(6, email);
                ps.setString(7, password);
                    
                    //validate fields
                if (name.isEmpty() || surname.isEmpty() || password.isEmpty()) 
                {
                    if (name.isEmpty()) 
                    {
                        lblErrorName.setText("Please Enter Name");
                    }
                    else
                    {
                        // error messages
                        lblErrorName.setText("");
                    }
                     
                    if (surname.isEmpty()) 
                    {
                        lblErrorSurname.setText("Please Enter Surname");
                    }
                    else
                    {
                        // error message
                        lblErrorSurname.setText("");
                    }
                    if (password.isEmpty()) 
                    {
                        lblErrorPassword.setText("Please Enter Password");
                    }
                    else
                    {
                        //error message
                        lblErrorPassword.setText("");
                    }
                }
                else
                {
                    // add details to the database when the input is setisfied
                    ps.executeUpdate();
                    setVisible(false);
                    new HomeStudent(RegistrationNumber, name, surname, gender, role, email, password).setVisible(true);
                }
            }
            // store lecturer details to the database based on role
            else
            {
                Connection con = DBConnection.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO lecturers VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, RegistrationNumber);
                ps.setString(2, name);
                ps.setString(3, surname);
                ps.setString(4, gender);
                ps.setString(5, role);
                ps.setString(6, email);
                ps.setString(7, password);
                    
                    //validate fields
                if (name.isEmpty() || surname.isEmpty() || password.isEmpty()) 
                {
                    if (name.isEmpty()) 
                    {
                        lblErrorName.setText("Enter Name");
                    }
                    if (surname.isEmpty()) 
                    {
                        lblErrorSurname.setText("Enter Surname");
                    }
                    if (password.isEmpty()) 
                    {
                        lblErrorPassword.setText("Enter Password");
                    }
                }
                else
                {
                    // add details to the database when the input is setisfied
                    ps.executeUpdate();
                    setVisible(false);
                    new Home(RegistrationNumber, name, surname, gender, role,email, password).setVisible(true);
                }
            }
                
        }
        catch (HeadlessException | SQLException e) 
        {
            // display message
            JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(e);
        }
               
        // set genarated 
        accountID.setText(RegistrationNumber);
        lblEmail.setText(email);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // account already exist button
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void ComboBoxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxGenderActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
          
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxShowPassword;
    private javax.swing.JComboBox<String> ComboBoxGender;
    private javax.swing.JComboBox<String> ComboBoxRole;
    private javax.swing.JLabel accountID;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorName;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorSurname;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name10;
    private javax.swing.JLabel name11;
    private javax.swing.JLabel name12;
    private javax.swing.JLabel name13;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel name7;
    private javax.swing.JLabel name8;
    private javax.swing.JLabel name9;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
