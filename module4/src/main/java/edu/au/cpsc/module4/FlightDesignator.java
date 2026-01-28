package edu.au.cpsc.module4;
/*
 * Project: Module4 Assignment
 * Author: Christopher Boartfield
 * auburn email: clb0214@auburn.edu
 * Date: 1-27-2026
 * Description: Flight designator class
 */

import java.util.Objects;

public class FlightDesignator {
    private String departureAirportId;
    private String arrivalAirportId;
    private int departureTime;
    private int arrivalTime;
    private int daysOfWeek;

    public FlightDesignator(String departureAirportId, String arrivalAirportId, int departureTime,
                            int arrivalTime, int daysOfWeek) {
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.daysOfWeek = daysOfWeek;

    }

/* getters and setters
* @throws NullPointerException if value is 0 or null.
 */
    public String getArrivalAirportId() {
        if (arrivalAirportId == null) {
            throw new NullPointerException("ArrivalAirportId is null");
        }
        else {
            return arrivalAirportId;
        }
    }

    public void setArrivalAirportId(String arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getDepartureAirportId() {
        if (departureAirportId == null) {
            throw new NullPointerException("DepartureAirportId is null");
        }
        else {
            return departureAirportId;
        }
    }

    public void setDepartureAirportId(String departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public int getDepartureTime() {
        if  (departureTime == 0) {
            throw new NullPointerException("DepartureTime cannot be null");
        }
        else {
            return departureTime;
        }
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        if (arrivalTime == 0) {
            throw new NullPointerException("ArrivalTime cannot be null");
        }
        else {
            return arrivalTime;
        }
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FlightDesignator that = (FlightDesignator) o;
        return daysOfWeek == that.daysOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(daysOfWeek);
    }
}
