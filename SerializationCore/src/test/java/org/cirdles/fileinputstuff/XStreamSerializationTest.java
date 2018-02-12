/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RyanBarrett
 */
public class XStreamSerializationTest {
    
    public XStreamSerializationTest() {
    }
    /**
     * Test of getList method, of class XStreamSerialization.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        File file = new File("XMLTest/XMLTest.xml");
        People expResult = new People();        
        expResult.add(new Person("Mike", "Tyson", "1905"));
        expResult.add(new Person("first", "last", "date"));
        expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
        People result = XStreamSerialization.getList(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of makeList method, of class XStreamSerialization.
     */
    @Test
    public void testMakeList() throws Exception {
        System.out.println("makeList");
        People expResult = new People();
        File file = new File("XMLTest/XMLTest.xml");
        expResult.add(new Person("Mike", "Tyson", "1905"));
        expResult.add(new Person("first", "last", "date"));
        expResult.add(new Person("Ryan", "Barrett", "5/12/1999"));
        XStreamSerialization.makeList(expResult, file);
        People result = XStreamSerialization.getList(file);
        assertEquals(expResult, result);
    }
}