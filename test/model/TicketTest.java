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
public class TicketTest {
    
    public TicketTest() {
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
     * Test of getId method, of class Ticket.
     */
    @Test
    public void testSetAndGetId() {
        System.out.println("getId");
        Ticket instance = new Ticket();
        instance.setId(10);
        int expResult = 10;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Ticket.
     */
    @Test
    public void testSetAndGetDescription() {
        System.out.println("getDescription");
        Ticket instance = new Ticket();
        instance.setDescription("test description");
        String expResult = "test description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Ticket.
     */
    @Test
    public void testSetAndGetStartDate() {
        System.out.println("getStartDate");
        Ticket instance = new Ticket();
        instance.setStartDate(new Date(01,01,2016));
        Date expResult = new Date(01,01,2016);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class Ticket.
     */
    @Test
    public void testSetAndGetDueDate() {
        System.out.println("getDueDate");
        Ticket instance = new Ticket();
        instance.setDueDate(new Date(01,01,2016));
        Date expResult = new Date(01,01,2016);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCloseDate method, of class Ticket.
     */
    @Test
    public void testSetAndGetCloseDate() {
        System.out.println("getCloseDate");
        Ticket instance = new Ticket();
        instance.setCloseDate(new Date(01,01,2016));
        Date expResult = new Date(01,01,2016);
        Date result = instance.getCloseDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPriority method, of class Ticket.
     */
    @Test
    public void testSetAmdGetPriority() {
        System.out.println("getPriority");
        Ticket instance = new Ticket();
        instance.setPriority("HIGH");
        String expResult = "HIGH";
        String result = instance.getPriority();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevel method, of class Ticket.
     */
    @Test
    public void testSetAndGetLevel() {
        System.out.println("getLevel");
        Ticket instance = new Ticket();
        instance.setLevel(10);
        int expResult = 10;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectId method, of class Ticket.
     */
    @Test
    public void testSetAndGetProjectId() {
        System.out.println("getProjectId");
        Ticket instance = new Ticket();
        instance.setProjectId(10);
        int expResult = 10;
        int result = instance.getProjectId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOpen method, of class Ticket.
     */
    @Test
    public void testSetAndGetOpen() {
        System.out.println("getOpen");
        Ticket instance = new Ticket();
        instance.setOpen(false);
        Boolean expResult = false;
        Boolean result = instance.getOpen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class Ticket.
     */
    @Test
    public void testSetAndGetUsers() {
        System.out.println("getUsers");
        Ticket instance = new Ticket();
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
    
}
