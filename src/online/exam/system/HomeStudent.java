
package online.exam.system;

public class HomeStudent extends javax.swing.JFrame {
    public static int open = 0;
    public String registrationNumber;
    public String firstName;
    public String lastName;
    public String gender;
    public String systemRole;
    public String email;
    public String systemPassword;

    public HomeStudent() {
        initComponents();
    }
    public HomeStudent(String registrationNumber1,String firstName1, String lastName1, String gender1, String systemRole1,String email1, String systemPassword1) {
        initComponents();
        registrationNumber = registrationNumber1;
        firstName = firstName1;
        lastName = lastName1;
        gender = gender1;
        systemRole = systemRole1;
        email = email1;
        systemPassword = systemPassword1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        setExam = new javax.swing.JLabel();
        writeExam = new javax.swing.JLabel();
        accountInfo = new javax.swing.JLabel();
        examFeedback = new javax.swing.JLabel();
        examGrade = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(53, 56, 61));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OVERVIEW");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 13, -1, -1));

        jPanel1.setBackground(new java.awt.Color(18, 34, 45));

        homeIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_home_page_50px.png")); // NOI18N
        homeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeIconMouseClicked(evt);
            }
        });

        setExam.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_task_50px.png")); // NOI18N
        setExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setExamMouseClicked(evt);
            }
        });

        writeExam.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_compose_50px.png")); // NOI18N
        writeExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                writeExamMouseClicked(evt);
            }
        });

        accountInfo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_contacts_26px.png")); // NOI18N
        accountInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountInfoMouseClicked(evt);
            }
        });

        examFeedback.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_map_50px.png")); // NOI18N
        examFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examFeedbackMouseClicked(evt);
            }
        });

        examGrade.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_purchase_order_50px.png")); // NOI18N
        examGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examGradeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(writeExam)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(setExam)
                                .addComponent(homeIcon))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(examFeedback))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(examGrade))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(accountInfo)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(homeIcon)
                .addGap(56, 56, 56)
                .addComponent(setExam)
                .addGap(58, 58, 58)
                .addComponent(writeExam)
                .addGap(59, 59, 59)
                .addComponent(examGrade)
                .addGap(56, 56, 56)
                .addComponent(examFeedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(accountInfo)
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 90, 790));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thuso Maps\\Downloads\\New Folder\\Online Exam System\\src\\online\\exam\\system\\icons\\icons8_logout_26px.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 11, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel3.setBackground(new java.awt.Color(18, 34, 47));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1282, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME TO STUDENT PORTAL");

        jPanel4.setBackground(new java.awt.Color(1, 34, 45));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 154));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 157));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 88, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(382, 382, 382))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 194, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // exit icon
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void homeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeIconMouseClicked
        // home icon
        if(open == 0)
        {
            new HomeStudent(registrationNumber,firstName,lastName,gender,systemRole,email,systemPassword).setVisible(true);
            open = 0;
        }
    }//GEN-LAST:event_homeIconMouseClicked

    private void setExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setExamMouseClicked
        // set exam icon
        if(open == 0)
        {
            new SetExamStudent().setVisible(true);
            open = 1;
        }
        
    }//GEN-LAST:event_setExamMouseClicked

    private void writeExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_writeExamMouseClicked
        // write exam icon
        if(open == 0)
        {
            new WriteExamInstructionsStudent(registrationNumber).setVisible(true);
            open = 1;
        }
        
    }//GEN-LAST:event_writeExamMouseClicked

    private void examGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examGradeMouseClicked
        // exam grade icon
        if(open == 0)
        {
            new ExamGradeStudent(registrationNumber,firstName,lastName,email).setVisible(true);
            open = 1;
        }
        
    }//GEN-LAST:event_examGradeMouseClicked

    private void examFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examFeedbackMouseClicked
        // exam feedback icon
        if(open == 0)
        {
            new ExamFeedBackStudent(registrationNumber).setVisible(true);
            open = 1;
        }
        
        
    }//GEN-LAST:event_examFeedbackMouseClicked

    private void accountInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountInfoMouseClicked
        // account icon
        if(open == 0)
        {
            new AccountStudent(registrationNumber,firstName,lastName,gender,systemRole,email,systemPassword).setVisible(true);
            open = 1;
        }
        
    }//GEN-LAST:event_accountInfoMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountInfo;
    private javax.swing.JLabel examFeedback;
    private javax.swing.JLabel examGrade;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel setExam;
    private javax.swing.JLabel writeExam;
    // End of variables declaration//GEN-END:variables
}
