/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

/**
 *
 * @author RyanBarrett
 */
public class XMLSerializationTest {

    @Test
    public void testGetList() {
        try {

            System.out.println("getList");
            File file = new File("XMLTest/peopleTest.xml");
            People expResult = new People();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            People result = XMLSerialization.getList(file);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testMakeList() {
        try {
            File file = new File("XMLTest/peopleTest.xml");
            System.out.println("makeList");
            People expResult = XMLSerialization.getList(file);
            XMLSerialization.makeList(expResult, file);
            People actualResult = XMLSerialization.getList(file);
            assertEquals(actualResult, expResult);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
