/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class LoginTest {
    
    public LoginTest() {
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
     * Test of getUser method, of class Login.
     */
    @Test
    public void testSetAndGetUser() {
        System.out.println("getUser");
        Login instance = new Login();
        instance.setUser("Test User");
        String expResult = "Test User";
        String result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Login.
     */
    @Test
    public void testSetAndGetFirstName() {
        System.out.println("getFirstName");
        Login instance = new Login();
        instance.setFirstName("firstName");
        String expResult = "firstName";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Login.
     */
    @Test
    public void testSetAndGetLastName() {
        System.out.println("getLastName");
        Login instance = new Login();
        instance.setLastName("lastname");
        String expResult = "lastname";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Login.
     */
    @Test
    public void testSetAndGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Login instance = new Login();
        instance.setPhoneNumber("5555555555");
        String expResult = "5555555555";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPass2 method, of class Login.
     */
    @Test
    public void testSetAndGetPass2() {
        System.out.println("getPass2");
        Login instance = new Login();
        instance.setPass2("password");
        String expResult = "password";
        String result = instance.getPass2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPass method, of class Login.
     */
    @Test
    public void testSetAndGetPass() {
        System.out.println("getPass");
        Login instance = new Login();
        instance.setPass("password");
        String expResult = "password";
        String result = instance.getPass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentUser method, of class Login.
     */
    @Test
    public void testSetAndGetCurrentUser() {
        System.out.println("getCurrentUser");
        Login instance = new Login();
        instance.setCurrentUser(new User());
        boolean expResult = true;
        boolean result = User.class.isInstance(instance.getCurrentUser());
        assertEquals(expResult, result);

    }

    /**
     * Test of getIsLoggedIn method, of class Login.
     */
    @Test
    public void testGetIsLoggedIn() {
        System.out.println("getIsLoggedIn");
        Login instance = new Login();
        Boolean expResult = null;
        Boolean result = instance.getIsLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogin method, of class Login.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        Login instance = new Login();
        String expResult = "";
        String result = instance.doLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogout method, of class Login.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        Login instance = new Login();
        String expResult = "";
        String result = instance.doLogout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doSignup method, of class Login.
     */
    @Test
    public void testDoSignup() {
        System.out.println("doSignup");
        Login instance = new Login();
        String expResult = "";
        String result = instance.doSignup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
