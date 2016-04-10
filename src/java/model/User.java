/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author brad
 */
public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passHash;
    private List<Project> projects;
    private List<Ticket> tickets;

    public User() {
    }

    
    
    public User(int id, String email, String firstName, String lastName, String phoneNumber, String passHash) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passHash = passHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPasshash() {
        return passHash;
    }

    public void setPasshash(String passHash) {
        this.passHash = passHash;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public String firstNameLastName(){
        return firstName + " " + lastName;
    }
    
    public String lastNameFirstName(){
        return lastName + ", " + firstName;
    }
}
