/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import static org.junit.Assert.*;

/**
 *
 * @author RyanBarrett
 */
public class BinarySerializationTest {
    /**
     * Test of getList method, of class FileInputStuff.
     */
    @Test
    public void testGetList() {
        try {
            
            System.out.println("getList");
            FileInputStream fis = new FileInputStream("BinaryTest/BinarySerializationTest");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Person> expResult = new ArrayList<>();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            ArrayList<Person> result = BinarySerialization.getList(ois);
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
        ArrayList<Person> expResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream("BinaryTest/BinarySerializationTest")));
        String name = "BinaryTest/BinarySerializationTest";
        BinarySerialization.makeList(expResult, name);
        ArrayList<Person> actualResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream("BinaryTest/BinarySerializationTest")));
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
        Person result = BinarySerialization.getPerson(entry);
        assertEquals(expResult, result);
    }
}
