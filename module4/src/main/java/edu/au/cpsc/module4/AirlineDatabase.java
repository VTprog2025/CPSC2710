package edu.au.cpsc.module4;
/*
* Airline Database portion of assignment.
 */

import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase {

    private final List<ScheduledFlight> scheduledFlights;

    public AirlineDatabase() {
        scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        scheduledFlights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        scheduledFlights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null");
        }
        scheduledFlights.remove(sf);
        scheduledFlights.add(sf);
    }
}
