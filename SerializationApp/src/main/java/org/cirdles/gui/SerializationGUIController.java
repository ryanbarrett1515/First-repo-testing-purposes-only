/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.cirdles.fileinputstuff.Person;
import org.cirdles.fileinputstuff.XMLSerialization;

/**
 * FXML Controller class
 *
 * @author RyanBarrett
 */
public class SerializationGUIController implements Initializable {

    @FXML
    private MenuButton Menu;
    @FXML
    private MenuItem MenuItemDeserialize;
    @FXML
    private MenuItem MenuItemShowCurrent;
    @FXML
    private MenuItem MenuItemSerialize;
    @FXML
    private AnchorPane RootAnchorPane;
    @FXML
    private TextField TextFieldPeople;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Date;
    @FXML
    private Button CreateNewPerson;

    private ArrayList<Person> list;
    private String text = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void DeserializeOnAction(ActionEvent event) {
        try {
            File file = new File("XML/people.xml");
            list = XMLSerialization.getList(file);
        } catch (Exception e) {
            TextFieldPeople.setText("Something went wrong.");
        }
    }

    @FXML
    private void ShowCurrentOnAction(ActionEvent event) {
        TextFieldPeople.setText("Current People");
        for (int i = 0; i < list.size(); i++) {
            TextFieldPeople.appendText(list.get(i).personToString());
        }
    }

    @FXML
    private void SerializeOnAction(ActionEvent event) {
        try {
            File file = new File("XML/people.xml");
            XMLSerialization.makeList(list, file);
        } catch (Exception e) {
            TextFieldPeople.setText("Something went wrong.");
        }
    }

    @FXML
    private void CreateNewPersonOnAction(ActionEvent event) {
        list.add(new Person(FirstName.getText(), LastName.getText(), Date.getText()));
        FirstName.clear();
        LastName.clear();
        Date.clear();
    }

}
