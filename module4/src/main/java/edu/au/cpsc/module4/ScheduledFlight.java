package edu.au.cpsc.module4;
/*
 * Project: Module4 Assignment
 * Author: Christopher Boartfield
 * auburn email: clb0214@auburn.edu
 * Date: 1-27-2026
 * Description: Flight designator class
 */

import java.time.LocalTime;
import java.util.Objects;

public class ScheduledFlight {
    private String departureAirportId;
    private String arrivalAirportId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalTime daysOfWeek;

    public void FlightDesignator(String departureAirportId, String arrivalAirportId, LocalTime departureTime,
                                 LocalTime arrivalTime, LocalTime daysOfWeek) {
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

    public LocalTime getDepartureTime() {
        if  (false) {
            throw new NullPointerException("DepartureTime cannot be null");
        }
        else {
            return departureTime;
        }
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        if (false) {
            throw new NullPointerException("ArrivalTime cannot be null");
        }
        else {
            return arrivalTime;
        }
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return daysOfWeek == that.daysOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(daysOfWeek);
    }
}
