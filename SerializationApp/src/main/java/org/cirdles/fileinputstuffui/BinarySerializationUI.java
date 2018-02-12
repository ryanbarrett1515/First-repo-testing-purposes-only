/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuffui;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import org.cirdles.fileinputstuff.BinarySerialization;
import org.cirdles.fileinputstuff.People;
/**
 *
 * @author RyanBarrett
 */
public class BinarySerializationUI {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        People list;

        try {
            FileInputStream fileReader = new FileInputStream("Binary/BinarySerialization.ser");
            ObjectInputStream ois = new ObjectInputStream(fileReader);
            list = BinarySerialization.getList(ois);
            ois.close();
            fileReader.close();

            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).personToString());
            }
            String entry = "";
            BinarySerialization.getPeople(entry, userInput, list);
            BinarySerialization.makeList(list, "Binary/BinarySerialization.ser");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
