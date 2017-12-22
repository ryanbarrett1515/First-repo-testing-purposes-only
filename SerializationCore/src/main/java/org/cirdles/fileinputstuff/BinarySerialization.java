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
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySerialization {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Person> list;

        try {
            FileInputStream fileReader = new FileInputStream("Binary/BinarySerialization");
            ObjectInputStream ois = new ObjectInputStream(fileReader);
            list = getList(ois);
            ois.close();
            fileReader.close();

            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            String entry = "";
            getPeople(entry, userInput, list);
            makeList(list, "Binary/BinarySerialization");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    //returns list of persons
    public static ArrayList<Person> getList(ObjectInputStream ois) throws Exception {
        ArrayList<Person> list = new ArrayList<>();
        try {
            while (true) {
                list.add((Person) ois.readObject());
            }
        } catch (Exception e) {
            return list;
        }
    }

    //makes list of persons on file
    public static void makeList(ArrayList<Person> list, String name) throws Exception {
        FileOutputStream finalFile = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(finalFile);
        for (int i = 0; i < list.size(); i++) {
            oos.writeObject(list.get(i));
        }
        oos.close();
    }

    //gets more people from user
    public static void getPeople(String entry, Scanner userInput, ArrayList<Person> list) {
        while (!entry.equals("q")) {
            if (entry.equals("a")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
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
