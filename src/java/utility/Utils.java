/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
public class Utils {
    
    public static Connection getConnection() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private final static String SALT = "njfdknlJKJFDJlksdflJDKSJFHheuiow8fisljf2sd";
    
    public static String hash(String password){
        
        try {
            String salted = password + SALT;
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] hash = md.digest(salted.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(b & 0xff).toUpperCase();
                if (hex.length() == 1) {
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
