package edu.au.cpsc.miscstyle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
Project: project5
Author: Christopher Boartfield
auburn email: clb0214@auburn.edu
Date:2/7/2026
Description: Project5 controller.
 */

public class Part1Application extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML from resource folder
        Parent root = FXMLLoader.load(getClass().getResource("/edu/au/cpsc/miscstyle/part1.fxml"));

        Scene scene = new Scene(root);

        // Load CSS from resource folder
        scene.getStylesheets().add(getClass().getResource("/edu/au/cpsc/miscstyle/main.css").toExternalForm());

        primaryStage.setTitle("YourName YourLastName's Flight Designator App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
