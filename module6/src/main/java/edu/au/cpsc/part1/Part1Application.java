package edu.au.cpsc.part1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/*
 * Project 6
 * Christopher Boartfield
 * clb0214@auburn.edu
 * 2-13-2026
 * Controller for Part1 Project 6.
 */

public class Part1Application extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Part1Application.class.getResource("part1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Part 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}