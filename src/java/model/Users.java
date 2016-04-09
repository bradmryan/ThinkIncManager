/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private static List<User> users;

    public Users() {
        getUsersFromDB();
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        Users.users = users;
    }
    
    private void getUsersFromDB(){
        try (Connection conn = Utils.getConnection()) {
            users = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("phoneNumber"),
                        rs.getString("password")
                );
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            users = new ArrayList<>();
        }
    }
    
    public static List<User> getUsersForProjectFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            users = new ArrayList<>();
            String sql = "SELECT * FROM users u JOIN user_projects up ON u.id=up.user_id WHERE up.project_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("phoneNumber"),
                        rs.getString("password")
                );
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            users = new ArrayList<>();
        }
        return users;
    }
}
