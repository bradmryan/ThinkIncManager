/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class TicketsTest {
    
    public TicketsTest() {
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
     * Test of getTickets method, of class Tickets.
     */
    @Test
    public void testGetTickets() {
        System.out.println("getTickets");
        Tickets instance = new Tickets();
        List<Ticket> expResult = null;
        List<Ticket> result = instance.getTickets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicket method, of class Tickets.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        int i = 0;
        Tickets instance = new Tickets();
        Ticket expResult = null;
        Ticket result = instance.getTicket(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTickets method, of class Tickets.
     */
    @Test
    public void testSetTickets() {
        System.out.println("setTickets");
        List<Ticket> tickets = null;
        Tickets instance = new Tickets();
        instance.setTickets(tickets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTicket method, of class Tickets.
     */
    @Test
    public void testGetCurrentTicket() {
        System.out.println("getCurrentTicket");
        Tickets instance = new Tickets();
        Ticket expResult = null;
        Ticket result = instance.getCurrentTicket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentTicket method, of class Tickets.
     */
    @Test
    public void testSetCurrentTicket() {
        System.out.println("setCurrentTicket");
        Ticket currentTicket = null;
        Tickets instance = new Tickets();
        instance.setCurrentTicket(currentTicket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjects method, of class Tickets.
     */
    @Test
    public void testSetProjects() {
        System.out.println("setProjects");
        Projects projects = null;
        Tickets instance = new Tickets();
        instance.setProjects(projects);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class Tickets.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        Login login = null;
        Tickets instance = new Tickets();
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketsFromDB method, of class Tickets.
     */
    @Test
    public void testGetTicketsFromDB() {
        System.out.println("getTicketsFromDB");
        Tickets instance = new Tickets();
        instance.getTicketsFromDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketsForProjectFromDB method, of class Tickets.
     */
    @Test
    public void testGetTicketsForProjectFromDB() {
        System.out.println("getTicketsForProjectFromDB");
        int id = 0;
        List<Ticket> expResult = null;
        List<Ticket> result = Tickets.getTicketsForProjectFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketsForUserFromDB method, of class Tickets.
     */
    @Test
    public void testGetTicketsForUserFromDB() {
        System.out.println("getTicketsForUserFromDB");
        int id = 0;
        List<Ticket> expResult = null;
        List<Ticket> result = Tickets.getTicketsForUserFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketFromDB method, of class Tickets.
     */
    @Test
    public void testGetTicketFromDB() {
        System.out.println("getTicketFromDB");
        int id = 0;
        Tickets instance = new Tickets();
        instance.getTicketFromDB(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTicket method, of class Tickets.
     */
    @Test
    public void testCreateTicket() {
        System.out.println("createTicket");
        String redirect = "";
        Tickets instance = new Tickets();
        String expResult = "";
        String result = instance.createTicket(redirect);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of goToTicket method, of class Tickets.
     */
    @Test
    public void testGoToTicket() {
        System.out.println("goToTicket");
        int id = 0;
        Tickets instance = new Tickets();
        String expResult = "";
        String result = instance.goToTicket(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
