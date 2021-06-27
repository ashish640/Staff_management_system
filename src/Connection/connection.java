
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connection 
{
    
     static Connection  con = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver load");
                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public static Connection getConnection() throws SQLException{
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Staff_Management", "root", "test");
       System.out.println("Connected");
       return(con);
       
    }   
public static void main(String arsg[]) 
{
    try{
new connection().getConnection();
}
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
