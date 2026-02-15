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

    // Keep a reference to the controller so we can save the database on exit
    private FlightScheduleController flightController;

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML
        FXMLLoader fxmlLoader =
                new FXMLLoader(FlightScheduleApplication.class.getResource("part2-view.fxml"));

        // Load the scene
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);

        // Get the controller from the FXMLLoader
        flightController = fxmlLoader.getController();

        // Set up the stage
        stage.setTitle("Christopher Boartfield's Flight Schedule Application V2");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        // This method is automatically called when the app closes
        // Save the database so changes persist across runs
        if (flightController != null) {
            flightController.saveDatabase();
        }
        super.stop();
    }

    static void main(String[] ignoredArgs) {
        // Launch the JavaFX application
        launch();
    }
}
