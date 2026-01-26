package edu.au.cpsc.module3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Project: Module3 Assignment
 * Author: Christopher Boartfield
 * AU_Email: clb0214@auburn.edu
 * Date: 1-25-2026
 * Description: Represents an airport and provides a static method to read airports from a CSV file in resources.
 */

public class Airport {

    private String ident;
    private String type;
    private String name;
    private String elevationFt;   // kept as String to handle non-numeric entries
    private String continent;
    private String country;
    private String region;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private Double latitude;
    private Double longitude;
    private String coordinates;

    public Airport(String ident, String type, String name, String elevationFt, String continent,
                   String country, String region, String municipality, String gpsCode,
                   String iataCode, String localCode, Double latitude, Double longitude, String coordinates) {
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.elevationFt = elevationFt;
        this.continent = continent;
        this.country = country;
        this.region = region;
        this.municipality = municipality;
        this.gpsCode = gpsCode;
        this.iataCode = iataCode;
        this.localCode = localCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.coordinates = coordinates;
    }

    // Getters
    public String getIdent() { return ident; }
    public String getType() { return type; }
    public String getName() { return name; }
    public String getElevationFt() { return elevationFt; }
    public String getContinent() { return continent; }
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getMunicipality() { return municipality; }
    public String getGpsCode() { return gpsCode; }
    public String getIataCode() { return iataCode; }
    public String getLocalCode() { return localCode; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getCoordinates() { return coordinates; }

    // Setters
    public void setIdent(String ident) { this.ident = ident; }
    public void setType(String type) { this.type = type; }
    public void setName(String name) { this.name = name; }
    public void setElevationFt(String elevationFt) { this.elevationFt = elevationFt; }
    public void setContinent(String continent) { this.continent = continent; }
    public void setCountry(String country) { this.country = country; }
    public void setRegion(String region) { this.region = region; }
    public void setMunicipality(String municipality) { this.municipality = municipality; }
    public void setGpsCode(String gpsCode) { this.gpsCode = gpsCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }
    public void setLocalCode(String localCode) { this.localCode = localCode; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setCoordinates(String coordinates) { this.coordinates = coordinates; }

    /**
     * Reads all airports from the CSV file in resources and returns them as a List.
     * @return List of Airport objects
     * @throws IOException if the file cannot be read
     */
    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        // Load CSV from resources folder
        java.net.URL resourceUrl = Airport.class.getClassLoader().getResource("airport-codes.csv");
        if (resourceUrl == null) {
            throw new IOException("Could not find resource: airport-codes.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream()))) {
            String line;
            int lineNumber = 0;

            // Skip header row
            reader.readLine();
            lineNumber++;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.replaceAll("\"", ""); // Remove quotes
                String[] data = line.split(",", -1); // Keep empty fields

                if (data.length < 12) continue; // skip incomplete lines

                // Parse fields safely
                String ident        = data.length > 0 ? data[0] : null;
                String type         = data.length > 1 ? data[1] : null;
                String name         = data.length > 2 ? data[2] : null;
                String elevationFt  = data.length > 3 ? data[3] : null;
                String continent    = data.length > 4 ? data[4] : null;
                String country      = data.length > 5 ? data[5] : null;
                String region       = data.length > 6 ? data[6] : null;
                String municipality = data.length > 7 ? data[7] : null;
                String gpsCode      = data.length > 8 ? data[8] : null;
                String iataCode     = data.length > 9 ? data[9] : null;
                String localCode    = data.length > 10 ? data[10] : null;

                Double latitude = null;
                Double longitude = null;
                if (data.length > 11 && !data[11].isEmpty()) {
                    try { latitude = Double.valueOf(data[11]); }
                    catch (NumberFormatException e) { /* ignore invalid latitude */ }
                }
                if (data.length > 12 && !data[12].isEmpty()) {
                    try { longitude = Double.valueOf(data[12]); }
                    catch (NumberFormatException e) { /* ignore invalid longitude */ }
                }

                String coordinates = data.length > 13 ? data[13] : null;

                airports.add(new Airport(
                        ident, type, name, elevationFt, continent, country, region,
                        municipality, gpsCode, iataCode, localCode, latitude, longitude, coordinates
                ));
            }
        }

        System.out.println("Loaded " + airports.size() + " airports successfully!");
        return airports;
    }
}
