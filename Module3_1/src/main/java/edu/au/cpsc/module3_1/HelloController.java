package edu.au.cpsc.module3_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class HelloController {

    // Search fields
    @FXML private TextField identField;
    @FXML private TextField iataField;
    @FXML private TextField localCodeField;

    // Detail fields
    @FXML private TextField typeField;
    @FXML private TextField nameField;
    @FXML private TextField elevationField;
    @FXML private TextField countryField;
    @FXML private TextField regionField;
    @FXML private TextField municipalityField;

    // Map
    @FXML private WebView mapView;

    // Button
    @FXML private Button searchButton;

    private List<Airport> airports;

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll();
            System.out.println("Loaded " + airports.size() + " airports");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Trigger search when Enter is pressed or button clicked
        identField.setOnAction(e -> searchAirport());
        iataField.setOnAction(e -> searchAirport());
        localCodeField.setOnAction(e -> searchAirport());
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        String ident = identField.getText().trim();
        String iata  = iataField.getText().trim();
        String local = localCodeField.getText().trim();

        Airport found = null;

        for (Airport airport : airports) {
            if (!ident.isEmpty() && ident.equalsIgnoreCase(airport.getIdent())) {
                found = airport;
                break;
            }
            if (!iata.isEmpty() && iata.equalsIgnoreCase(airport.getIataCode())) {
                found = airport;
                break;
            }
            if (!local.isEmpty() && local.equalsIgnoreCase(airport.getLocalCode())) {
                found = airport;
                break;
            }
        }

        if (found != null) {
            updateFields(found);
            updateMap(found);
        } else {
            clearFields();
        }
    }

    private void updateFields(Airport airport) {
        typeField.setText(safeString(airport.getType()));
        nameField.setText(safeString(airport.getName()));
        elevationField.setText(safeString(airport.getElevationFt()));
        countryField.setText(safeString(airport.getCountry()));
        regionField.setText(safeString(airport.getRegion()));
        municipalityField.setText(safeString(airport.getMunicipality()));
    }

    private void updateMap(Airport airport) {
        Double lat = airport.getLatitude();
        Double lon = airport.getLongitude();
        if (lat == null || lon == null) return;

        WebEngine engine = mapView.getEngine();
        engine.load("https://www.windy.com/?" + lat + "," + lon + ",12");
    }

    private void clearFields() {
        typeField.clear();
        nameField.clear();
        elevationField.clear();
        countryField.clear();
        regionField.clear();
        municipalityField.clear();
        WebEngine engine = mapView.getEngine();
        engine.load(""); // clear map
    }

    // Utility to safely handle nulls
    private String safeString(Object obj) {
        return obj != null ? obj.toString() : "";
    }
}
