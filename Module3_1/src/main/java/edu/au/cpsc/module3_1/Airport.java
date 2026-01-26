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
 * Date: 1-25-2026
 * Description: Represents an airport and provides a static method to read airports from a CSV file in resources.
 */

public class Airport {

    private String ident;
    private String type;
    private String name;
    private String elevationFt;  // keep as String because it may be missing or alphanumeric
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

    // Constructor
    public Airport(String ident, String type, String name, String elevationFt, String continent,
                   String country, String region, String municipality,
                   String gpsCode, String iataCode, String localCode,
                   Double latitude, Double longitude, String coordinates) {
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


    public String getIdent() { return ident; }
    public void setIdent(String ident) { this.ident = ident; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getElevationFt() { return elevationFt; }
    public void setElevationFt(String elevationFt) { this.elevationFt = elevationFt; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getMunicipality() { return municipality; }
    public void setMunicipality(String municipality) { this.municipality = municipality; }

    public String getGpsCode() { return gpsCode; }
    public void setGpsCode(String gpsCode) { this.gpsCode = gpsCode; }

    public String getIataCode() { return iataCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }

    public String getLocalCode() { return localCode; }
    public void setLocalCode(String localCode) { this.localCode = localCode; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getCoordinates() { return coordinates; }
    public void setCoordinates(String coordinates) { this.coordinates = coordinates; }


    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        InputStream is = Airport.class.getClassLoader().getResourceAsStream("airport-codes.csv");
        if (is == null) {
            throw new IOException("Could not find resource: airport-codes.csv");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\"", ""); // remove quotes
                String[] data = line.split(",", -1); // keep empty fields
                if (data.length < 14) continue; // skip invalid rows

                String ident = data[0].isEmpty() ? null : data[0];
                String type = data[1].isEmpty() ? null : data[1];
                String name = data[2].isEmpty() ? null : data[2];
                String elevationFt = data[3].isEmpty() ? null : data[3];
                String continent = data[4].isEmpty() ? null : data[4];
                String country = data[5].isEmpty() ? null : data[5];
                String region = data[6].isEmpty() ? null : data[6];
                String municipality = data[7].isEmpty() ? null : data[7];
                String gpsCode = data[8].isEmpty() ? null : data[8];
                String iataCode = data[9].isEmpty() ? null : data[9];
                String localCode = data[10].isEmpty() ? null : data[10];
                Double latitude = data[11].isEmpty() ? null : Double.valueOf(data[11]);
                Double longitude = data[12].isEmpty() ? null : Double.valueOf(data[12]);
                String coordinates = data[13].isEmpty() ? null : data[13];

                airports.add(new Airport(ident, type, name, elevationFt, continent,
                        country, region, municipality, gpsCode, iataCode, localCode,
                        latitude, longitude, coordinates));
            }
        }

        System.out.println("Loaded " + airports.size() + " airports");
        return airports;
    }
}
