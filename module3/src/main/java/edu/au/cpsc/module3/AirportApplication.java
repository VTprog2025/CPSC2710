package edu.au.cpsc.module3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AirportApplication extends Application {

    @FXML
    private void onSearch() {
        System.out.println("Search button clicked!");
        // TODO: add your logic to read CSV and populate fields
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                AirportApplication.class.getResource("/edu/au/cpsc/module3/airport-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Christopher Boartfield's Airport Mapview App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
