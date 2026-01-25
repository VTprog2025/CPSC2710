package edu.au.cpsc.module3_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AirportApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                AirportApplication.class.getResource("/edu/au/cpsc/module3_1/hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Christopher Boartfield's Airport Mapview App");
        stage.setScene(scene);
        stage.show();
    }

    static void main(String[] args) {
        launch();
    }
}