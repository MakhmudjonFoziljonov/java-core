package lesson6;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Seat {
    private final String seatNumber;
    private final SeatClass seatClass;
    private Passenger passenger;


    public boolean isBooked() {
        return passenger != null;
    }

    public void book(Passenger passenger) {
        if (!isBooked()) {
            this.passenger = passenger;
        }
    }

    public void cancelBooking() {
        this.passenger = null;
    }

    @Override
    public String toString() {
        String status = isBooked() ? "Booked" : "Free";
        char classChar = seatClass == SeatClass.BUSINESS ? 'B' : 'E';
        return String.format("[%s(%c): %s]", seatNumber, classChar, status);
    }
}