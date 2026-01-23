package edu.au.cpsc.module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Project: Module3 Assignment
 * Author: Christopher Boartfield
 * AU_Email: clb0214@auburn.edu
 * Date: 1-22-2026
 * Making an Airport class that can help run Airport Application.
 */

public class Airport {

    // Instance variables (keeping Integer for nullable numeric fields)
    Integer elevationFt;
    String continent;
    String country;
    String region;
    String municipality;
    Integer gpsCode;
    Integer localCode;
    Double latitude;
    Double longitude;

    // Constructor
    public Airport(Integer elevationFt, String continent, String country,
                   String region, String municipality, Integer gpsCode,
                   Integer localCode, Double latitude, Double longitude) {
        this.elevationFt = elevationFt;
        this.continent = continent;
        this.country = country;
        this.region = region;
        this.municipality = municipality;
        this.gpsCode = gpsCode;
        this.localCode = localCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // Getters and setters
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Integer getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(Integer gpsCode) {
        this.gpsCode = gpsCode;
    }

    public Integer getLocalCode() {
        return localCode;
    }

    public void setLocalCode(Integer localCode) {
        this.localCode = localCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    // Static method to read all airports from CSV in resources
    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        // Load CSV from resources folder
        InputStream is = Airport.class
                .getClassLoader()
                .getResourceAsStream("airports.csv"); // make sure this file is in src/main/resources

        if (is == null) {
            throw new IOException("Could not find resource: airports.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;

            // Skip header row if CSV has one
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 9) continue; // basic validation

                // Handle nullable numeric fields
                Integer elevationFt = data[0].isEmpty() ? null : Integer.parseInt(data[0]);
                String continent    = data[1];
                String country      = data[2];
                String region       = data[3];
                String municipality = data[4];
                Integer gpsCode     = data[5].isEmpty() ? null : Integer.parseInt(data[5]);
                Integer localCode   = data[6].isEmpty() ? null : Integer.parseInt(data[6]);
                Double latitude     = data[7].isEmpty() ? null : Double.parseDouble(data[7]);
                Double longitude    = data[8].isEmpty() ? null : Double.parseDouble(data[8]);

                airports.add(new Airport(elevationFt, continent, country, region, municipality,
                        gpsCode, localCode, latitude, longitude));
            }
        }

        return airports;
    }
}

