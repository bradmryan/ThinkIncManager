/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
public class Database {
    
    public static Connection getConnection() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        String hostname = "localhost";
        String port = "3306";
        String dbname= "thinkinc";
        String username = "thinkinc";
        String password = "XAbutdATp5sQ4VcS";
        String jdbc = String.format("jdbc:mysql://%s:%s/%s", hostname, port, dbname);
        
        return DriverManager.getConnection(jdbc, username, password);
    }
}
