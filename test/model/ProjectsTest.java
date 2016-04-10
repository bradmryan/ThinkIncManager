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
public class ProjectsTest {
    
    public ProjectsTest() {
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
     * Test of getProjects method, of class Projects.
     */
    @Test
    public void testGetProjects() {
        System.out.println("getProjects");
        Projects instance = new Projects();
        List<Project> expResult = null;
        List<Project> result = instance.getProjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class Projects.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        int i = 0;
        Projects instance = new Projects();
        Project expResult = null;
        Project result = instance.getProject(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjects method, of class Projects.
     */
    @Test
    public void testSetProjects() {
        System.out.println("setProjects");
        List<Project> projects = null;
        Projects instance = new Projects();
        instance.setProjects(projects);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentProject method, of class Projects.
     */
    @Test
    public void testGetCurrentProject() {
        System.out.println("getCurrentProject");
        Projects instance = new Projects();
        Project expResult = null;
        Project result = instance.getCurrentProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentProject method, of class Projects.
     */
    @Test
    public void testSetCurrentProject() {
        System.out.println("setCurrentProject");
        Project currentProject = null;
        Projects instance = new Projects();
        instance.setCurrentProject(currentProject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class Projects.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        Login login = null;
        Projects instance = new Projects();
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectsFromDB method, of class Projects.
     */
    @Test
    public void testGetProjectsFromDB() {
        System.out.println("getProjectsFromDB");
        Projects instance = new Projects();
        instance.getProjectsFromDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectFromDB method, of class Projects.
     */
    @Test
    public void testGetProjectFromDB() {
        System.out.println("getProjectFromDB");
        int id = 0;
        Projects instance = new Projects();
        instance.getProjectFromDB(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectsForUserFromDB method, of class Projects.
     */
    @Test
    public void testGetProjectsForUserFromDB() {
        System.out.println("getProjectsForUserFromDB");
        int id = 0;
        List<Project> expResult = null;
        List<Project> result = Projects.getProjectsForUserFromDB(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProject method, of class Projects.
     */
    @Test
    public void testCreateProject() {
        System.out.println("createProject");
        String redirect = "";
        Projects instance = new Projects();
        String expResult = "";
        String result = instance.createProject(redirect);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of goToProject method, of class Projects.
     */
    @Test
    public void testGoToProject() {
        System.out.println("goToProject");
        int id = 0;
        Projects instance = new Projects();
        String expResult = "";
        String result = instance.goToProject(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
