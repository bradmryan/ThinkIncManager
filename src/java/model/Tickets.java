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
    @ManagedProperty("#{login}")
    private Login login;
    
    public Tickets() {
        currentTicket = new Ticket();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    
    public Ticket getTicket(int i) {
        return tickets.get(i);
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

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public void getTicketsFromDB(){

        try (Connection conn = Utils.getConnection()) {
            
            tickets = new ArrayList<>();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM tickets WHERE is_open=true");

            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getString("priority"),
                        rs.getInt("level"),
                        rs.getInt("project_id"),
                        rs.getBoolean("is_open")
                );
                tickets.add(t);
                System.out.println(t.getId());
                System.out.println(t.getDescription());
                System.out.println(t.getStartDate());
                System.out.println(t.getDueDate());
                System.out.println(t.getPriority());
                System.out.println(t.getLevel());
                System.out.println(t.getProjectId());
                System.out.println(t.getOpen());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            tickets = new ArrayList<>();
        }
    }
    
    public static List<Ticket> getTicketsForProjectFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            tickets = new ArrayList<>();
            String sql = "SELECT * FROM tickets t WHERE project_id=? AND is_open=true";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getInt("id"),
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
            String sql = "SELECT * FROM user_tickets ut JOIN tickets t ON ut.ticket_id=t.id WHERE ut.user_id=? AND is_open=true";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getInt("id"),
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
    
    public void getTicketFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            String sql = "SELECT * FROM tickets WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getInt("id"),
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
    
    public void createTicket(){
        try (Connection conn = Utils.getConnection()){
            
            String sql = "INSERT INTO tickets (description, start_date, due_date, close_date, priority, level, project_id, is_open) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int newID = rs.getInt(1);
            
            sql = "INSERT INTO user_tickets (user_id, ticket_id) VALUES (?,?)";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setInt(1, login.getCurrentUser().getId());
            ps2.setInt(2, newID);
            ps2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destroy(){
        try (Connection conn = Utils.getConnection()){
            String sql = "DELETE FROM tickets WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentTicket.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void resolve(){
        try (Connection conn = Utils.getConnection()){
            String sql = "UPDATE tickets SET is_open=false WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentTicket.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUserToTicket(){
        try(Connection conn = Utils.getConnection()){
            String sql = "INSERT INTO user_tickets VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, login.getCurrentUser().getId());
            ps.setInt(2, currentTicket.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Tickets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDescription(){
        
    }
    
    public void updateDueDate(){
        
    }
    
    
    
    //REDIRECTS
    public String createTicket(String redirect){
        createTicket();
        login.currentUser.setTickets(getTicketsForUserFromDB(login.currentUser.getId()));
        projects.getCurrentProject().setTickets(getTicketsForProjectFromDB(currentTicket.getProjectId()));
        return redirect;
    }
    
    public String goToTicket(int id){
        getTicketFromDB(id);
        System.out.println(currentTicket.getId());
        currentTicket.setUsers(Users.getUsersForTicketFromDB(id));
        projects.goToProject(currentTicket.getProjectId());
        return "Ticket";
    }
    
    public String destroyRedirect(){
        destroy();
        login.currentUser.setTickets(getTicketsForUserFromDB(login.currentUser.getId()));
        projects.getCurrentProject().setTickets(getTicketsForProjectFromDB(currentTicket.getProjectId()));
        return "Project";
    }
    
    public String resolveReload(){
        resolve();
        return "Ticket";
    }
}
