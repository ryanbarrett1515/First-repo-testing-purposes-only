/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuffui;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import org.junit.Test;
import java.io.FileInputStream;
import org.cirdles.fileinputstuff.Person;
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
            FileInputStream fis = new FileInputStream("BinaryTest/BinarySerializationTest.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Person> expResult = new ArrayList<>();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            BinarySerialization.makeList(expResult, "BinaryTest/BinarySerializationTest.ser");
            ArrayList<Person> result = BinarySerialization.getList(ois);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    /**
     * Test of makeList method, of class FileInputStuff.
     */
    @Test
    public void testMakeList() throws Exception {
        System.out.println("makeList");
        String name = "BinaryTest/BinarySerializationTest.ser";
        ArrayList<Person> expResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream(name)));
        BinarySerialization.makeList(expResult, name);
        ArrayList<Person> actualResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream(name)));
        assertEquals(actualResult, expResult);
    }
}