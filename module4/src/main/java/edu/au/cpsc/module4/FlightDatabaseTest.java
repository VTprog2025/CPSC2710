package edu.au.cpsc.module4;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

public class FlightDatabaseTest {

    static void main(String[] ignoredArgs) {
        // Create database
        AirlineDatabase db = new AirlineDatabase();

        // Create first flight
        HashSet<DayOfWeek> days1 = new HashSet<>();
        days1.add(DayOfWeek.MONDAY);
        days1.add(DayOfWeek.WEDNESDAY);
        days1.add(DayOfWeek.FRIDAY);

        ScheduledFlight flight1 = new ScheduledFlight(
                "AU101",
                "ATL",
                "LAX",
                LocalTime.of(9, 30),
                LocalTime.of(12, 45),
                days1
        );

        // Create second flight
        HashSet<DayOfWeek> days2 = new HashSet<>();
        days2.add(DayOfWeek.TUESDAY);
        days2.add(DayOfWeek.THURSDAY);
        days2.add(DayOfWeek.SUNDAY);

        ScheduledFlight flight2 = new ScheduledFlight(
                "AU202",
                "LAX",
                "ORD",
                LocalTime.of(14, 15),
                LocalTime.of(18, 0),
                days2
        );

        // Add flights
        db.addScheduledFlight(flight1);
        db.addScheduledFlight(flight2);

        // Print database contents
        System.out.println("Flights in database:");
        for (ScheduledFlight f : db.getScheduledFlights()) {
            System.out.println(f.getFlightDesignator() + " | " +
                    f.getDepartureAirportIdent() + " -> " +
                    f.getArrivalAirportIdent() + " | Dep: " +
                    f.getDepartureTime() + " | Arr: " +
                    f.getArrivalTime() + " | Days: " +
                    f.getDaysString());
        }

        // Update a flight
        flight1.setArrivalAirportIdent("SFO"); // updated getter/setter name
        db.updateScheduledFlight(flight1);

        // Remove a flight
        db.removeScheduledFlight(flight2);

        // Print final database
        System.out.println("\nAfter update and removal:");
        for (ScheduledFlight f : db.getScheduledFlights()) {
            System.out.println(f.getFlightDesignator() + " | " +
                    f.getDepartureAirportIdent() + " -> " +
                    f.getArrivalAirportIdent() + " | Dep: " +
                    f.getDepartureTime() + " | Arr: " +
                    f.getArrivalTime() + " | Days: " +
                    f.getDaysString());
        }
    }
}

