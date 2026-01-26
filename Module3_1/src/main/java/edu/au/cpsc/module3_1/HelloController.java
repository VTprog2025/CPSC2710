package edu.au.cpsc.module3_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class HelloController {

    // Search field
    @FXML private TextField localCodeField;

    // Detail fields
    @FXML
    private TextField typeField;
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
        localCodeField.setOnAction(e -> searchAirport());
        searchButton.setOnAction(e -> searchAirport());
    }

    private void searchAirport() {
        if (airports == null || airports.isEmpty()) return;

        String local = localCodeField.getText().trim();

        Airport found = null;

        for (Airport airport : airports) {
            if (!local.isEmpty() && airport.getLocalCode() != null &&
                    local.equalsIgnoreCase(airport.getLocalCode().toString())) {
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
        getTypeField().setText("N/A"); // No type in Airport class
        nameField.setText(airport.getMunicipality() != null ? airport.getMunicipality() : "");
        elevationField.setText(airport.getElevationFt() != null ? airport.getElevationFt().toString() : "");
        countryField.setText(airport.getCountry() != null ? airport.getCountry() : "");
        regionField.setText(airport.getRegion() != null ? airport.getRegion() : "");
        municipalityField.setText(airport.getMunicipality() != null ? airport.getMunicipality() : "");
    }

    private void updateMap(Airport airport) {
        if (airport.getLatitude() == null || airport.getLongitude() == null) return;

        WebEngine engine = mapView.getEngine();
        engine.load("https://www.windy.com/?" + airport.getLatitude() + "," + airport.getLongitude() + ",12");
    }

    private void clearFields() {
        getTypeField().clear();
        nameField.clear();
        elevationField.clear();
        countryField.clear();
        regionField.clear();
        municipalityField.clear();

        WebEngine engine = mapView.getEngine();
        engine.load(""); // clear map
    }

    public TextField getTypeField() {
        return typeField;
    }

    public void setTypeField(TextField typeField) {
        this.typeField = typeField;
    }
}
