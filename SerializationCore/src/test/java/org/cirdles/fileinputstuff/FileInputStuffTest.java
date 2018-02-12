/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import java.io.FileInputStream;
import static org.junit.Assert.*;

/**
 *
 * @author RyanBarrett
 */
public class FileInputStuffTest {
    /**
     * Test of getList method, of class FileInputStuff.
     */
    @Test
    public void testGetList() {
        try {
            System.out.println("getList");
            Scanner fileScanner = new Scanner(new FileInputStream("PeopleTest/PeopleTest.CSV"));
            ArrayList<Person> expResult = new ArrayList<>();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            People result = FileInputStuff.getList(fileScanner);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of makeList method, of class FileInputStuff.
     */
    @Test
    public void testMakeList() throws Exception {
        System.out.println("makeList");
        People expResult = FileInputStuff.getList(new Scanner(new FileInputStream("PeopleTest/PeopleTest.CSV")));
        String name = "PeopleTest/PeopleTest.CSV";
        FileInputStuff.makeList(expResult, name);
        People actualResult = FileInputStuff.getList(new Scanner(new FileInputStream("PeopleTest/PeopleTest.CSV")));
        assertEquals(actualResult, expResult);
    }

    /**
     * Test of getPerson method, of class FileInputStuff.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        String entry = "Ryan, Barrett, 5/12/1999";
        Person expResult = new Person("Ryan", "Barrett", "5/12/1999");
        Person result = FileInputStuff.getPerson(entry);
        assertEquals(expResult, result);
    }
}
