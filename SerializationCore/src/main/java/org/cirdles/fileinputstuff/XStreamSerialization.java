/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RyanBarrett
 */
public class XStreamSerialization {
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Person> list;

        try {
            File file = new File("XStreamSerialization/XStreamSerialization.xml");
            list = getList(file);

            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            String entry = "";
            getPeople(entry, userInput, list);
            makeList(list, file);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    
    public static XStream getXStream(){
        XStream xstream = new XStream();
        xstream.aliasPackage("people", "java.util.ArrayList");
        xstream.alias("person", Person.class);
        return xstream;
    }

    //returns list of persons
    public static ArrayList<Person> getList(File file) {
        XStream xStream = getXStream();
        ArrayList<Person> list = (ArrayList) xStream.fromXML(file);
        return list;
    }

    //makes list of persons on file
    public static void makeList(ArrayList<Person> list, File file) throws Exception {
        XStream xstream = getXStream();
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter fileWriter = new PrintWriter(fos);
        fileWriter.print(xstream.toXML(list));
        fileWriter.close();
        fos.close();
    }

    //gets more people from user
    public static void getPeople(String entry, Scanner userInput, ArrayList<Person> list) {
        while (!entry.equals("q")) {
            if (entry.equals("a")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).personToString());
                }
            } else if (!entry.equals("")) {
                list.add(getPerson(entry));
            }
            System.out.println("To add new people enter people in the form \"first name, last name, DOB\", enter q to quit,");
            System.out.println("or to  see current people on file enter a:");
            entry = userInput.nextLine();
        }
    }

    //creates a person from a line of code
    public static Person getPerson(String entry) {
        String firstName = entry.substring(0, entry.indexOf(",")).trim();
        String lastName = entry.substring(entry.indexOf(",") + 1, entry.lastIndexOf(",")).trim();
        String DOB = entry.substring(entry.lastIndexOf(",") + 1).trim();
        return new Person(firstName, lastName, DOB);
    }
}