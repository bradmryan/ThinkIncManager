/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utility.Utils;

/**
 *
 * @author brad
 */
@ManagedBean
@SessionScoped
public class Login {
    private String user;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pass;
    private String pass2;
    private Boolean isLoggedIn;

    public String getUser() {
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    
    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public String doLogin() {
        String passhash = Utils.hash(pass);
        for (User u : new Users().getUsers()) {
            if (user.equals(u.getEmail())
                    && passhash.equals(u.getPasshash())) {
                isLoggedIn = true;
                return "Account";
            }
        }
        isLoggedIn = false;
        return "Login";
    }
    
    public String doSignup() {
        if (pass.equals(pass2)) {
            String passhash = Utils.hash(pass);
            try {
                Connection conn = Utils.getConnection();
                String sql = "INSERT INTO user (email, firstName, lastName, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, phoneNumber);
                ps.setString(5, passhash);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return "fail";
            }
            return "Account";
        }
        return "CreateAccount";
    }
}
