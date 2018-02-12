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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.cirdles.fileinputstuff.BinarySerialization;
import org.cirdles.fileinputstuff.FileInputStuff;
import org.cirdles.fileinputstuff.People;
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
    private Button ShowCurrentButton;
    @FXML
    private Button ResetPeopleButton;

    private FileChooser fc;
    private People list;
    private String text;

    private FileChooser.ExtensionFilter BinaryExtension = new FileChooser.ExtensionFilter("Binary Serialization (.SER)", "*.SER");
    private FileChooser.ExtensionFilter CSVExtension = new FileChooser.ExtensionFilter("CSV Serialization (.CSV", "*.CSV");
    private FileChooser.ExtensionFilter XMLExtension = new FileChooser.ExtensionFilter("XML Serialization (.xml", "*.xml");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fc = new FileChooser();
        text = "";
        list = new People();
        fc.setTitle("Choose a File");
        File initialDirectory = new File(".");
        fc.setInitialDirectory(initialDirectory);
        setStyles();
    }
    
    private void setStyles(){
        String buttonFont = "-fx-font-size: 16; -fx-font-family: \"Times New Roman\"";
        String menuBarFont = "-fx-font-size: 20; -fx-font-family: \"Times New Roman\"; -fx-font-weight: bold";
        String menuItemFont = "-fx-font-size: 18; -fx-font-family: \"Times New Roman\"";
        String resetButtonStyle = "-fx-font-size: 12; -fx-font-family: \"Times New Roman\"; -fx-background-color: yellow";
        
        MainMenuBar.setStyle(menuBarFont);
        ShowCurrentButton.setStyle(buttonFont);
        CreateNewPerson.setStyle(buttonFont);
        ClearButton.setStyle(buttonFont);
        ResetPeopleButton.setStyle(buttonFont);
        ResetPeopleButton.setStyle(resetButtonStyle);
        TextAreaPeople.setStyle(buttonFont);
        CSVSerialize.setStyle(menuItemFont);
        BinarySerialize.setStyle(menuItemFont);
        JDOMSerialize.setStyle(menuItemFont);
        XStreamSerialize.setStyle(menuItemFont);
        CSVDeserialize.setStyle(menuItemFont);
        BinaryDeserialize.setStyle(menuItemFont);
        JDOMDeserialize.setStyle(menuItemFont);
        XStreamDeserialize.setStyle(menuItemFont);
    }

    @FXML
    private void CreateNewPersonOnAction(ActionEvent event) {
        if (!FirstName.getText().equals("") && !LastName.getText().equals("") && !Date.getText().equals("")) {
            list.add(new Person(FirstName.getText(), LastName.getText(), Date.getText()));
            FirstName.clear();
            LastName.clear();
            Date.clear();
            TextAreaPeople.appendText("\n" + list.get(list.size() - 1).personToString());
        } else {
            TextAreaPeople.appendText("\nPlease Complete All Fields.");
        }
    }

    @FXML
    private void CSVSerializeAction(ActionEvent event) {
        try {
            fc.setSelectedExtensionFilter(XMLExtension);
            String fileName = fc.showSaveDialog(new Stage()).toString();
            FileInputStuff.makeList(list, fileName);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nCSVSerialize went wrong.");
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void BinarySerializeAction(ActionEvent event) {
        try {
            fc.setSelectedExtensionFilter(BinaryExtension);
            BinarySerialization.makeList(list, fc.showSaveDialog(new Stage()).toString());
        } catch (Exception e) {
            TextAreaPeople.appendText("\nBinarySerialize went wrong");
        }
    }

    @FXML
    private void JDOMSerializeAction(ActionEvent event) {
        try {
            fc.setSelectedExtensionFilter(XMLExtension);
            XMLSerialization.makeList(list, fc.showSaveDialog(new Stage()));
        } catch (Exception e) {
            TextAreaPeople.appendText("\nJDOMSerialize went wrong.");
        }
    }

    @FXML
    private void XStreamSerializeAction(ActionEvent event) {
        try {
            fc.setSelectedExtensionFilter(XMLExtension);
            XStreamSerialization.makeList(list, fc.showSaveDialog(new Stage()));
        } catch (Exception e) {
            TextAreaPeople.appendText("\nXStreamSerialize went wrong.");
        }
    }

    @FXML
    private void CSVDeserializeAction(ActionEvent event) {
        People csvList = new People();

        try {
            fc.setSelectedExtensionFilter(CSVExtension);
            FileInputStream fileReader = new FileInputStream(fc.showOpenDialog(new Stage()).toString());
            Scanner fileScanner = new Scanner(fileReader);
            csvList = FileInputStuff.getList(fileScanner);
            ShowCurrent(event);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nCSVDeserialize went wrong.");
        }
        for (int i = 0; i < csvList.size(); i++) {
            list.add(csvList.get(i));
        }
        ShowCurrent(event);
    }

    @FXML
    private void XStreamDeserializeAction(ActionEvent event) {
        People xList = new People();
        try {
            fc.setSelectedExtensionFilter(XMLExtension);
            xList = XStreamSerialization.getList(fc.showOpenDialog(new Stage()));
            ShowCurrent(event);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nXStream Deserialize went wrong.");
        }
        for (int i = 0; i < xList.size(); i++) {
            list.add(xList.get(i));
        }
        ShowCurrent(event);
    }

    @FXML
    private void BinaryDeserializeAction(ActionEvent event) {
        People bList = new People();

        try {
            fc.setSelectedExtensionFilter(BinaryExtension);
            FileInputStream fileReader = new FileInputStream(fc.showOpenDialog(new Stage()).toString());
            ObjectInputStream ois = new ObjectInputStream(fileReader);
            bList = BinarySerialization.getList(ois);
            ois.close();
            fileReader.close();
            ShowCurrent(event);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nBinaryDeserialize went wrong.");
        }
        for (int i = 0; i < bList.size(); i++) {
            list.add(bList.get(i));
        }
        ShowCurrent(event);
    }

    @FXML
    private void JDOMDeserializeAction(ActionEvent event) {
        People jList = new People();
        Scanner scan = new Scanner(System.in);
        try {
            fc.setSelectedExtensionFilter(XMLExtension);
            jList = XMLSerialization.getList(fc.showOpenDialog(new Stage()));
            ShowCurrent(event);
        } catch (Exception e) {
            TextAreaPeople.appendText("\nJDOMDeserialize went wrong.");
        }
        for (int i = 0; i < jList.size(); i++) {
            list.add(jList.get(i));
        }
        ShowCurrent(event);
    }

    @FXML
    private void ShowCurrent(ActionEvent event) {
        ClearOnAction(event);
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
        list = new People();
        ClearOnAction(event);
    }
}
