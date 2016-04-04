/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utility.Utils;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
@ManagedBean
@SessionScoped
public class Tickets {
    private List<Ticket> tickets;
    private Ticket currentTicket;

    public Tickets() {
        currentTicket = new Ticket();
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) {
        this.currentTicket = currentTicket;
    }
    
    private void getTicketsFromDB(){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tickets");
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("close_date"),
                        rs.getString("priority"),
                        rs.getInt("level"),
                        rs.getInt("project_id"),
                        rs.getBoolean("is_open")
                );
                tickets.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            tickets = new ArrayList<>();
        }
    }
    
    private void getTicketsForProjectFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            String sql = "SELECT * FROM tickets WHERE project_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("close_date"),
                        rs.getString("priority"),
                        rs.getInt("level"),
                        rs.getInt("project_id"),
                        rs.getBoolean("is_open")
                );
                tickets.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            tickets = new ArrayList<>();
        }
    }
    
    private void getTicketsForUserFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            String sql = "SELECT * FROM user_tickets WHERE user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("close_date"),
                        rs.getString("priority"),
                        rs.getInt("level"),
                        rs.getInt("project_id"),
                        rs.getBoolean("is_open")
                );
                tickets.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            tickets = new ArrayList<>();
        }
    }
    
    private void getTicketFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            String sql = "SELECT * FROM tickets WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("close_date"),
                        rs.getString("priority"),
                        rs.getInt("level"),
                        rs.getInt("project_id"),
                        rs.getBoolean("is_open")
                );
                currentTicket = t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createTicket(){
        try (Connection conn = Utils.getConnection()){
            
            String sql = "INSERT INTO tickets (description, start_date, due_date, close_date, priority, level, project_id, is_open) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currentTicket.getDescription());
            ps.setDate(2, (Date) currentTicket.getStartDate());
            ps.setDate(3, (Date) currentTicket.getDueDate());
            ps.setDate(4, (Date) currentTicket.getCloseDate());
            ps.setString(5, currentTicket.getPriority());
            ps.setInt(6, currentTicket.getLevel());
            ps.setInt(7, currentTicket.getProjectId());
            currentTicket.setOpen(true);
            ps.setBoolean(8, true);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
