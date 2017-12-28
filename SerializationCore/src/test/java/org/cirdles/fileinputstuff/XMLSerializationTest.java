/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author RyanBarrett
 */
public class XMLSerializationTest {

    public void testGetList() {
        try {

            System.out.println("getList");
            File file = new File("XMLTest/peopleTest.xml");
            SAXBuilder builder = new SAXBuilder();
            Document doc = (Document) builder.build(file);
            ArrayList<Person> expResult = new ArrayList<>();
            expResult.add(new Person("Mike", "Tyson", "1905"));
            expResult.add(new Person("first", "last", "date"));
            expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
            ArrayList<Person> result = XMLSerialization.getList(doc);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public void testMakeList() {
        try {
            File file = new File("XMLTest/peopleTest.xml");
            SAXBuilder builder = new SAXBuilder();
            Document doc = (Document) builder.build(file);
            System.out.println("makeList");
            ArrayList<Person> expResult = XMLSerialization.getList(doc);
            XMLSerialization.makeList(expResult, doc);
            ArrayList<Person> actualResult = XMLSerialization.getList(doc);
            assertEquals(actualResult, expResult);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
