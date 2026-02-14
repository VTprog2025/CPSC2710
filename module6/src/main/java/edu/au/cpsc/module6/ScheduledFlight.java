package edu.au.cpsc.module6;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

/*
 * Project: project4
 * Author: Christopher
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-01-31
 * Description: Represents a scheduled flight with departure/arrival info and days of operation.
 * Includes per-field validation to catch null inputs with descriptive messages.
 */
public class ScheduledFlight implements Serializable {

    private String flightDesignator;
    private String departureAirportIdent;
    private String arrivalAirportIdent;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;

    public ScheduledFlight(String flightDesignator,
                           String departureAirportIdent,
                           String arrivalAirportIdent,
                           LocalTime departureTime,
                           LocalTime arrivalTime,
                           HashSet<DayOfWeek> daysOfWeek) {

        // Use per-field validation method
        validateFields(flightDesignator, departureAirportIdent, arrivalAirportIdent,
                departureTime, arrivalTime, daysOfWeek);

        this.flightDesignator = flightDesignator;
        this.departureAirportIdent = departureAirportIdent;
        this.arrivalAirportIdent = arrivalAirportIdent;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.daysOfWeek = new HashSet<>(daysOfWeek);
    }

    private void validateFields(String flightDesignator,
                                String departureAirportIdent,
                                String arrivalAirportIdent,
                                LocalTime departureTime,
                                LocalTime arrivalTime,
                                HashSet<DayOfWeek> daysOfWeek) {

        StringBuilder errors = new StringBuilder();

        if (flightDesignator == null || flightDesignator.isBlank())
            errors.append("Flight Designator cannot be empty.\n");

        if (departureAirportIdent == null || departureAirportIdent.isBlank())
            errors.append("Departure Airport cannot be empty.\n");

        if (arrivalAirportIdent == null || arrivalAirportIdent.isBlank())
            errors.append("Arrival Airport cannot be empty.\n");

        if (departureTime == null)
            errors.append("Departure Time cannot be empty.\n");

        if (arrivalTime == null)
            errors.append("Arrival Time cannot be empty.\n");

        if (daysOfWeek == null || daysOfWeek.isEmpty())
            errors.append("At least one Day of Week must be selected.\n");

        if (!errors.isEmpty())
            throw new IllegalArgumentException(errors.toString().trim());
    }

    // Getters and setters
    public String getFlightDesignator() { return flightDesignator; }
    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null || flightDesignator.isBlank())
            throw new IllegalArgumentException("Flight Designator cannot be empty");
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() { return departureAirportIdent; }
    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null || departureAirportIdent.isBlank())
            throw new IllegalArgumentException("Departure Airport cannot be empty");
        this.departureAirportIdent = departureAirportIdent;
    }

    public String getArrivalAirportIdent() { return arrivalAirportIdent; }
    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null || arrivalAirportIdent.isBlank())
            throw new IllegalArgumentException("Arrival Airport cannot be empty");
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null)
            throw new IllegalArgumentException("Departure Time cannot be empty");
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null)
            throw new IllegalArgumentException("Arrival Time cannot be empty");
        this.arrivalTime = arrivalTime;
    }

    public HashSet<DayOfWeek> getDaysOfWeek() { return daysOfWeek; }
    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null || daysOfWeek.isEmpty())
            throw new IllegalArgumentException("At least one Day of Week must be selected");
        this.daysOfWeek = new HashSet<>(daysOfWeek);
    }

    // Returns a string like "MTWRF" for table display
    public String getDaysString() {
        StringBuilder sb = new StringBuilder();
        if (daysOfWeek.contains(DayOfWeek.MONDAY)) sb.append("M");
        if (daysOfWeek.contains(DayOfWeek.TUESDAY)) sb.append("T");
        if (daysOfWeek.contains(DayOfWeek.WEDNESDAY)) sb.append("W");
        if (daysOfWeek.contains(DayOfWeek.THURSDAY)) sb.append("R");
        if (daysOfWeek.contains(DayOfWeek.FRIDAY)) sb.append("F");
        if (daysOfWeek.contains(DayOfWeek.SATURDAY)) sb.append("S");
        if (daysOfWeek.contains(DayOfWeek.SUNDAY)) sb.append("U");
        return sb.toString();
    }
}