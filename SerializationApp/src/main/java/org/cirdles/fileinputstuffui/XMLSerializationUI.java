/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuffui;

import java.io.File;
import java.util.Scanner;
import org.cirdles.fileinputstuff.People;
import org.cirdles.fileinputstuff.XMLSerialization;

/**
 *
 * @author RyanBarrett
 */
public class XMLSerializationUI {

    public static void main(String[] args) {
        People list;
        Scanner scan = new Scanner(System.in);
        try {
            File file = new File("XML/people.xml");
            list = XMLSerialization.getList(file);
            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).personToString());
            }
            XMLSerialization.getPeople(scan, list);
            XMLSerialization.makeList(list, file);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}
