/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Assignment;
import com.mysql.jdbc.CommunicationsException;
import java.sql.*;
import java.util.Properties;

public class connect_to_database {
    public static void main(String[] args) throws Exception {
        // Initialise variables for connecting to the database        
        String host = "javaassignment.mysql.database.azure.com";
        String database = "SocietyDB";
        String user = "liammatt2605@javaassignment.mysql.database.azure.com";
        String password = "JavaDB2605";
        
        //Ensure the connection driver is installed, if not display an error.
        /* 
        To point the application to the driver, naviagate to the projects tab
        in the left pane, locate your project, right click libraries, add lirary 
        and select the 'mySQL JDBC Driver' library       
        */         
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            throw new ClassNotFoundException("MySQL driver not found", e);
        }
        
        System.out.println("MySQL driver found. Connecting to the database.");
        
        // Initialize the connection object using database strings and database URL
        
        Connection conn = null;
        //execute a try catch block to catch the event that the database is inaccessible
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false&requireSSL=false", host, database); 
                      
            System.out.println("Done");
            //Set connection properties
            Properties p = new Properties();
            p.setProperty("user", user);
            p.setProperty("password", password);
            p.setProperty("useSSL", "false");
            p.setProperty("verifyServerCertificate", "false");
            p.setProperty("requireSSL", "false");
           // conn = DriverManager.getConnection(url, user, password);
           conn = DriverManager.getConnection(url, user, password);
        }
        

        catch (CommunicationsException e) {
            throw new SQLException("Could not connect to the database", e);
        }
        if (conn != null) {
            System.out.println("Successfully connected to the database!");
        }
        
        
        
        
        
    }
    
}

