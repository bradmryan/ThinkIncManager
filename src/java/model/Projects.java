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
import java.util.Calendar;
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
public class Projects {
    private List<Project> projects;
    private Project currentProject;

    public Projects() {
        currentProject = new Project();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
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
            String sql = "SELECT * FROM project WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Project p = new Project(
                        
                        rs.getString("projectName"),
                        rs.getString("projectManager"),
                        rs.getTimestamp("startDate"),
                        rs.getTimestamp("endDate")
                );
                currentProject = p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            currentProject = null;
        }
    }
    
    private void getProjectsForUserFromDB(int id){
        try (Connection conn = Utils.getConnection()) {
            String sql = "SELECT * FROM projects p JOIN user_projects up ON p.id=pu.project_id WHERE up.user_id=?"; //TODO: JOIN with user_projects
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            projects = new ArrayList<>();
            
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
    
    private void createProject(){
        try (Connection conn = Utils.getConnection()){
            
            int newID;
            
            String sql = "INSERT INTO projects (name, description, startDate, endDate, isActive) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currentProject.getProjectName());
            ps.setString(2, currentProject.getDescription());
            ps.setDate(3, new java.sql.Date(currentProject.getStartDate().getTime()));
            ps.setDate(4, null);
            currentProject.setActive(true);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            newID = rs.getInt("id");
            
        } catch (SQLException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //REDIRECTS
    public String createProject(String redirect){
        createProject();
        return redirect;
    }
}
