package org.cirdles.fileinputstuff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author RyanBarrett
 */
import java.util.*;
import java.io.*;
public class FileInputStuff {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();

        try{
            FileInputStream fileReader = new FileInputStream("People/People.CSV");
            Scanner fileScanner = new Scanner(fileReader);
            list = getList(fileScanner);
            
            System.out.println("Current people on file: ");
            for(int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
            String entry = "";
            getPeople(entry, userInput, list);
            makeList(list, "People/People.CSV");
        }catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

    //returns list of persons
    public static ArrayList<Person> getList(Scanner fileScanner){
        ArrayList<Person> list = new ArrayList<>();
        while(fileScanner.hasNextLine())
            list.add(getPerson(fileScanner.nextLine()));
        return list;
    }

    //makes list of persons on file
    public static void makeList(ArrayList<Person> list, String name) throws Exception{
        FileOutputStream finalFile = new FileOutputStream(name);
        PrintWriter fileWriter = new PrintWriter(finalFile);
        for(int i = 0; i < list.size(); i++)
            fileWriter.println(list.get(i).getFirstName() + ", "
                + list.get(i).getLastName() + ", " + list.get(i).getDOB());
        fileWriter.close();
    }

    //gets more people from user
    public static void getPeople(String entry, Scanner userInput, ArrayList<Person> list){
        while(!entry.equals("q")){            
            if(entry.equals("a"))
                for(int i = 0; i < list.size(); i++)
                    System.out.println(list.get(i));
            else if(!entry.equals(""))
                list.add(getPerson(entry));
            System.out.println("To add new people enter people in the form \"first name, last name, DOB\", enter q to quit,");
            System.out.println("or to  see current people on file enter a:" );
            entry = userInput.nextLine();
        }
    }

    //creates a person from a line of code
    public static Person getPerson(String entry){
        String firstName = entry.substring(0, entry.indexOf(",")).trim();
        String lastName = entry.substring(entry.indexOf(",") + 1, entry.lastIndexOf(",")).trim();
        String DOB = entry.substring(entry.lastIndexOf(",") + 1).trim();
        return new Person(firstName, lastName, DOB);
    }
}