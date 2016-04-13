/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Projects;
import model.Ticket;
import model.Tickets;
import model.Users;

/**
 *
 * @author brad
 */
@WebServlet(name = "TicketServlet", urlPatterns = {"/Tickets"})
public class TicketServlet extends HttpServlet {

    Tickets tickets = new Tickets();
    Projects projects = new Projects();
    Users users = new Users();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String user_id = request.getParameter("user_id");
        String project_id = request.getParameter("project_id");
        
        if (id != null) { // get tickets by ID
            tickets.getTicketFromDB(Integer.parseInt(id));
            tickets.getTickets().add(tickets.getCurrentTicket());
        } else if (user_id != null){ // get tickets by user id
            tickets.setTickets(Tickets.getTicketsForUserFromDB(Integer.parseInt(user_id)));
        } else if (project_id != null) { // get tickets by project id
            tickets.setTickets(Tickets.getTicketsForProjectFromDB(Integer.parseInt(project_id)));
        } else {
            tickets.getTicketsFromDB();
        }
        
        // create json array from tickets.getTickets()
         JsonArrayBuilder jsonArray = Json.createArrayBuilder();
         for(int i = 0; i < tickets.getTickets().size(); i++) {
             String cd;
             if (tickets.getTicket(i).getCloseDate() == null){
                 cd = "null";
             } else {
                 cd = tickets.getTicket(i).getCloseDate().toString();
             }
           //     json.add("description", tickets.getTicket(i).getDescription());
                  JsonObjectBuilder object = Json.createObjectBuilder()
                      .add("id", tickets.getTicket(i).getId())
                      .add("description",tickets.getTicket(i).getDescription())
                      .add("start_date", tickets.getTicket(i).getStartDate().toString())
                      .add("due_date", tickets.getTicket(i).getDueDate().toString())
                      .add("close_date", cd)
                      .add("priority", tickets.getTicket(i).getPriority())
                      .add("level", tickets.getTicket(i).getLevel())
                      .add("project_id", tickets.getTicket(i).getProjectId())
                      .add("is_open", tickets.getTicket(i).getOpen());
                  jsonArray.add(object);
            }
         
        // print json array
        response.getWriter().print(jsonArray.build()); 
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        
        
        // TODO:
        // accept json array
        // parse json array
        // create ticket instance as tickets.setCurrentTicket() = new Ticket();
        // do createTicket method
       JsonObject json = Json.createReader(request.getInputStream()).readObject();
        String desc = json.getString("description");
        String priority = json.getString("priority");
        int level = json.getInt("level");
        
//        Date d = new Date(json.getString("due_date"));
//        String description = request.getParameter("description");
//        String start_date = request.getParameter("start_date");
//        String due_date = request.getParameter("due_date");
//        String priority = request.getParameter("priority");
//        String level = request.getParameter("level");
        
        DateFormat format = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);       
//        int lv = Integer.parseInt(level);
        
        Ticket pt = new Ticket();
        pt.setDescription(desc);
        pt.setPriority(priority);
        pt.setLevel(level);
        try {
//            pt.setStartDate(format.parse(start_date));
//            pt.setDueDate(format.parse(due_date));
            pt.setDueDate(format.parse(json.getString("due_date")));
            pt.setStartDate(format.parse(json.getString("start_date")));
        } catch (ParseException ex) {
            Logger.getLogger(TicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tickets.setCurrentTicket(pt);
        tickets.createTicket("");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
