package edu.au.cpsc.module6;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Project: Project 6
 * Author: Christopher Boartfield
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-01-31
 * Description: This class represents the database of scheduled flights.
 * It provides methods to add, remove, update, and retrieve scheduled flights.
 */
public class AirlineDatabase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final List<ScheduledFlight> scheduledFlights;

    // Constructor
    public AirlineDatabase() {
        scheduledFlights = new ArrayList<>();
    }

    // Returns a copy of the scheduled flights list for safety
    public List<ScheduledFlight> getScheduledFlights() {
        return new ArrayList<>(scheduledFlights);
    }

    // Add a scheduled flight to the database
    public void addScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        scheduledFlights.add(sf);
    }

    // Remove a scheduled flight from the database
    public void removeScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        scheduledFlights.remove(sf);
    }

    // Update a scheduled flight in the database
    public void updateScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        // Remove the old instance and add the updated one
        scheduledFlights.remove(sf);
        scheduledFlights.add(sf);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ScheduledFlight sf : scheduledFlights) {
            sb.append(sf).append("\n");
        }
        return sb.toString();
    }
}