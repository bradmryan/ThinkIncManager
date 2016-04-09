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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import utility.Utils;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
@ManagedBean
@SessionScoped
public class Tickets {
    private static List<Ticket> tickets;
    private Ticket currentTicket;

    @ManagedProperty("#{projects}")
    private Projects projects;
    
    public Tickets() {
        currentTicket = new Ticket();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        Tickets.tickets = tickets;
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) {
        this.currentTicket = currentTicket;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
    
    public void getTicketsFromDB(){
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
    
    public static List<Ticket> getTicketsForProjectFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            String sql = "SELECT * FROM tickets t WHERE project_id=?";
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
        return tickets;
    }
    
    public static List<Ticket> getTicketsForUserFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            String sql = "SELECT * FROM user_tickets ut JOIN tickets t ON ut.ticket_id=t.id WHERE ut.user_id=?";
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
        return tickets;
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
            ps.setDate(2, new java.sql.Date(currentTicket.getStartDate().getTime()));
            ps.setDate(3, new java.sql.Date(currentTicket.getDueDate().getTime()));
            ps.setDate(4, null);
            ps.setString(5, currentTicket.getPriority());
            ps.setInt(6, currentTicket.getLevel());
            currentTicket.setProjectId(projects.getCurrentProject().getId());
            ps.setInt(7, currentTicket.getProjectId());
            currentTicket.setOpen(true);
            ps.setBoolean(8, currentTicket.getOpen());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //REDIRECTS
    public String createTicket(String redirect){
        createTicket();
        return redirect;
    }
}
