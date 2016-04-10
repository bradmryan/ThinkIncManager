/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public void testGetId() {
        System.out.println("getId");
        Ticket instance = new Ticket();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Ticket.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Ticket instance = new Ticket();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Ticket.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Ticket instance = new Ticket();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Ticket.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Ticket instance = new Ticket();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Ticket.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Ticket instance = new Ticket();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Ticket.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        Ticket instance = new Ticket();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDueDate method, of class Ticket.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Ticket instance = new Ticket();
        Date expResult = null;
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDueDate method, of class Ticket.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        Date dueDate = null;
        Ticket instance = new Ticket();
        instance.setDueDate(dueDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCloseDate method, of class Ticket.
     */
    @Test
    public void testGetCloseDate() {
        System.out.println("getCloseDate");
        Ticket instance = new Ticket();
        Date expResult = null;
        Date result = instance.getCloseDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCloseDate method, of class Ticket.
     */
    @Test
    public void testSetCloseDate() {
        System.out.println("setCloseDate");
        Date closeDate = null;
        Ticket instance = new Ticket();
        instance.setCloseDate(closeDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriority method, of class Ticket.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");
        Ticket instance = new Ticket();
        String expResult = "";
        String result = instance.getPriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriority method, of class Ticket.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        String priority = "";
        Ticket instance = new Ticket();
        instance.setPriority(priority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class Ticket.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Ticket instance = new Ticket();
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLevel method, of class Ticket.
     */
    @Test
    public void testSetLevel() {
        System.out.println("setLevel");
        int level = 0;
        Ticket instance = new Ticket();
        instance.setLevel(level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectId method, of class Ticket.
     */
    @Test
    public void testGetProjectId() {
        System.out.println("getProjectId");
        Ticket instance = new Ticket();
        int expResult = 0;
        int result = instance.getProjectId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjectId method, of class Ticket.
     */
    @Test
    public void testSetProjectId() {
        System.out.println("setProjectId");
        int projectId = 0;
        Ticket instance = new Ticket();
        instance.setProjectId(projectId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpen method, of class Ticket.
     */
    @Test
    public void testGetOpen() {
        System.out.println("getOpen");
        Ticket instance = new Ticket();
        Boolean expResult = null;
        Boolean result = instance.getOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpen method, of class Ticket.
     */
    @Test
    public void testSetOpen() {
        System.out.println("setOpen");
        Boolean open = null;
        Ticket instance = new Ticket();
        instance.setOpen(open);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Ticket.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Ticket instance = new Ticket();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class Ticket.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        List<User> users = null;
        Ticket instance = new Ticket();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
