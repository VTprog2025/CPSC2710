import java.time.LocalDate;

public class SeatReservation {

    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;

    public SeatReservation() {
        this.flightDesignator = null;
        this.flightDate = null;
        this.firstName = null;
        this.lastName = null;
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String fd) {
         if (fd == null){
        throw new IllegalArgumentException("flight designator cannot be null");
        }
        this.flightDesignator = fd;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate date) {
        this.flightDate = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    // toString() method
    @Override
    public String toString() {
        return "SeatReservation{" +
                "flightDesignator=" + (flightDesignator == null || flightDesignator.isEmpty() ? "null" : flightDesignator) +
                ",flightDate=" + (flightDate == null ? "null" : flightDate.toString()) +
                ",firstName=" + (firstName == null || firstName.isEmpty() ? "null" : firstName) +
                ",lastName=" + (lastName == null || lastName.isEmpty() ? "null" : lastName) +
                "}";
    }
}