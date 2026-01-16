package edu.au.cpsc.module2_1;

import java.time.LocalDate;
/*
* Project: Module 2
* Author: Christopher Boartfield
* Email: clb0214@auburn.edu
* Date: 1-16-2026
* Description: Fight Reservation App
 */

public class SeatReservation {

    /* Private instance variables */
    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;
    private boolean flyingWithTravelInsurance;

    /* First Name */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() < 1 || firstName.length() > 15) {
            throw new IllegalArgumentException(
                    "First name must be between 1 and 15 characters");
        }
        return firstName;
    }

    /* Last Name */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() < 1 || lastName.length() > 15) {
            throw new IllegalArgumentException(
                    "Last name must be between 1 and 15 characters");
        }
        return lastName;
    }

    /* Flight Designator */
    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null ||
                flightDesignator.length() < 4 ||
                flightDesignator.length() > 6) {
            throw new IllegalArgumentException(
                    "Flight designator must be between 4 and 6 characters."
            );
        }
        this.flightDesignator = flightDesignator;
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    /* Number of Bags */
    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    /* Flying With Infant */
    public boolean isFlyingWithInfant() {
        return flyingWithInfant;
    }

    public void makeFlyingWithInfant() {
        flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        flyingWithInfant = false;
    }

    /* Flying With Travel Insurance */
    public boolean hasTravelInsurance() {
        return flyingWithTravelInsurance;
    }

    public void makeFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = true;
    }

    public void makeNotFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = false;
    }

    /* Flight Date */
    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }
}