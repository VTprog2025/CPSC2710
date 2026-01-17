package edu.au.cpsc.module2_1;

import java.time.LocalDate;
// * Project: Module 2
// * Author: Christopher Boartfield
// * Email: clb0214@auburn.edu
// * Date: 1-16-2026
// * Description: Fight Reservation App

public class SeatReservation {

    private String firstName = "";
    private String lastName = "";
    private String flightDesignator = "";
    private LocalDate flightDate = LocalDate.now();
    private int numberOfBags = 0;
    private boolean flyingWithInfant = false;
    private boolean flyingWithTravelInsurance = false;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (firstName.length() > 15) {
            throw new IllegalArgumentException("First name must be between 1 and 15 characters");
        }
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (lastName.length() > 15) {
            throw new IllegalArgumentException("Last name must be between 1 and 15 characters");
        }
        return lastName;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null || flightDesignator.length() < 4 || flightDesignator.length() > 6) {
            throw new IllegalArgumentException("Flight designator must be between 4 and 6 characters");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public boolean isFlyingWithInfant() {
        return flyingWithInfant;
    }

    public void makeFlyingWithInfant() {
        flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        flyingWithInfant = false;
    }

    public boolean hasTravelInsurance() {
        return flyingWithTravelInsurance;
    }

    public void makeFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = true;
    }

    public void makeNotFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = false;
    }

    @Override
    public String toString() {
        return "SeatReservation {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", flightDesignator='" + flightDesignator + '\'' +
                ", flightDate=" + flightDate +
                ", numberOfBags=" + numberOfBags +
                ", flyingWithInfant=" + flyingWithInfant +
                ", flyingWithTravelInsurance=" + flyingWithTravelInsurance +
                '}';
    }
}
