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
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLSerialization {

    public static void main(String[] args) {
        ArrayList<Person> list;
        Scanner scan = new Scanner(System.in);
        try {
            File file = new File("XML/people.xml");
            list = getList(file);
            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            getPeople(scan, list);
            makeList(list, file);
        } catch (IOException e) {
            System.out.println("Something went wrong with io: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    //returns list of persons
    public static ArrayList<Person> getList(File file) {
        ArrayList<Person> list = new ArrayList<>();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = (Document) builder.build(file);
            Element root = doc.getRootElement();
            List nodes = root.getChildren("person");
            for(int i = 0; i < nodes.size(); i++){
                Element node = (Element)nodes.get(i);
                list.add(new Person(node.getChildText("first"), node.getChildText("last"), node.getChildText("dob")));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong with doc stuff: ");
        }
        return list;
    }

    //makes list of persons on file
    public static void makeList(ArrayList<Person> list, File file) throws Exception {
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        SAXBuilder builder = new SAXBuilder();
        Document doc = (Document) builder.build(file);
        ArrayList<Person> current = getList(file);
        Element root = doc.getRootElement();
        for(int i = list.size() - current.size(); i < list.size(); i++){
            Element person = new Element("person");
            person.addContent(new Element("first").setText(list.get(i).getFirstName()));
            person.addContent(new Element("last").setText(list.get(i).getLastName()));
            person.addContent(new Element("dob").setText(list.get(i).getDOB()));
            root.addContent(person);
        }
        outputter.output(doc, new FileWriter(file));
    }

    //gets more people from user
    public static void getPeople(Scanner userInput, ArrayList<Person> list) {
        String entry = "";
        do {
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
        } while (!entry.equals("q"));
    }

    //creates a person from a line of code
    public static Person getPerson(String entry) {
        String firstName = entry.substring(0, entry.indexOf(",")).trim();
        String lastName = entry.substring(entry.indexOf(",") + 1, entry.lastIndexOf(",")).trim();
        String DOB = entry.substring(entry.lastIndexOf(",") + 1).trim();
        return new Person(firstName, lastName, DOB);
    }
}
