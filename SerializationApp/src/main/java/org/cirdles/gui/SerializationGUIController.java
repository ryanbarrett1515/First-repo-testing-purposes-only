/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import org.cirdles.fileinputstuff.Person;

/**
 * FXML Controller class
 *
 * @author RyanBarrett
 */
public class SerializationGUIController implements Initializable {

    @FXML
    private AnchorPane RootAnchorPane;
    private TextField TextFieldPeople;
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
    private MenuItem BInaryDeserialize;

    private ArrayList<Person> list;
    private String text = "";
    @FXML
    private TextArea TextAreaPeople;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CreateNewPersonOnAction(ActionEvent event) {
        list.add(new Person(FirstName.getText(), LastName.getText(), Date.getText()));
        FirstName.clear();
        LastName.clear();
        Date.clear();
    }

    @FXML
    private void CSVSerialize(ActionEvent event) {
    }

    @FXML
    private void BinarySerialize(ActionEvent event) {
    }

    @FXML
    private void JDOMSerialize(ActionEvent event) {
    }

    @FXML
    private void XStreamSerialize(ActionEvent event) {
    }

    @FXML
    private void CSVDeserialize(ActionEvent event) {
    }

    @FXML
    private void XStreamDeserialize(ActionEvent event) {
    }

    @FXML
    private void ClearOnAction(ActionEvent event) {
    }

    @FXML
    private void BinaryDeserialize(ActionEvent event) {
    }

    @FXML
    private void JDOMDeserialize(ActionEvent event) {
    }

}
//something something something something something something something something
