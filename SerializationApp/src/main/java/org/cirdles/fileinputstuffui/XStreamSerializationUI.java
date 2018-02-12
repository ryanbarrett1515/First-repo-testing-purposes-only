/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuffui;

import java.io.File;
import java.util.Scanner;
import org.cirdles.fileinputstuff.People;
import org.cirdles.fileinputstuff.XStreamSerialization;

/**
 *
 * @author RyanBarrett
 */
public class XStreamSerializationUI {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        try {
            File file = new File("XStreamSerialization/XStreamSerialization.xml");
            People list = XStreamSerialization.getList(file);

            System.out.println("Current people on file: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).personToString());
            }
            String entry = "";
            XStreamSerialization.getPeople(entry, userInput, list);
            XStreamSerialization.makeList(list, file);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}