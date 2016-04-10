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
public class UsersTest {
    
    public UsersTest() {
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
     * Test of getUsers method, of class Users.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Users instance = new Users();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Users.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 0;
        Users instance = new Users();
        User expResult = null;
        User result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class Users.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        List<User> users = null;
        Users instance = new Users();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersFromDB method, of class Users.
     */
    @Test
    public void testGetUsersFromDB() {
        System.out.println("getUsersFromDB");
        Users instance = new Users();
        instance.getUsersFromDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserFromDB method, of class Users.
     */
    @Test
    public void testGetUserFromDB() {
        System.out.println("getUserFromDB");
        int id = 0;
        Users instance = new Users();
        User expResult = null;
        User result = instance.getUserFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersForProjectFromDB method, of class Users.
     */
    @Test
    public void testGetUsersForProjectFromDB() {
        System.out.println("getUsersForProjectFromDB");
        int id = 0;
        List<User> expResult = null;
        List<User> result = Users.getUsersForProjectFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersForTicketFromDB method, of class Users.
     */
    @Test
    public void testGetUsersForTicketFromDB() {
        System.out.println("getUsersForTicketFromDB");
        int id = 0;
        List<User> expResult = null;
        List<User> result = Users.getUsersForTicketFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
