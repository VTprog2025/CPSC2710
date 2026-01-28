package edu.au.cpsc.module4;
/*
 * Project: Module4 Assignment
 * Author: Christopher Boartfield
 * auburn email: clb0214@auburn.edu
 * Date: 1-27-2026
 * Description: Flight designator class
 */

public class FlightDesignator {
    private String departureAirportIdent;
    private String arrivalAirportIdent;
    private int departureTime;
    private int arrivalTime;
    private int daysOfWeek;

    public FlightDesignator(departureAirportIdent, arrivalAirportIdent, departureTime, arrivalTime, daysOfWeek) {
        this.departureAirportIdent = departureAirportIdent;
        this.arrivalAirportIdent = arrivalAirportIdent;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.daysOfWeek = daysOfWeek;

    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }
    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        this.arrivalAirportIdent = arrivalAirportIdent;
        if (arrivalAirportIdent == null){
            throw new NullPointerException();
        }
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }
    public void setDepartureAirportIdent(String departureAirportIdent) {
        this.departureAirportIdent = departureAirportIdent;
        if (departureAirportIdent == null) {
            throw new NullPointerException();
        }
    }
    public int getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
        if  (departureTime < 0) {
            throw new NullPointerException();
        }
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        if (arrivalTime < 0) {
            throw new NullPointerException();
        }
    }
    public void setDaysOfWeek(int daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
        if (daysOfWeek < 0) throw new NullPointerException();
    }
}
