package edu.au.cpsc.module4;
/*
* Project: Module4 Assignment
* Author: Christopher Boartfield
* auburn email: clb0214@auburn.edu
* Date: 1-27-2026
* Description: Flight schedule application
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightScheduleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightScheduleApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Christopher Boartfield's Flight Schedule Application");
        stage.setScene(scene);
        stage.show();
    }

}
