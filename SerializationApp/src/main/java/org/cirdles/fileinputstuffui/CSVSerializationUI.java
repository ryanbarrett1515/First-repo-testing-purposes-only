/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuffui;

import java.io.FileInputStream;
import java.util.Scanner;
import org.cirdles.fileinputstuff.FileInputStuff;
import org.cirdles.fileinputstuff.People;
/**
 *
 * @author RyanBarrett
 */
public class CSVSerializationUI {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        People list;

        try {
            FileInputStream fileReader = new FileInputStream("People/People.CSV");
            Scanner fileScanner = new Scanner(fileReader);
            list = FileInputStuff.getList(fileScanner);

            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).personToString());
            }
            String entry = "";
            FileInputStuff.getPeople(entry, userInput, list);
            FileInputStuff.makeList(list, "People/People.CSV");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}