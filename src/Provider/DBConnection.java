
package Provider;

import java.sql.*;

public class DBConnection 
{
    public static Connection getCon()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/onlineexamsystem";
            Connection con = DriverManager.getConnection(connectionString, "root", "thusoND@21");
            return con;
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            return null;
        }
    }
}
