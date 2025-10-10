package lesson7;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
public class Seat {
    private final String seatNumber;
    private final SeatClass seatClass;
    private Passenger passenger;
    private BookingStatus status;
    private LocalDateTime bookingTime;


    public boolean isBooked() {
        return passenger != null;
    }

    public void book(Passenger passenger) {
        if (this.status == BookingStatus.AVAILABLE) {
            this.passenger = passenger;
            this.status = BookingStatus.BOOKED;
            this.bookingTime = LocalDateTime.now();
        }
    }

    public void pay() {
        if (this.status == BookingStatus.BOOKED) {
            this.status = BookingStatus.PAID;
            this.bookingTime = null;
        }
    }

    public void releaseBooking() {
        this.passenger = null;
        this.status = BookingStatus.AVAILABLE;
        this.bookingTime = null;
    }

    public void cancelBooking() {
        this.passenger = null;
    }

    @Override
    public String toString() {
        char classChar = seatClass == SeatClass.BUSINESS ? 'Б' : 'Э';
        String statusString = switch (status) {
            case BOOKED -> "Бронь";
            case PAID -> "Оплачено";
            default -> "Свободно";
        };
        return String.format("[%s(%c): %s]", seatNumber, classChar, statusString);
    }
}