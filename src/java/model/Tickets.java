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
import utility.Database;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
public class Tickets {
    private List<Ticket> userTickets;
    private List<Ticket> projectTickets;
    private Ticket currentTicket;

    public Tickets() {
    }
    
    public List<Ticket> getUserTickets() {
        return userTickets;
    }

    public void setUserTickets(List<Ticket> userTickets) {
        this.userTickets = userTickets;
    }

    public List<Ticket> getProjectTickets() {
        return projectTickets;
    }

    public void setProjectTickets(List<Ticket> projectTickets) {
        this.projectTickets = projectTickets;
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) {
        this.currentTicket = currentTicket;
    }
    
    private void getUserTicketsFromDB(){
        try (Connection conn = Database.getConnection()) {
            userTickets = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tickets WHERE userid=userid"); //TODO: Join with user_tickets table and select by user id
            while (rs.next()) {
                Ticket t = new Ticket(

                );
                userTickets.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            userTickets = new ArrayList<>();
        }
    }
}
