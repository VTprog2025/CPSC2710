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
 * Auburn Email: clb0214@auburn.edu
 * Date: 1-22-2026
 *
 * Description:
 * Airport domain model representing one row of the airport-codes CSV file.
 * Includes a static method to read all airports from the CSV in resources.
 */

public class Airport {

    // Instance variables (one per CSV column)
    private String ident;
    private String iataCode;
    private Integer elevationFt;
    private String continent;
    private String country;
    private String region;
    private String municipality;
    private Integer gpsCode;
    private Integer localCode;
    private Double latitude;
    private Double longitude;

    // Constructor
    public Airport(
            String ident,
            String iataCode,
            Integer elevationFt,
            String continent,
            String country,
            String region,
            String municipality,
            Integer gpsCode,
            Integer localCode,
            Double latitude,
            Double longitude
    ) {
        this.ident = ident;
        this.iataCode = iataCode;
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
    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
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

    // Static method required by assignment
    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        InputStream is = Airport.class
                .getClassLoader()
                .getResourceAsStream("airport-codes.csv");

        if (is == null) {
            throw new IOException("Could not find resource: airport-codes.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;

            // Skip header row
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 11) continue;

                String ident = data[0];
                String iataCode = data[1];
                Integer elevationFt = data[2].isEmpty() ? null : Integer.parseInt(data[2]);
                String continent = data[3];
                String country = data[4];
                String region = data[5];
                String municipality = data[6];
                Integer gpsCode = data[7].isEmpty() ? null : Integer.parseInt(data[7]);
                Integer localCode = data[8].isEmpty() ? null : Integer.parseInt(data[8]);
                Double latitude = data[9].isEmpty() ? null : Double.parseDouble(data[9]);
                Double longitude = data[10].isEmpty() ? null : Double.parseDouble(data[10]);

                airports.add(new Airport(
                        ident,
                        iataCode,
                        elevationFt,
                        continent,
                        country,
                        region,
                        municipality,
                        gpsCode,
                        localCode,
                        latitude,
                        longitude
                ));
            }
        }

        return airports;
    }
}
