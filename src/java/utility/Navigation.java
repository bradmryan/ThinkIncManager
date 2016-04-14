/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Login;
import model.Projects;
import model.Tickets;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
@ManagedBean
@SessionScoped
public class Navigation {
    @ManagedProperty("#{login}")
    private Login login;
    @ManagedProperty("#{projects}")
    private Projects projects;
    @ManagedProperty("#{tickets}")
    private Tickets tickets;

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }
    
    public String goToAccount(){
        login.getCurrentUser().setProjects(Projects.getProjectsForUserFromDB(login.getCurrentUser().getId()));
        login.getCurrentUser().setTickets(Tickets.getTicketsForUserFromDB(login.getCurrentUser().getId()));
        return "Account";
    }
    
    public String goToSignUp(){
        login.nullify();
        return "CreateAccount";
    }
    
    public String goToEditUser(){
        login.setFirstName(login.getCurrentUser().getFirstName());
        login.setLastName(login.getCurrentUser().getLastName());
        login.setPhoneNumber(login.getCurrentUser().getPhoneNumber());
        login.setPass2(login.getPass());
        return "EditAccount";
    }
}
