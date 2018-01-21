/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author RyanBarrett
 */
public class SerializationMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Serialization");
        Parent root = new AnchorPane();
        Scene scene = new Scene(root, 498, 480);
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });

        scene.setRoot(FXMLLoader.load(getClass().getResource("SerializationGUI.fxml")));

        primaryStage.show();
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(100);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
