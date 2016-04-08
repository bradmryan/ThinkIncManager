/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
public class Projects implements Serializable {
    private static List<Project> projects;
    private Project currentProject;
    
    @ManagedProperty("#{login}")
    private Login login;
    
    public Projects() {
        currentProject = new Project();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        Projects.projects = projects;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    private void getProjectsFromDB(){
        try (Connection conn = Utils.getConnection()) {
            projects = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                Project p = new Project(
                        
                        rs.getString("projectName"),
                        rs.getString("projectManager"),
                        rs.getTimestamp("startDate"),
                        rs.getTimestamp("endDate")
                );
                projects.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            projects = new ArrayList<>();
        }
    }
    
    private void getProjectFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            String sql = "SELECT * FROM projects p JOIN user_projects up ON p.id=up.project_id WHERE p.id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("startDate"),
                        rs.getTimestamp("endDate"),
                        rs.getBoolean("isActive"),
                        rs.getBoolean("is_manager")
                );
                currentProject = p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            currentProject = null;
        }
    }
    
    public static List<Project> getProjectsForUserFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            String sql = "SELECT * FROM projects p JOIN user_projects up ON p.id=up.project_id WHERE up.user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            projects = new ArrayList<>();
            
            while (rs.next()) {
                Project p = new Project(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("startDate"),
                        rs.getTimestamp("endDate"),
                        rs.getBoolean("isActive"),
                        rs.getBoolean("is_manager")
                );
                projects.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            projects = new ArrayList<>();
        }
        return projects;
    }
    
    
    private void createProject(){
        try (Connection conn = Utils.getConnection()){
            int newID;
            
            //UPDATE PROJECTS TABLE
            String sql = "INSERT INTO projects (name, description, startDate, endDate, isActive) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, currentProject.getProjectName());
            ps.setString(2, currentProject.getDescription());
            ps.setDate(3, new java.sql.Date(currentProject.getStartDate().getTime()));
            ps.setDate(4, null);
            currentProject.setActive(true);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            
            //UPDATE USER_PROJECTS TABLE
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            newID = rs.getInt(1);
            int user = login.getCurrentUser().getId();
            sql = "INSERT INTO user_projects (user_id, project_id, is_manager) VALUES (?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setInt(1, user);
            ps2.setInt(2, newID);
            ps2.setBoolean(3, true);
            ps2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //REDIRECTS
    public String createProject(String redirect){
        createProject();
        return redirect;
    }
    
    public String goToProject(int id) {
        getProjectFromDB(id);
        currentProject.setUsers(Users.getUsersForProjectFromDB(id));
        currentProject.setTickets(Tickets.getTicketsForProjectFromDB(id));
        return "Project";
    }
}
