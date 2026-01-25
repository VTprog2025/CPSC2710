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
    @FXML private TextField identField;
    @FXML private TextField iataField;
    @FXML private TextField localCodeField;

    // Read-only fields
    @FXML private TextField typeField;
    @FXML private TextField nameField;
    @FXML private TextField elevationField;
    @FXML private TextField countryField;
    @FXML private TextField regionField;
    @FXML private TextField municipalityField;

    // WebView for the map
    @FXML private WebView mapView;

    // Search button
    @FXML private Button searchButton;

    private List<Airport> airports;

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll(); // Load CSV once at startup
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Trigger search when Enter is pressed in any search field
        identField.setOnAction(e -> searchAirport());
        iataField.setOnAction(e -> searchAirport());
        localCodeField.setOnAction(e -> searchAirport());

        // Trigger search when the button is clicked
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        Airport found = null;

        // Search based on first non-empty field
        String ident = identField.getText().trim();
        String iata = iataField.getText().trim();
        String local = localCodeField.getText().trim();

        for (Airport airport : airports) {
            if (!ident.isEmpty() && ident.equals(airport.getGpsCode() != null ? airport.getGpsCode().toString() : "")) {
                found = airport;
                break;
            } else if (!iata.isEmpty() && iata.equals(airport.getContinent())) { // Replace with actual IATA column
                found = airport;
                break;
            } else if (!local.isEmpty() && local.equals(airport.getLocalCode() != null ? airport.getLocalCode().toString() : "")) {
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
        // Fill read-only fields
        typeField.setText("N/A"); // Replace with actual type if available in CSV
        nameField.setText(airport.getMunicipality()); // Adjust as needed
        elevationField.setText(airport.getElevationFt() != null ? airport.getElevationFt().toString() : "");
        countryField.setText(airport.getCountry());
        regionField.setText(airport.getRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateMap(Airport airport) {
        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        // Load Windy map URL
        engine.load("https://www.windy.com/?" + airport.getLatitude() + "," + airport.getLongitude() + ",12");
    }
}
