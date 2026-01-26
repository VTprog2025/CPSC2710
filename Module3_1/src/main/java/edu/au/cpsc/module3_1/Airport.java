package edu.au.cpsc.module3_1;

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
 * Description: Represents an airport and provides a static method to read airports from a CSV file in resources.
 */

public class Airport {

    // Instance variables (use wrapper types for nullable numeric fields)
    Integer elevationFt;
    private String continent;
    String country;
    String region;
    String municipality;
    private Integer gpsCode;
    Integer localCode;
    Double latitude;
    Double longitude;

    public Airport(Integer elevationFt, String continent, String country, String region, String municipality, Integer gpsCode, Integer localCode, Double latitude, Double longitude) {
        this.elevationFt = elevationFt;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
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

    public Integer getLocalCode() {
        return localCode;
    }

    public void setLocalCode(Integer localCode) {
        this.localCode = localCode;
    }

    public Integer getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(Integer gpsCode) {
        this.gpsCode = gpsCode;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Reads all airports from the CSV file in resources and returns them as a List.
     * @return List of Airport objects
     * @throws IOException if the file cannot be read
     */
    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        // Load CSV from resources folder
        InputStream is = Airport.class.getClassLoader().getResourceAsStream("airport-codes.csv");
        if (is == null) {
            throw new IOException("Could not find resource: airport-codes.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;

            // Skip header row
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\"", ""); // Remove quotes
                String[] data = line.split(",", -1); // Keep empty fields

                if (data.length < 9) continue;

                // Parse fields, handle missing values
                Integer elevationFt = data[0].isEmpty() ? null : Integer.valueOf(data[0]);
                String continent    = data[1];
                String country      = data[2];
                String region       = data[3];
                String municipality = data[4];
                Integer gpsCode     = data[5].isEmpty() ? null : Integer.valueOf(data[5]);
                Integer localCode   = data[6].isEmpty() ? null : Integer.valueOf(data[6]);
                Double latitude     = data[7].isEmpty() ? null : Double.valueOf(data[7]);
                Double longitude    = data[8].isEmpty() ? null : Double.valueOf(data[8]);

                airports.add(new Airport(elevationFt, continent, country, region,
                        municipality, gpsCode, localCode, latitude, longitude));
            }
        }

        System.out.println("Loaded " + airports.size() + " airports"); // Simple logging
        return airports;
    }


}
