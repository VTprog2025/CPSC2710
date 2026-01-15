/*
* Project: module2
* Author: Christopher Boartfield
* Email: clb0214@auburn.edu
* Date: 1/18/2026
* Description: Flight Designation App
 */

package com.example.module2;
import java.time.LocalDate;

public class SeatReservation {

    /* Private instance variables*/
    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() < 2 || firstName.length() > 15) {
            throw new IllegalArgumentException("First name must be between 2 and 15 characters.");
        }
        this.firstName = firstName;
    }
    public void setlastName(String lastName) {
        if (lastName == null || lastName.length() < 2 || lastName.length() > 15) {
            throw new IllegalArgumentException("Last name must be between 2 and 15 characters.");
        }
        this.lastName = lastName;
    }
public int setNumberOfBags(int numberOfBags) {
        if (numberOfBags < 0 || numberOfBags > 100) {
            throw new IllegalArgumentException("Number of bags must be between 0 and 100.");
        }
        return this.numberOfBags = numberOfBags;
}
    public int getNumberOfBags() {
        return numberOfBags;
    }

    // getter
    public boolean isFlyingWithInfant() {
        return flyingWithInfant;
    }

    // setter-ish methods
    public void makeFlyingWithInfant() {
        this.flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        this.flyingWithInfant = false;
    }

    // setter for flightDesignator and fulfills module1 part 2 assignment.
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

    /*
     * Module1 assignment.
     */
}
