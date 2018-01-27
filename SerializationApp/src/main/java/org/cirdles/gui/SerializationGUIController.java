/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import org.cirdles.fileinputstuff.BinarySerialization;
import org.cirdles.fileinputstuff.FileInputStuff;
import org.cirdles.fileinputstuff.Person;
import org.cirdles.fileinputstuff.XMLSerialization;
import org.cirdles.fileinputstuff.XStreamSerialization;

/**
 * FXML Controller class
 *
 * @author RyanBarrett
 */
public class SerializationGUIController implements Initializable {

    @FXML
    private AnchorPane RootAnchorPane;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Date;
    @FXML
    private Button CreateNewPerson;
    @FXML
    private MenuBar MainMenuBar;
    @FXML
    private Menu SerializeMenu;
    @FXML
    private MenuItem CSVSerialize;
    @FXML
    private MenuItem BinarySerialize;
    @FXML
    private MenuItem JDOMSerialize;
    @FXML
    private MenuItem XStreamSerialize;
    @FXML
    private Menu DeserializeMenu;
    @FXML
    private MenuItem CSVDeserialize;
    @FXML
    private MenuItem JDOMDeserialize;
    @FXML
    private MenuItem XStreamDeserialize;
    @FXML
    private Button ClearButton;
    @FXML
    private TextArea TextAreaPeople;
    @FXML
    private MenuItem BinaryDeserialize;
    @FXML
    private Button ShowCurrent;

    JButton open = new JButton();
    private JFileChooser fc = new JFileChooser();
    private ArrayList<Person> list = new ArrayList<>();
    private String text = "";
    @FXML
    private Button ResetPeople;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fc.setCurrentDirectory(new File("."));
        fc.setDialogTitle("Select Directory");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    }

    @FXML
    private void CreateNewPersonOnAction(ActionEvent event) {
        list.add(new Person(FirstName.getText(), LastName.getText(), Date.getText()));
        FirstName.clear();
        LastName.clear();
        Date.clear();
        TextAreaPeople.appendText("\n" + list.get(list.size() - 1).personToString());
    }

    @FXML
    private void CSVSerialize(ActionEvent event) {
        try {
            fc.showOpenDialog(open);
            FileInputStuff.makeList(list, fc.getSelectedFile().toString());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nCSVSerialize went wrong.");
        }
    }

    @FXML
    private void BinarySerialize(ActionEvent event) {
        try {
            fc.showOpenDialog(open);
            BinarySerialization.makeList(list, fc.getSelectedFile().toString());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nBinarySerialize went wrong");
        }
    }

    @FXML
    private void JDOMSerialize(ActionEvent event) {
        try {
            fc.showOpenDialog(open);
            XMLSerialization.makeList(list, fc.getSelectedFile());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nJDOMSerialize went wrong.");
        }
    }

    @FXML
    private void XStreamSerialize(ActionEvent event) {
        try {
            fc.showOpenDialog(open);
            XStreamSerialization.makeList(list, fc.getSelectedFile());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nXStreamSerialize went wrong.");
        }
    }

    @FXML
    private void CSVDeserialize(ActionEvent event) {
        ArrayList<Person> csvList = new ArrayList<Person>();

        try {
            fc.showOpenDialog(open);
            FileInputStream fileReader = new FileInputStream(fc.getSelectedFile().toString());
            Scanner fileScanner = new Scanner(fileReader);
            csvList = FileInputStuff.getList(fileScanner);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nCSVDeserialize went wrong.");
        }
        for (int i = 0; i < csvList.size(); i++) {
            list.add(csvList.get(i));
        }
    }

    @FXML
    private void XStreamDeserialize(ActionEvent event) {
        ArrayList<Person> xList = new ArrayList<>();
        try {
            fc.showOpenDialog(open);
            xList = XStreamSerialization.getList(fc.getSelectedFile());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nXStream Deserialize went wrong.");
        }
        for (int i = 0; i < xList.size(); i++) {
            list.add(xList.get(i));
        }
    }

    @FXML
    private void BinaryDeserialize(ActionEvent event) {
        ArrayList<Person> bList = new ArrayList<>();

        try {
            fc.showOpenDialog(open);
            FileInputStream fileReader = new FileInputStream(fc.getSelectedFile().toString());
            ObjectInputStream ois = new ObjectInputStream(fileReader);
            bList = BinarySerialization.getList(ois);
            ois.close();
            fileReader.close();
        } catch (Exception e) {
            TextAreaPeople.appendText("\nBinaryDeserialize went wrong.");
        }
        for (int i = 0; i < bList.size(); i++) {
            list.add(bList.get(i));
        }
    }

    @FXML
    private void JDOMDeserialize(ActionEvent event) {
        ArrayList<Person> jList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        try {
            fc.showOpenDialog(open);
            jList = XMLSerialization.getList(fc.getSelectedFile());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nJDOMDeserialize went wrong.");
        }
        for (int i = 0; i < jList.size(); i++) {
            list.add(jList.get(i));
        }
    }

    @FXML
    private void ShowCurrent(ActionEvent event) {
        for (int i = 0; i < list.size(); i++) {
            TextAreaPeople.appendText("\n" + list.get(i).personToString());
        }
    }

    @FXML
    private void ClearOnAction(ActionEvent event) {
        TextAreaPeople.setText("");
    }

    @FXML
    private void ResetPeople(ActionEvent event) {
        list = new ArrayList<>();
    }
}
