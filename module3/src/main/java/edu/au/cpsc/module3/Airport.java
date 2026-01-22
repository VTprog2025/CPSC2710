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

    Integer elevationFt;
    String continent;
    String country;
    String region;
    String municipality;
    int gpsCode;
    int localCode;
    double latitude;
    double longitude;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }
    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
    }
    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getMunicipality() {
        return municipality;
    }
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    public int getGpsCode() {
        return gpsCode;
    }
    public void setGpsCode(int gpsCode) {
        this.gpsCode = gpsCode;
    }
    public int getLocalCode() {
        return localCode;
    }
    public void setLocalCode(int localCode) {
        this.localCode = localCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
