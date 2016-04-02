/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utils;
/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
public class Users {
    private List<User> users;
    private List<User> projectUsers;
    private List<User> ticketUsers;

    public Users() {
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getProjectUsers() {
        return projectUsers;
    }

    public void setProjectUsers(List<User> projectUsers) {
        this.projectUsers = projectUsers;
    }

    public List<User> getTicketUsers() {
        return ticketUsers;
    }

    public void setTicketUsers(List<User> ticketUsers) {
        this.ticketUsers = ticketUsers;
    }
    
    private void getUsersFromDB(){
        try (Connection conn = Utils.getConnection()) {
            users = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User u = new User(
                        rs.getString("email"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber")
                );
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            users = new ArrayList<>();
        }
    }
}
