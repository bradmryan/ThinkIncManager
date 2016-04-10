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
    public void testSetAndGetUsers() {
        System.out.println("getUsers");
        Users instance = new Users();
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
     * Test of getUser method, of class Users.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 0;
        Users instance = new Users();
        List<User> users = new ArrayList();
        users.add(new User(1, "one@test.test"));
        users.add(new User(2, "two@test.test"));
        users.add(new User(3, "three@test.test"));
        instance.setUsers(users);
        
        String expResult = "two@test.test";
        String result = instance.getUser(id).getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUsersFromDB method, of class Users.
     */
    @Test
    public void testGetUsersFromDB() {
        System.out.println("getUsersFromDB");
        Users instance = new Users();
        instance.getUsersFromDB();
    }
}
