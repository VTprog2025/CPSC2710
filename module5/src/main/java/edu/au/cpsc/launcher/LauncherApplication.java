package edu.au.cpsc.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/launcher/launcher-app.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Launcher App");
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);  // Adjust as needed
        primaryStage.setHeight(400); // Adjust as needed
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
