/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RyanBarrett
 */
public class FileInputStuffTest {
    
    public FileInputStuffTest() {
    }

    /**
     * Test of main method, of class FileInputStuff.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FileInputStuff.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class FileInputStuff.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        Scanner fileScanner = null;
        ArrayList<Person> expResult = null;
        ArrayList<Person> result = FileInputStuff.getList(fileScanner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeList method, of class FileInputStuff.
     */
    @Test
    public void testMakeList() throws Exception {
        System.out.println("makeList");
        ArrayList<Person> list = null;
        String name = "";
        FileInputStuff.makeList(list, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeople method, of class FileInputStuff.
     */
    @Test
    public void testGetPeople() {
        System.out.println("getPeople");
        String entry = "";
        Scanner userInput = null;
        ArrayList<Person> list = null;
        FileInputStuff.getPeople(entry, userInput, list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class FileInputStuff.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        String entry = "";
        Person expResult = null;
        Person result = FileInputStuff.getPerson(entry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
