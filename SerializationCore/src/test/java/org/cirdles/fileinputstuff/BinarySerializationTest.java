/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import java.io.ObjectInputStream;
import org.junit.Test;
import java.io.FileInputStream;
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
            People expResult = new People();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            BinarySerialization.makeList(expResult, "BinaryTest/BinarySerializationTest.ser");
            People result = BinarySerialization.getList(ois);
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
        try {
            System.out.println("makeList");
            String name = "BinaryTest/BinarySerializationTest.ser";
            People expResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream(name)));
            BinarySerialization.makeList(expResult, name);
            People actualResult = BinarySerialization.getList(new ObjectInputStream(new FileInputStream(name)));
            assertEquals(actualResult, expResult);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
