
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
public class ExamFeedBack extends javax.swing.JFrame {
    public int activeQuestion = 1;
    public int numberOfQuestions = 1;
    public int questionNumber = 0;
    public int numberOfModules = 0;
    public String registrationNumber;
    public String answer;
    public String module;
    /**
     * Creates new form ExamFeedBack
     */
    public ExamFeedBack() {
        initComponents();
    }
    
    public ExamFeedBack(String registrationNo) {
        initComponents();
        
        registrationNumber = registrationNo;
        
        // add items to combo box
        addItem();
        
        // assign a module
        module = (String) jComboBoxModules.getSelectedItem();
        
        // get number of questions
        numberOfQuestions = getNumberOfQuestions();
        
        // hide button
        if(numberOfModules == 0)
        {
            btnNext.setVisible(false);
            btnPrevious.setVisible(false);
            lblUnavailable.setText("No Exam Written");
        }
        else
        {
            btnNext.setVisible(true);
            btnPrevious.setVisible(true);
            lblUnavailable.setText("");
        }
        
        retriveQuestions();
        
    }
    
    // method to get the total number of questions
    private int getNumberOfQuestions()
    {
        int questions = 0;
        
        try
        {
            // Database connection
            Connection con = DBConnection.getCon();
            
            // query statement for retriving data from students table
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exams");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                if(registrationNumber.equals(rs.getString(1)) && module.equals(rs.getString(2)))
                {
                    questions = questions + 1;
                }
            }
            
            return questions;
        }
        catch(SQLException e)
        {
            // display message
            //JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }
        return questions;
    }
    
    // method to retrive question
    private void retriveQuestions()
    {
        try
        {
            // Database connection
            Connection con = DBConnection.getCon();
            
            // query statement for retriving data from students table
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exams WHERE QuestionNo = '"+activeQuestion+"'");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                if(registrationNumber.equals(rs.getString(1)) && module.equals(rs.getString(2)))
                {
                    // set all the labels
                    lblNo.setText(rs.getString(3));
                    lblQuestion.setText(rs.getString(4));
                    radioBtnA.setText(rs.getString(5));
                    radioBtnB.setText(rs.getString(6));
                    radioBtnC.setText(rs.getString(7));
                    radioBtnD.setText(rs.getString(8));
                    lblCorrectAnswer.setText(rs.getString(9));
                
                    answer = rs.getString(10);
                    
                    if(!(answer == null))
                    {
                        selectRadio();
                    }
                    else
                    {
                        buttonGroup1.clearSelection();
                    }
                }
            }
        }
        catch(SQLException e)
        {
            // display message
            //JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }
    }
    
    // select radio button
    private void selectRadio()
    {
        if(answer.equals(radioBtnA.getText()))
        {
            radioBtnA.setSelected(true);
            radioBtnA.setEnabled(false);
        }
        if(answer.equals(radioBtnB.getText()))
        {
            radioBtnB.setSelected(true);
            radioBtnB.setEnabled(false);
        }
        if(answer.equals(radioBtnC.getText()))
        {
            radioBtnC.setSelected(true);
            radioBtnC.setEnabled(false);
        }
        if(answer.equals(radioBtnD.getText()))
        {
            radioBtnD.setSelected(true);
            radioBtnD.setEnabled(false);
        }
        
    }
    
    private void handleNextButton() 
    {
    if (activeQuestion == numberOfQuestions) 
    {
      // Handle reaching the end of questions
      btnNext.setVisible(false);
      btnPrevious.setVisible(true);
    }
    else
    {
        // hide combo box
        jComboBoxModules.setVisible(false);
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
    }
    
    }

  private void handlePreviousButton()
  {
    if (activeQuestion == 1) 
    {
      // Handle reaching the first question
      btnPrevious.setVisible(false);
      jComboBoxModules.setVisible(true);
    }
    else
    {
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
        // hide combo box
        jComboBoxModules.setVisible(false);
    }
  }
    
    // method to add to combo box
    private void addItem()
    {
        // Database connection
        Connection con = DBConnection.getCon();
        try
        {
            // query statement for retriving data from moduless table
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exammark");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            // loop inside the modules table
            while(rs.next())
            {
                if(registrationNumber.equals(rs.getString(1)) && module.equals(rs.getString(2)))
                {
                    // assign value from table
                    String optionValue = rs.getString("ModuleName");
                
                    jComboBoxModules.addItem(optionValue);
                
                    numberOfModules = numberOfModules + 1;
                }
                
            }
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
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jComboBoxModules = new javax.swing.JComboBox<>();
        lblCorrectAnswer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNo = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        radioBtnB = new javax.swing.JRadioButton();
        radioBtnC = new javax.swing.JRadioButton();
        radioBtnD = new javax.swing.JRadioButton();
        radioBtnA = new javax.swing.JRadioButton();
        lblUnavailable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EXAM FEEDBACK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 483, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(590, 590, 590)
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

        btnNext.setBackground(new java.awt.Color(0, 204, 154));
        btnNext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNext.setText("NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 204, 154));
        btnPrevious.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPrevious.setText("PREVIOUS");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jComboBoxModules.setBackground(new java.awt.Color(0, 204, 153));
        jComboBoxModules.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModulesItemStateChanged(evt);
            }
        });

        lblCorrectAnswer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Question");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Correct Answer:");

        lblNo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblQuestion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblQuestion.setText("Question");

        buttonGroup1.add(radioBtnB);
        radioBtnB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(radioBtnC);
        radioBtnC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(radioBtnD);
        radioBtnD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(radioBtnA);
        radioBtnA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lblUnavailable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUnavailable.setForeground(new java.awt.Color(255, 51, 51));
        lblUnavailable.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUnavailable)
                        .addGap(327, 327, 327)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorrectAnswer)
                            .addComponent(jLabel5)
                            .addComponent(lblQuestion)
                            .addComponent(radioBtnB)
                            .addComponent(radioBtnC)
                            .addComponent(radioBtnD)
                            .addComponent(radioBtnA))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNo)
                .addGap(565, 565, 565))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxModules, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNo))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestion)
                    .addComponent(lblUnavailable))
                .addGap(37, 37, 37)
                .addComponent(radioBtnA)
                .addGap(31, 31, 31)
                .addComponent(radioBtnB)
                .addGap(33, 33, 33)
                .addComponent(radioBtnC)
                .addGap(35, 35, 35)
                .addComponent(radioBtnD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorrectAnswer)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // close icon
        Home.open = 0;
        setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // next button
        activeQuestion++;
        handleNextButton();
        retriveQuestions();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // previous button
        activeQuestion--;
        handlePreviousButton();
        retriveQuestions();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void jComboBoxModulesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModulesItemStateChanged
        // drop down list
        module = (String) jComboBoxModules.getSelectedItem();
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
            java.util.logging.Logger.getLogger(ExamFeedBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamFeedBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamFeedBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamFeedBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamFeedBack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBoxModules;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCorrectAnswer;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblUnavailable;
    private javax.swing.JRadioButton radioBtnA;
    private javax.swing.JRadioButton radioBtnB;
    private javax.swing.JRadioButton radioBtnC;
    private javax.swing.JRadioButton radioBtnD;
    // End of variables declaration//GEN-END:variables
}
