package edu.au.cpsc.module4;
/*
 * Project: Module4 Assignment
 * Author: Christopher Boartfield
 * auburn email: clb0214@auburn.edu
 * Date: 1-27-2026
 * Description: Flight designator class
 */

public class flightDesignator {
    String departureAirportIdent;
    String arrivalAirportIdent;
    int departureTime;
    int arrivalTime;
    int daysOfWeek;

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
}
