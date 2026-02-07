package edu.au.cpsc.miscstyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
Project: project5
Author: Christopher Boartfield
auburn email: clb0214@auburn.edu
Date:2/7/2026
Description: Project5 controller.
 */

public class Part1Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(Part1Application.class.getResource("part1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Christopher Boartfields Flight App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}