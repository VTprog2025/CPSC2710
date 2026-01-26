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

    // Details fields
    @FXML private TextField gpsCodeField;      // used as Type display
    @FXML private TextField nameField;
    @FXML private TextField elevationField;
    @FXML private TextField countryField;
    @FXML private TextField regionField;
    @FXML private TextField municipalityField;

    @FXML private Button searchButton;
    @FXML private WebView mapView;

    private List<Airport> airports;

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        String ident = identField.getText().trim();
        String iata = iataField.getText().trim();
        String local = localCodeField.getText().trim();

        for (Airport airport : airports) {

            if (!ident.isEmpty() && ident.equalsIgnoreCase(airport.getIdent())) {
                updateUI(airport);
                return;
            }

            if (!iata.isEmpty() && iata.equalsIgnoreCase(airport.getIataCode())) {
                updateUI(airport);
                return;
            }

            if (!local.isEmpty()
                    && airport.getLocalCode() != null
                    && local.equals(airport.getLocalCode().toString())) {
                updateUI(airport);
                return;
            }
        }
    }

    private void updateUI(Airport airport) {

        gpsCodeField.setText("N/A"); // Type not in CSV
        nameField.setText(airport.getMunicipality());
        elevationField.setText(
                airport.getElevationFt() == null ? "" : airport.getElevationFt().toString()
        );
        countryField.setText(airport.getCountry());
        regionField.setText(airport.getRegion());
        municipalityField.setText(airport.getMunicipality());

        updateMap(airport);
    }

    private void updateMap(Airport airport) {
        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        engine.load(
                "https://www.windy.com/?"
                        + airport.getLatitude()
                        + ","
                        + airport.getLongitude()
                        + ",10"
        );
    }
}
