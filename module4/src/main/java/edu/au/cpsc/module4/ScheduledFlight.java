package edu.au.cpsc.module4;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledFlight {

    private String flightDesignator;
    private String departureAirportId;
    private String arrivalAirportId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;

    public ScheduledFlight(String flightDesignator,
                           String departureAirportId,
                           String arrivalAirportId,
                           LocalTime departureTime,
                           LocalTime arrivalTime,
                           HashSet<DayOfWeek> daysOfWeek) {
        setFlightDesignator(flightDesignator);
        setDepartureAirportId(departureAirportId);
        setArrivalAirportId(arrivalAirportId);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        setDaysOfWeek(daysOfWeek);
    }

    public String getFlightDesignator() { return flightDesignator; }
    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) throw new IllegalArgumentException("flightDesignator cannot be null");
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportId() { return departureAirportId; }
    public void setDepartureAirportId(String departureAirportId) {
        if (departureAirportId == null) throw new IllegalArgumentException("departureAirportId cannot be null");
        this.departureAirportId = departureAirportId;
    }

    public String getArrivalAirportId() { return arrivalAirportId; }
    public void setArrivalAirportId(String arrivalAirportId) {
        if (arrivalAirportId == null) throw new IllegalArgumentException("arrivalAirportId cannot be null");
        this.arrivalAirportId = arrivalAirportId;
    }

    public LocalTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) throw new IllegalArgumentException("departureTime cannot be null");
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) throw new IllegalArgumentException("arrivalTime cannot be null");
        this.arrivalTime = arrivalTime;
    }

    public HashSet<DayOfWeek> getDaysOfWeek() { return daysOfWeek; }
    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) throw new IllegalArgumentException("daysOfWeek cannot be null");
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
}
