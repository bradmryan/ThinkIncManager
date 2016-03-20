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
public class Projects {
    private List<Project> projects;
    private List<Project> userProjects;
    private Project currentProject;

    public Projects() {
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(List<Project> userProjects) {
        this.userProjects = userProjects;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }
    
    private void getProjectsFromDB(){
        try (Connection conn = Database.getConnection()) {
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
}
