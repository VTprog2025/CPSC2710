public class SeatReservation {

    /* Private instance variables*/
    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;

    // setter for flightDesignator and fullfills module1 part 2 assignment.
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