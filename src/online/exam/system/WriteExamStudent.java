
package online.exam.system;

import Provider.DBConnection;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Thuso Maps
 */
public class WriteExamStudent extends javax.swing.JFrame {
   // creating variables
    public String registrationNumber;
    private Timer timer;
    private LocalDate currentDate;
    public int questionNumber = 1;
    public int numberOfQuestions = 0;
    public int marks = 0;
    public int activeQuestion = 1;
    public String ModuleTable;
    public String ModuleName;
    public int minutes;
    public int hours = minutes / 60;
    public int seconds = 59;
    public String answer;
    public String question;
    public String optA;
    public String optB;
    public String optC;
    public String optD;
    public String studentAnswer;
    /**
     * Creates new form WriteExam
     */
    public WriteExamStudent() {
        initComponents();
    }

    public WriteExamStudent(String registrationNumber1, String moduleTable, String moduleName) {
        initComponents();
        
        // assign passed value
        registrationNumber = registrationNumber1;
        ModuleTable = moduleTable;
        ModuleName = moduleName;
        
        // initialize
        lblRegistrationNumber.setText(registrationNumber);
        lblModule.setText(ModuleName);
        
        // determine the number of questions
        numberOfQuestions = getNumberOfQuestions();
        
        if(numberOfQuestions == 0)
        {
            minutes = 0;
            seconds = 0;
        }
        else
        {
            minutes = numberOfQuestions - 1;
        }
        
        lblTime.setText(numberOfQuestions + " Minutes");
        
        lblNumberOfQuestion.setText(String.valueOf(numberOfQuestions));
        
        // call start timer method
        timer = new Timer(1000, new ActionListenerImpl());
        
        timer.start();
        
        currentDate = LocalDate.now();
        
        lblDate.setText(String.valueOf(currentDate));
        
        // first question
        retriveQuestions();
        
    }
     
    // method for timer
    public void startTimer()
    {  
        if(minutes == 0 && seconds == 0)
        {
            timer.stop();
            
            // increment marks
            marks = marks + getMark(answer);
            
            // add the results to a database
            insertMark();
            JOptionPane.showMessageDialog(this, "Your Work Has Been Submitted", "Times's Up", JOptionPane.PLAIN_MESSAGE);
            setVisible(false);
            new ExamCompletedStudent(marks,numberOfQuestions).setVisible(true);
        } 
        
        if(minutes > 60)
        {
            minutes = minutes - 60;
        }
        
        if(seconds == 0)
        {
            minutes--;
            seconds = 59;
            
            if(hours >= 1 && minutes == 0)
            {
                hours--;
                minutes = 59;
            } 
        }
        
        seconds--; 
        
        lblTimer.setText(String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds));   
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM "+ModuleTable+"");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                questions = questions + 1;
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM "+ModuleTable+" WHERE QuestionNo = '"+activeQuestion+"'");
            
            // execute the query statement
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                // set all the labels
                lblQuestionNumber.setText(rs.getString(1));
                lblQuestion.setText(rs.getString(2));
                jRadioButtonA.setText(rs.getString(3));
                jRadioButtonB.setText(rs.getString(4));
                jRadioButtonC.setText(rs.getString(5));
                jRadioButtonD.setText(rs.getString(6));
                answer = rs.getString(7);
                question = rs.getString(2);
                optA = rs.getString(3);
                optB = rs.getString(4);
                optC = rs.getString(5);
                optD = rs.getString(6);
            }
            
            if(activeQuestion == numberOfQuestions)
            {
                // hide button
                btnNext.setVisible(false);
            }
        }
        catch(SQLException e)
        {
            // display message
            //JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }
    }
    
    private int getMark(String correctAnswer)
    {
        // determine which radio is click
        if(jRadioButtonA.isSelected())
        {
            studentAnswer = jRadioButtonA.getText();
        }
        else if(jRadioButtonB.isSelected())
        {
            studentAnswer = jRadioButtonB.getText();
        }
        else if(jRadioButtonC.isSelected())
        {
            studentAnswer = jRadioButtonC.getText();
        }
        else if(jRadioButtonD.isSelected())
        {
            studentAnswer = jRadioButtonD.getText();
        }
        else
        {
            studentAnswer = "";
        }
            
        // compare student answer with the one on database
        int number = 0;
                
        if(studentAnswer.equals(correctAnswer))
        {
            // increment the mark by one
            number = 1;
        }
                
        return number;
    }
    
    // method to check selected redio button
    private void clearRadio()
    {
        buttonGroup1.clearSelection();
    }
    
    // method for inserting exam data
    private void insertExams()
    {
        try 
        {  
            // database connection
            Connection con = DBConnection.getCon();
            PreparedStatement prep = con.prepareStatement("INSERT INTO exams VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            prep.setString(1, registrationNumber);
            prep.setString(2, ModuleName);
            prep.setString(3, String.valueOf(activeQuestion));
            prep.setString(4, question);
            prep.setString(5, optA);
            prep.setString(6, optB);
            prep.setString(7, optC);
            prep.setString(8, optD);
            prep.setString(9, answer);
            prep.setString(10, studentAnswer);
                
            // add details to the database when the input is setisfied
            prep.executeUpdate();
                
        }
        catch (HeadlessException | SQLException e) 
        {
            // display message
            JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(e);
        }
    }
    
    // method for exam score
    private void insertMark()
    {
        try 
        {   
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO exammark VALUES(?,?,?,?)");
            ps.setString(1, registrationNumber);
            ps.setString(2, ModuleName);
            ps.setString(3, String.valueOf(marks));
            ps.setString(4, String.valueOf(numberOfQuestions));
                
            // add details to the database when the input is setisfied
            ps.executeUpdate();   
                
        }
        catch (HeadlessException | SQLException e) 
        {
            // display message
            JOptionPane.showMessageDialog(this, "Connection Failed");
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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
        lblRegistrationNumber = new javax.swing.JLabel();
        lblNumberOfQuestion = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        lblModule = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblQuestionNumber = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jRadioButtonD = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(82, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 34, 45));
        jPanel1.setPreferredSize(new java.awt.Dimension(1284, 45));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EXAM IN PROGRESS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(610, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(486, 486, 486))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Total Time");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Time Taken");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Date");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Questions");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Registration Number");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText(":");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText(":");

        lblRegistrationNumber.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblRegistrationNumber.setText("jLabel20");

        lblNumberOfQuestion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNumberOfQuestion.setText("jLabel21");

        lblDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblDate.setText("jLabel22");

        lblTime.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTime.setText("jLabel23");

        lblTimer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTimer.setText("00:00:00");

        lblModule.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblModule.setText("Module");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModule)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumberOfQuestion)
                            .addComponent(lblRegistrationNumber)
                            .addComponent(lblDate)
                            .addComponent(lblTime)
                            .addComponent(lblTimer))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(lblRegistrationNumber))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(lblNumberOfQuestion))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(lblDate))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(lblTime))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel19)
                    .addComponent(lblTimer))
                .addGap(151, 151, 151)
                .addComponent(lblModule)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel3.setText("Question: ");

        lblQuestionNumber.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N

        lblQuestion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(jRadioButtonB);
        jRadioButtonB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(jRadioButtonA);
        jRadioButtonA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(jRadioButtonC);
        jRadioButtonC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup1.add(jRadioButtonD);
        jRadioButtonD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnNext.setBackground(new java.awt.Color(18, 34, 45));
        btnNext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(51, 153, 255));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_forward_button_48px.png"))); // NOI18N
        btnNext.setText("NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(18, 34, 45));
        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(51, 153, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online/exam/system/icons/icons8_upload_40px.png"))); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuestionNumber))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuestion)
                                    .addComponent(jRadioButtonB)
                                    .addComponent(jRadioButtonA)
                                    .addComponent(jRadioButtonC)
                                    .addComponent(jRadioButtonD)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmit)
                        .addGap(78, 78, 78)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblQuestionNumber))
                        .addGap(50, 50, 50)
                        .addComponent(lblQuestion)
                        .addGap(54, 54, 54)
                        .addComponent(jRadioButtonA)
                        .addGap(35, 35, 35)
                        .addComponent(jRadioButtonB)
                        .addGap(37, 37, 37)
                        .addComponent(jRadioButtonC)
                        .addGap(38, 38, 38)
                        .addComponent(jRadioButtonD)
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // next button
        
        // increment marks
        marks = marks + getMark(answer);
        
        // insert data into the data table
        insertExams();
        
        activeQuestion = activeQuestion + 1;
        
        // set radiobuttons to unselected
        clearRadio();
            
        // get the next question
        retriveQuestions();
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // submit button
        
        // mesage dialog
        int option = JOptionPane.YES_NO_OPTION;
        int result;
        
        result = JOptionPane.showConfirmDialog(this, "Do you want to submit?", "Submit", option, JOptionPane.PLAIN_MESSAGE);
        
        // when the user press yes
        if(result == JOptionPane.YES_OPTION)
        {
            // stop timer
            timer.stop();
            
            // increment marks
            marks = marks + getMark(answer);
            
            // insert data into the data table
            insertExams();
            
            // add the results to a database
            insertMark();
            
            setVisible(false);
            new ExamCompletedStudent(marks,numberOfQuestions).setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(WriteExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteExamStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblModule;
    private javax.swing.JLabel lblNumberOfQuestion;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestionNumber;
    private javax.swing.JLabel lblRegistrationNumber;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables

    class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            startTimer();
        }
    }
}
