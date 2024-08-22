
package online.exam.system;

public class OnlineExamSystem {

    public static void main(String[] args) {
        // display the login form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
        // test if the code is runing
        System.out.println("Code Runing");
    }
    
}
