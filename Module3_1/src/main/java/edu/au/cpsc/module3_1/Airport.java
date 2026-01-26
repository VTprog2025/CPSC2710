package edu.au.cpsc.module3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Project: Module 3 Assignment
 * Author: Christopher Boartfield
 * AU Email: clb0214@auburn.edu
 * Date: 1-22-2026
 * Description: Airport domain model loaded from CSV.
 */

public class Airport {

    private String ident;
    private String iataCode;
    private String localCode;
    private Integer elevationFt;
    private String continent;
    private String country;
    private String region;
    private String municipality;
    private Double latitude;
    private Double longitude;

    public Airport(String ident, String iataCode, String localCode,
                   Integer elevationFt, String continent, String country,
                   String region, String municipality,
                   Double latitude, Double longitude) {

        this.ident = ident;
        this.iataCode = iataCode;
        this.localCode = localCode;
        this.elevationFt = elevationFt;
        this.continent = continent;
        this.country = country;
        this.region = region;
        this.municipality = municipality;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // ---------- Getters ----------

    public String getIdent() {
        return ident;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    // ---------- CSV Loader ----------

    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        InputStream is = Airport.class
                .getClassLoader()
                .getResourceAsStream("airport-codes.csv");

        if (is == null) {
            throw new IOException("Could not find resource: airport-codes.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                String ident        = data[0];
                String iataCode     = data[1].isEmpty() ? null : data[1];
                String localCode    = data[2].isEmpty() ? null : data[2];
                Integer elevationFt = data[3].isEmpty() ? null : Integer.parseInt(data[3]);
                String continent    = data[4];
                String country      = data[5];
                String region       = data[6];
                String municipality = data[7];
                Double latitude     = data[8].isEmpty() ? null : Double.parseDouble(data[8]);
                Double longitude    = data[9].isEmpty() ? null : Double.parseDouble(data[9]);

                airports.add(new Airport(
                        ident, iataCode, localCode,
                        elevationFt, continent, country,
                        region, municipality,
                        latitude, longitude
                ));
            }
        }

        return airports;
    }
}
