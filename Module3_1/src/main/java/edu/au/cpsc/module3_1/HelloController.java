package edu.au.cpsc.module3_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class HelloController {

    // Search fields (MATCH FXML)
    @FXML private TextField identField;
    @FXML private TextField iataField;
    @FXML private TextField localCodeField;

    // Detail fields
    @FXML private TextField gpsCodeField;
    @FXML private TextField nameField;
    @FXML private TextField elevationField;
    @FXML private TextField countryField;
    @FXML private TextField regionField;
    @FXML private TextField municipalityField;

    // Map + button
    @FXML private WebView mapView;
    @FXML private Button searchButton;

    private List<Airport> airports;

    public HelloController() { }

    @FXML
    public void initialize() {

        try {
            airports = Airport.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        identField.setOnAction(e -> searchAirport());
        iataField.setOnAction(e -> searchAirport());
        localCodeField.setOnAction(e -> searchAirport());
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        String ident = identField.getText().trim();
        String local = localCodeField.getText().trim();

        for (Airport airport : airports) {

            if (!ident.isEmpty()
                    && airport.getGpsCode() != null
                    && ident.equals(airport.getGpsCode().toString())) {

                updateFields(airport);
                updateMap(airport);
                return;
            }

            if (!local.isEmpty()
                    && airport.getLocalCode() != null
                    && local.equals(airport.getLocalCode().toString())) {

                updateFields(airport);
                updateMap(airport);
                return;
            }
        }
    }

    private void updateFields(Airport airport) {
        gpsCodeField.setText(airport.getGpsCode() != null ? airport.getGpsCode().toString() : "");
        nameField.setText(airport.getMunicipality());
        elevationField.setText(
                airport.getElevationFt() != null ? airport.getElevationFt().toString() : ""
        );
        countryField.setText(airport.getCountry());
        regionField.setText(airport.getRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateMap(Airport airport) {
        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        engine.load(
                "https://www.windy.com/?"
                        + airport.getLatitude()
                        + ","
                        + airport.getLongitude()
                        + ",12"
        );
    }
}
