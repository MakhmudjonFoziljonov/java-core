package lesson7;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum BookingStatus {
    AVAILABLE("Свободно"),
    BOOKED("Забронировано"),
    PAID("Оплачено");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}