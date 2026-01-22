package edu.au.cpsc.module3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
/*
* Project: Module3 Assignment
* Author: Christopher Boartfield
* AU_Email: clb0214@auburn.edu
* Date: 1-22-2026
* Making an Airport class that can help run Airport Application.
 */

public class Airport {

    int elevationFt;
    String continent;
    String country;
    String region;
    String municipality;
    int gpsCode;
    String int localCode;
    double latitude;
    double longitude;


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
