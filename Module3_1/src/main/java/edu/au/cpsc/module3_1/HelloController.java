package edu.au.cpsc.module3_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class HelloController {

    // Search fields (from FXML)
    @FXML private TextField identField;
    @FXML private TextField iataField;
    @FXML private TextField localCodeField;

    // Detail fields
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

    public HelloController() {}

    @FXML
    public void initialize() {

        try {
            airports = Airport.readAll();
            System.out.println("Loaded " + airports.size() + " airports");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        identField.setOnAction(e -> searchAirport());
        iataField.setOnAction(e -> searchAirport());
        localCodeField.setOnAction(e -> searchAirport());
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {

        String ident = identField.getText().trim();
        String iata  = iataField.getText().trim();
        String local = localCodeField.getText().trim();

        Airport found = null;

        for (Airport airport : airports) {

            if (!ident.isEmpty() && ident.equalsIgnoreCase(airport.getIdent())) {
                found = airport;
                break;
            }
            if (!iata.isEmpty() && airport.getIataCode() != null &&
                    iata.equalsIgnoreCase(airport.getIataCode())) {
                found = airport;
                break;
            }
            if (!local.isEmpty() && airport.getLocalCode() != null &&
                    local.equalsIgnoreCase(airport.getLocalCode())) {
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

        nameField.setText(airport.getMunicipality());
        elevationField.setText(
                airport.getElevationFt() != null
                        ? airport.getElevationFt().toString()
                        : ""
        );
        countryField.setText(airport.getCountry());
        regionField.setText(airport.getRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateMap(Airport airport) {

        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        engine.load(
                "https://www.windy.com/?" +
                        airport.getLatitude() + "," +
                        airport.getLongitude() + ",12"
        );
    }
}
