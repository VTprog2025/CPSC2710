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
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/miscstyle/part1.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Christopher Boartfield's Flight App");
        stage.setScene(scene);
        stage.show();
    }
}