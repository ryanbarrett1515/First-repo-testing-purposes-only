/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

/**
 *
 * @author RyanBarrett
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import org.dom4j.io.SAXReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class XMLSerialization {
    
    public static void main(String[] args) {
        XStream xstream = new XStream();
    }

    //returns list of persons
    public static ArrayList<Person> getList() throws Exception {
        return new ArrayList<Person>();
    }

    //makes list of persons on file
    public static void makeList() throws Exception {
    }

    //gets more people from user
    public static void getPeople() {
    }

    //creates a person from a line of code
    public static Person getPerson(String entry) {
        String firstName = entry.substring(0, entry.indexOf(",")).trim();
        String lastName = entry.substring(entry.indexOf(",") + 1, entry.lastIndexOf(",")).trim();
        String DOB = entry.substring(entry.lastIndexOf(",") + 1).trim();
        return new Person(firstName, lastName, DOB);
    }
}
