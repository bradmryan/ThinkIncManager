/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.bean.ManagedProperty;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;
import model.Projects;
import model.Tickets;
import model.Users;

/**
 *
 * @author brad
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/Users"})
public class UserServlet extends HttpServlet {

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
        String ticket_id = request.getParameter("ticket_id");
        String project_id = request.getParameter("project_id");
        
        if (id != null) { // get tickets by ID
            users.getUsers().add(users.getUserFromDB(Integer.parseInt(id)));
        } else if (ticket_id != null){ // get tickets by user id
            users.setUsers(Users.getUsersForTicketFromDB(Integer.parseInt(ticket_id)));
        } else if (project_id != null) { // get tickets by project id
            users.setUsers(Users.getUsersForProjectFromDB(Integer.parseInt(project_id)));
        } else {
            users.getUsersFromDB();
        }
        
        // create json array from tickets.getTickets()
         JsonArrayBuilder jsonArray = Json.createArrayBuilder();
         for(int i = 0; i < users.getUsers().size(); i++) {
             
           //     json.add("description", tickets.getTicket(i).getDescription());
                  JsonObjectBuilder object = Json.createObjectBuilder()
                      .add("id", users.getUser(i).getId())
                      .add("email",users.getUser(i).getEmail())
                      .add("first_name", users.getUser(i).getFirstName())
                      .add("last_name", users.getUser(i).getLastName())
                      .add("phonenumber",users.getUser(i).getPhoneNumber());
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
