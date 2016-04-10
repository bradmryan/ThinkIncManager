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
@WebServlet(name = "ProjectServlet", urlPatterns = {"/Projects"})
public class ProjectServlet extends HttpServlet {
    
    Tickets tickets = new Tickets();
    Projects projects = new Projects();
    Users users = new Users();

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
        
        String id = request.getParameter("id");
        String user_id = request.getParameter("user_id");
        
        if (id != null) { // get tickets by ID
            projects.getProjectFromDB(Integer.parseInt(id));
            projects.getProjects().add(projects.getCurrentProject());
        } else if (user_id != null){ // get tickets by user id
            projects.setProjects(Projects.getProjectsForUserFromDB(Integer.parseInt(user_id)));
        } else {
            projects.getProjectsFromDB();
        }
        

         JsonArrayBuilder jsonArray = Json.createArrayBuilder();
         for(int i = 0; i < projects.getProjects().size(); i++) {
             String ed;
             if (projects.getProject(i).getEndDate() == null){
                 ed = "null";
             } else {
                 ed = projects.getProject(i).getEndDate().toString();
             }
                  JsonObjectBuilder object = Json.createObjectBuilder()
                      .add("id", projects.getProject(i).getId())
                      .add("name", projects.getProject(i).getProjectName())
                      .add("description",projects.getProject(i).getDescription())
                      .add("start_date", projects.getProject(i).getStartDate().toString())
                      .add("end_date", ed)
                      .add("is_active", projects.getProject(i).isActive());
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
    }// </editor-fold>

}
