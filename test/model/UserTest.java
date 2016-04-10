/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getId method, of class User.
     */
    @Test
    public void testSetAndGetId() {
        System.out.println("getId");
        User instance = new User();
        instance.setId(10);
        int expResult = 10;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testSetAndGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        instance.setEmail("test@test.test");
        String expResult = "test@test.test";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testSetAndGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        instance.setFirstName("test");
        String expResult = "test";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testSetAndGetLastName() {
        System.out.println("getLastName");
        User instance = new User();
        instance.setLastName("test");
        String expResult = "test";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class User.
     */
    @Test
    public void testSetAndGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        User instance = new User();
        instance.setPhoneNumber("5555555555");
        String expResult = "5555555555";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPasshash method, of class User.
     */
    @Test
    public void testSetAndGetPasshash() {
        System.out.println("getPasshash");
        User instance = new User();
        instance.setPasshash("test");
        String expResult = "test";
        String result = instance.getPasshash();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjects method, of class User.
     */
    @Test
    public void testSetAndGetProjects() {
        System.out.println("getProjects");
        User instance = new User();
        List<Project> projects = new ArrayList();
        projects.add(new Project());
        projects.add(new Project());
        projects.add(new Project());
        instance.setProjects(projects);
        boolean expResult = true;
        
        boolean result = false;
        for (int i =0; i < projects.size(); i++){
            result = Project.class.isInstance(projects.get(i));
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of getTickets method, of class User.
     */
    @Test
    public void testSetAndGetTickets() {
        System.out.println("getTickets");
        User instance = new User();
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
     * Test of firstNameLastName method, of class User.
     */
    @Test
    public void testFirstNameLastName() {
        System.out.println("firstNameLastName");
        User instance = new User();
        instance.setFirstName("firstname");
        instance.setLastName("lastname");
        String expResult = "firstname lastname";
        String result = instance.firstNameLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of lastNameFirstName method, of class User.
     */
    @Test
    public void testLastNameFirstName() {
        System.out.println("lastNameFirstName");
        User instance = new User();
        instance.setFirstName("firstname");
        instance.setLastName("lastname");
        String expResult = "lastname, firstname";
        String result = instance.lastNameFirstName();
        assertEquals(expResult, result);
    }
    
}
