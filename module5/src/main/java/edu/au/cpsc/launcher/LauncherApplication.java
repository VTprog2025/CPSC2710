package edu.au.cpsc.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class LauncherApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/launcher/launcher-app.fxml")
        );

        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("/launcher/style/main.css").toExternalForm()
        );

        primaryStage.setTitle("Christopher Boartfield's Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
