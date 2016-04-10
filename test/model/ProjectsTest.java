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
     * Test of getProject method, of class Projects.
     */
    @Test
    public void testSetProjectsAndGetProject() {
        System.out.println("getProject");
        int i = 1;
        List<Project> projects = new ArrayList();
        projects.add(new Project("one", "one", new Date(01,01,2016), new Date(01,01,2016)));
        projects.add(new Project("two", "two", new Date(01,01,2016), new Date(01,01,2016)));
        projects.add(new Project("three", "three", new Date(01,01,2016), new Date(01,01,2016)));
        Projects instance = new Projects();
        instance.setProjects(projects);
        String expResult = "two";
        String result = instance.getProject(i).getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentProject method, of class Projects.
     */
    @Test
    public void testSetAndGetCurrentProject() {
        System.out.println("getCurrentProject");
        Projects instance = new Projects();
        instance.setCurrentProject(new Project("one", "one", new Date(01,01,2016), new Date(01,01,2016)));
        String expResult = "one";
        String result = instance.getCurrentProject().getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectsFromDB method, of class Projects.
     */
    @Test
    public void testGetProjectsFromDB() {
        System.out.println("getProjectsFromDB");
        Projects instance = new Projects();
        instance.getProjectsFromDB();
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
    }
    
}
