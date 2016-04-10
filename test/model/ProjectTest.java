/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brad Ryan <brad.m.ryan@gmail.com>
 */
public class ProjectTest {
    
    public ProjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Project.
     */
    @Test
    public void testSetAndGetId() {
        System.out.println("getId");
        Project instance = new Project();
        instance.setId(5);
        int expResult = 5;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectName method, of class Project.
     */
    @Test
    public void testSetAndGetProjectName() {
        System.out.println("getProjectName");
        Project instance = new Project();
        instance.setProjectName("project name");
        String expResult = "project name";
        String result = instance.getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testSetAndGetDescription() {
        System.out.println("getDescription");
        Project instance = new Project();
        instance.setDescription("Test Description");
        String expResult = "Test Description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Project.
     */
    @Test
    public void testSetAndGetStartDate() {
        System.out.println("getStartDate");
        Project instance = new Project();
        instance.setStartDate(new Date(01,01,2016));
        Date expResult = new Date(01,01,2016);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndDate method, of class Project.
     */
    @Test
    public void testSetAndGetEndDate() {
        System.out.println("getEndDate");
        Project instance = new Project();
        instance.setEndDate(new Date(01,01,2016));
        Date expResult = new Date(01,01,2016);
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTickets method, of class Project.
     */
    @Test
    public void testSetAndGetTickets() {
        System.out.println("getTickets");
        Project instance = new Project();
        List<Ticket> tickets = new ArrayList();
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        instance.setTickets(tickets);
        boolean expResult = true;
        
        boolean result = false;
        for (int i =0; i < tickets.size(); i++){
            result = Ticket.class.isInstance(tickets.get(i));
        }
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class Project.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Project instance = new Project();
        List<User> users = new ArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        instance.setUsers(users);
        boolean expResult = true;
        
        boolean result = false;
        for (int i =0; i < users.size(); i++){
            result = User.class.isInstance(users.get(i));
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of isActive method, of class Project.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Project instance = new Project();
        instance.setActive(false);
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
    }
}
