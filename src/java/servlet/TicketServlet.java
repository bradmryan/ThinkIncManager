/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tickets;

/**
 *
 * @author brad
 */
@WebServlet(name = "TicketServlet", urlPatterns = {"/Tickets"})
public class TicketServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        Tickets tickets = new Tickets();
        
        //TODO: 
        // Run getTicketsFromDB method
        tickets.getTicketsFromDB();
              
        // create json array from tickets.getTickets()
       // Map<String, Object> config = new HashMap<String, Object>();
         //JsonArrayBuilder json = Json.createArrayBuilder();
         //JsonBuilderFactory js = Json.createBuilderFactory(config);
         for(int i = 0; i < tickets.getTickets().size(); i++) {
           //     json.add("description", tickets.getTicket(i).getDescription());
                  JsonObjectBuilder object = Json.createObjectBuilder()
                      .add("description",tickets.getTicket(i).getDescription())
                  .build();
            }
        
        // print json array
        
        //TODO:
        // Accept params 
        // narrow search results using params
        // create json
        // print json
//        response.getWriter().print(someString); 
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
