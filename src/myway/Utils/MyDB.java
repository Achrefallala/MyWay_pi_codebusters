
package myway.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 
 */
public class MyDB {

    public static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    final String URL ="jdbc:mysql://127.0.0.1:3306/myway";
    final String USERNAME="root";
    final String PWD ="";
   private  Connection cnx;
 private static   MyDB instance;
    private MyDB(){
        try {
            cnx =DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("connected ....");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static MyDB getInstance (){
        if (instance == null)
            instance = new MyDB();
        return instance ;
    }
    public Connection getCnx(){
        return cnx;
    }
    
    
}
