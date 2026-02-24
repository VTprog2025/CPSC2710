package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
 * CPSC 2710 Final Project
 * Christopher Boartfield
 * 2-25-2026
 * A task manager application program to help the user remember and complete tasks.
 */

public class TaskManagerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                TaskManagerApplication.class.getResource("/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        scene.getStylesheets().add(
                TaskManagerApplication.class.getResource("/style.css").toExternalForm());
        stage.setTitle("Christopher Boartfield's Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}