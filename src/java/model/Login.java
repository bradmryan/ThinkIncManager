/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utility.Utils;

/**
 *
 * @author brad
 */
@ManagedBean(name="login")
@SessionScoped
public class Login implements Serializable {
    
    private String user;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pass;
    private String pass2;
    private Boolean isLoggedIn;
    User currentUser;

    public Login() {
        isLoggedIn = false;
    }
    
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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
                currentUser = u;
                currentUser.setProjects(Projects.getProjectsForUserFromDB(currentUser.getId()));
                currentUser.setTickets(Tickets.getTicketsForUserFromDB(currentUser.getId()));
                isLoggedIn = true;
                return "Account";
            }
        }
        isLoggedIn = false;
        return "Login";
    }
    
    public String doLogout(){
        nullify();
        return "Login";
    }
    
    public String doSignup() {
        if (pass.equals(pass2)) {
            String passhash = Utils.hash(pass);
            try {
                Connection conn = Utils.getConnection();
                String sql = "INSERT INTO users (email, firstName, lastName, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, phoneNumber);
                ps.setString(5, passhash);
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int newID = rs.getInt(1);
                
                System.out.println(newID);
                
                currentUser = new User();
                
                currentUser.setId(newID);
                currentUser.setEmail(user);
                currentUser.setFirstName(firstName);
                currentUser.setLastName(lastName);
                currentUser.setPhoneNumber(phoneNumber);
                currentUser.setProjects(Projects.getProjectsForUserFromDB(currentUser.getId()));
                currentUser.setTickets(Tickets.getTicketsForUserFromDB(currentUser.getId()));
                isLoggedIn = true;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "Account";
        }
        return "Login";
    }
    
    public void nullify(){
    user = null;
    firstName = null;
    lastName = null;
    phoneNumber = null;
    pass = null;
    pass2 = null;
    isLoggedIn = false;
    currentUser= null;
    }
}
