package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskManagerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                TaskManagerApplication.class.getResource("module7/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        scene.getStylesheets().add(
                TaskManagerApplication.class.getResource("module7/styles.css").toExternalForm());
        stage.setTitle("Christopher Boartfields Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}