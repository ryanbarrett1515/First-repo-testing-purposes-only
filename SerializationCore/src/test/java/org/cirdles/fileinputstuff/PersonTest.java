/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RyanBarrett
 */
public class PersonTest {
    
    public PersonTest() {
    }
    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEqualsSame() {
        System.out.println("testEqualsSame");
        Person p1 = new Person("Jimmy", "Fallon", "1907");
        Person p2 = new Person("Jimmy", "Fallon", "1907");
        boolean expected = true;
        boolean actual = p1.equals(p2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testEqualsDifferent(){
        System.out.println("testEqualsDifferent");
        Person p1 = new Person("Jimmy", "Fallon", "1907");
        Person p2 = new Person("Candle", "Fallon", "1907");
        boolean expected = false;
        boolean actual = p1.equals(p2);
        assertEquals(expected, actual);
    }

    /**
     * Test of hashCode method, of class Person.
     */
    @Test
    public void testCompareToSame() {
        System.out.println("testCompareToSame");
        Person p1 = new Person("James", "Woods", "1945");
        Person p2 = new Person("James", "Woods", "1945");
        int expected = 0;
        int actual = p1.compareTo(p2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCompareToDifferent() {
        System.out.println("testCompareToSame");
        Person p1 = new Person("James", "Woods", "1945");
        Person p2 = new Person("some other name", "some other last name", "some other date");
        int expected = 1;
        int actual = p1.compareTo(p2);
        assertEquals(expected, actual);
    }
    
    
}
