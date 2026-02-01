package edu.au.cpsc.module4;

import java.io.Serial;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

/*
 * Project: Project 4
 * Author: Christopher Boartfield
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-01-31
 * Description: This class represents a scheduled flight with a flight designator,
 * departure and arrival airport identifiers, scheduled times, and the days of the week
 * it operates. Includes validation for all fields.
 */
public class ScheduledFlight implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String flightDesignator;
    private String departureAirportIdent;
    private String arrivalAirportIdent;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;

    // Constructor
    public ScheduledFlight(String flightDesignator,
                           String departureAirportIdent,
                           String arrivalAirportIdent,
                           LocalTime departureTime,
                           LocalTime arrivalTime,
                           HashSet<DayOfWeek> daysOfWeek) {
        setFlightDesignator(flightDesignator);
        setDepartureAirportIdent(departureAirportIdent);
        setArrivalAirportIdent(arrivalAirportIdent);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        setDaysOfWeek(daysOfWeek);
    }

    // Getters and setters with validation
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null)
            throw new IllegalArgumentException("flightDesignator cannot be null");
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null)
            throw new IllegalArgumentException("departureAirportIdent cannot be null");
        this.departureAirportIdent = departureAirportIdent;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null)
            throw new IllegalArgumentException("arrivalAirportIdent cannot be null");
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null)
            throw new IllegalArgumentException("departureTime cannot be null");
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null)
            throw new IllegalArgumentException("arrivalTime cannot be null");
        this.arrivalTime = arrivalTime;
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        return new HashSet<>(daysOfWeek); // return a copy for safety
    }

    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null)
            throw new IllegalArgumentException("daysOfWeek cannot be null");
        this.daysOfWeek = new HashSet<>(daysOfWeek);
    }

    // Returns a string like "MTWRF" for the table display
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

    @Override
    public String toString() {
        return flightDesignator + " " + departureAirportIdent + "->" + arrivalAirportIdent +
                " " + departureTime + "-" + arrivalTime + " " + getDaysString();
    }
}
