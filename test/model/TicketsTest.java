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
     * Test of getTicket method, of class Tickets.
     */
    @Test
    public void testSetAndGetTicket() {
        System.out.println("getTicket");
        int i = 1;
        Tickets instance = new Tickets();
        List<Ticket> tickets = new ArrayList();
        tickets.add(new Ticket(1, "one"));
        tickets.add(new Ticket(2, "two"));
        tickets.add(new Ticket(3, "three"));
        instance.setTickets(tickets);
        String expResult = "two";
        String result = instance.getTicket(i).getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentTicket method, of class Tickets.
     */
    @Test
    public void testSetAndGetCurrentTicket() {
        System.out.println("getCurrentTicket");
        Tickets instance = new Tickets();
        instance.setCurrentTicket(new Ticket(1, "one"));
        String expResult = "one";
        String result = instance.getCurrentTicket().getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTicketsFromDB method, of class Tickets.
     */
    @Test
    public void testGetTicketsFromDB() {
        System.out.println("getTicketsFromDB");
        Tickets instance = new Tickets();
        instance.getTicketsFromDB();
    }    
}
