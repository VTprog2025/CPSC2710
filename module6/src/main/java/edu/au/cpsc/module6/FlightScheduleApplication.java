package edu.au.cpsc.module6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Project: project6
 * Author: Christopher
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-02-14
 * Description: Flight Designator App.
 */

public class FlightScheduleApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightScheduleApplication.class.getResource("flight-schedule-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Christopher Boartfield's Flight Schedule Application V2");
        stage.setScene(scene);
        stage.show();
    }

    static void main(String[] ignoredArgs) {
        launch();
    }
}