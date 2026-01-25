package edu.au.cpsc.module3_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class HelloController {

    // Search fields (editable)
    @FXML private TextField gpsCodeField;    // mapped from gpsCode
    @FXML private TextField continentField;  // mapped from continent
    @FXML private TextField localCodeField;  // mapped from localCode

    // Read-only fields
    @FXML private TextField typeField;        // no field in Airport, can leave as "N/A"
    @FXML private TextField nameField;        // mapped from municipality
    @FXML private TextField elevationField;   // mapped from elevationFt
    @FXML private TextField countryField;     // mapped from country
    @FXML private TextField regionField;      // mapped from region
    @FXML private TextField municipalityField; // mapped from municipality

    // WebView for the map
    @FXML private WebView mapView;

    // Search button
    @FXML private Button searchButton;

    private List<Airport> airports;

    public HelloController(TextField gpsCodeField, TextField continentField) {
        this.gpsCodeField = gpsCodeField;
        this.continentField = continentField;
    }

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll(); // Load CSV once at startup
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Trigger search when Enter is pressed in any search field
        gpsCodeField.setOnAction(e -> searchAirport());
        continentField.setOnAction(e -> searchAirport());
        localCodeField.setOnAction(e -> searchAirport());

        // Trigger search when the button is clicked
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        Airport found = null;

        // Search based on first non-empty field
        String gps = gpsCodeField.getText().trim();
        String continent = continentField.getText().trim();
        String local = localCodeField.getText().trim();

        for (Airport airport : airports) {
            if (!gps.isEmpty() && airport.getGpsCode() != null && gps.equals(airport.getGpsCode().toString())) {
                found = airport;
                break;
            } else if (!continent.isEmpty() && continent.equalsIgnoreCase(airport.getContinent())) {
                found = airport;
                break;
            } else if (!local.isEmpty() && airport.getLocalCode() != null && local.equals(airport.getLocalCode().toString())) {
                found = airport;
                break;
            }
        }

        if (found != null) {
            updateFields(found);
            updateMap(found);
        }
    }

    private void updateFields(Airport airport) {
        typeField.setText("N/A");  // no type in Airport class
        nameField.setText(airport.getMunicipality());
        elevationField.setText(airport.getElevationFt() != null ? airport.getElevationFt().toString() : "");
        countryField.setText(airport.getCountry());
        regionField.setText(airport.getRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateMap(Airport airport) {
        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        // Note: longitude comes first in CSV, but Windy expects latitude,longitude
        engine.load("https://www.windy.com/?" + airport.getLatitude() + "," + airport.getLongitude() + ",12");
    }
}
