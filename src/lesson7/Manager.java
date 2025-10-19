package lesson7;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private Map<String, Seat> seats;
    @Getter
    private LocalDateTime departureDate;
    private static final String FILE_NAME = "booking_status.txt";
    private static final long EXPIRATION_MINUTES = 24;

    public Manager() {
        loadState();
        System.out.println("Файл с бронированиями не найден. Создается новая схема самолета.");
        this.seats = new LinkedHashMap<>();
        this.departureDate = LocalDateTime.now()
            .plusDays(14);  // default
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 1; i <= 2; i++) {
            for (char col : new char[]{'A', 'B', 'C', 'D'}) {
                var seatNumber = i + "" + col;
                seats.put(seatNumber, new Seat(seatNumber, SeatClass.BUSINESS));
            }
        }
        for (int row = 3; row <= 10; row++) {
            for (char col : new char[]{'A', 'B', 'C', 'D', 'E', 'F'}) {
                var seatNumber = row + "" + col;
                seats.put(seatNumber, new Seat(seatNumber, SeatClass.ECONOMY));
            }
        }
    }

    public void displayAllSeats() {
        checkExpiredBookings();
        System.out.println("Б - Бизнес класс, Э - Эконом класс\n");

        System.out.println("Б(B) - Бизнес класс, Э(E) - Эконом класс\n");
        int rowCounter = 0;
        for (Seat seat : seats.values()) {
            System.out.print(seat + " ");
            rowCounter++;
            if (seat.getSeatNumber().contains("2D")) {
                System.out.println("\n---------------------------");
                rowCounter = 0;
            } else if (rowCounter == 6) {
                System.out.println();
                rowCounter = 0;
            }
        }
        System.out.println("\n----------------------------\n");
    }

    private void checkExpiredBookings() {
        var now = LocalDateTime.now();
        List<String> expiredSeats = new ArrayList<>();
        for (Seat seat : seats.values()) {
            if (seat.getStatus() == BookingStatus.BOOKED && seat.getBookingTime() != null) {
                long minutesPassed =
                    Duration.between(seat.getBookingTime(), now).toMinutes();
                /* If we do not use the Duration class, we need to parse the String,
                   split it into hours (HH) and minutes (mm),
                   multiply the hours (HH) by 60 to convert them to minutes,
                   and then find the difference between the times.*/
                if (minutesPassed > EXPIRATION_MINUTES) {
                    expiredSeats.add(seat.getSeatNumber());
                    seat.releaseBooking();
                }
            }
        }
        if (!expiredSeats.isEmpty()) {
            System.out.println("\nВНИМАНИЕ: Следующие брони истекли по времени и были отменены: "
                + String.join(", ", expiredSeats));
        }
    }


    public void bookSeat(String seatNumber, String fullName, SeatClass desiredClass) {
        Seat seat = seats.get(seatNumber.toUpperCase());
        if (seat == null) {
            System.out.println("Ошибка: Место " + seatNumber + " не существует.");
            return;
        }
        if (seat.getSeatClass() != desiredClass) {
            System.out.println("Ошибка: Место " + seatNumber + " относится к классу " + seat.getSeatClass() +
                ", а вы выбрали " + desiredClass);
            return;
        }
        if (seat.isBooked()) {
            System.out.println("Ошибка: Место " + seatNumber + " уже занято.");
            return;
        }
        if (seat.getStatus() != BookingStatus.AVAILABLE) {
            System.out.println("Ошибка: Место " + seatNumber + " уже " + seat.getStatus().toString().toLowerCase() + ".");
        }
        seat.book(new Passenger(fullName));
        System.out.println("Место " + seatNumber + " успешно забронировано на имя " + fullName + ".");
        System.out.println("Бронь необходимо оплатить в течение " + EXPIRATION_MINUTES + " минут.");
        System.out.println("Место " + seatNumber + " успешно забронировано на имя " + fullName + ".");
    }

    public void cancelBooking(String seatNumber) {
        Seat seat = seats.get(seatNumber.toUpperCase());
        if (seat == null) {
            System.out.println("Ошибка: Место " + seatNumber + " не существует.");
            return;
        }
        if (!seat.isBooked()) {
            System.out.println("Ошибка: Место " + seatNumber + " и так свободно.");
            return;
        }
        if (seat.getStatus() != BookingStatus.BOOKED) {
            System.out.println("Ошибка: Место " + seatNumber + " не забронировано. Его нельзя отменить.");
        }
        String passengerName = seat.getPassenger().getFullName();
        seat.releaseBooking();
        System.out.println("Бронь для места " + seatNumber + " (пассажир: " + passengerName + ") успешно отменена.");
    }

    public boolean payForSeat(String seatNumber) {
        Seat seat = seats.get(seatNumber.toUpperCase());
        if (seat.getStatus() == BookingStatus.PAID) {
            System.out.println("Ошибка: Место " + seatNumber + " уже оплачено.");
            return false;
        }
        if (seat.getStatus() != BookingStatus.BOOKED) {
            System.out.println("Ошибка: Место " + seatNumber + " не забронировано. Сначала забронируйте его.");
            return false;
        }
        seat.pay();
        System.out.println("Место " + seatNumber + " успешно оплачено пассажиром " + seat.getPassenger().getFullName());
        return true;
    }

    public void showBookingInfo(String seatNumber) {
        Seat seat = seats.get(seatNumber.toUpperCase());
        if (seat == null) {
            System.out.println("Ошибка: Место " + seatNumber + " не существует.");
            return;
        }
        if (seat.isBooked()) {
            System.out.println("--- Информация о бронировании места " + seatNumber + " ---");
            System.out.println("Класс: " + seat.getSeatClass());
            System.out.println(seat.getPassenger());
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Место " + seatNumber + " свободно.");
        }
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("DEPARTURE_DATE," + departureDate.toString());
            writer.newLine();


            for (Seat seat : seats.values()) {
                String passengerName = seat.getPassenger() != null ? seat.getPassenger().getFullName() : "null";
                String bookingTimeStr = seat.getBookingTime() != null ? seat.getBookingTime().toString() : "null";
                String line = String.join(";",
                    seat.getSeatNumber(),
                    seat.getSeatClass().name(),
                    seat.getStatus().name(),
                    passengerName,
                    bookingTimeStr
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Статус бронирований сохранен в файл " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении состояния: " + e.getMessage());
        }
    }

    private boolean loadState() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return false;

        this.seats = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String departureLine = reader.readLine();
            if (departureLine != null && departureLine.startsWith("DEPARTURE_DATE,")) {
                this.departureDate = LocalDateTime.parse(departureLine.substring(17));
            } else {
                this.departureDate = LocalDateTime.now().plusDays(30);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                String seatNumber = parts[0];
                SeatClass seatClass = SeatClass.valueOf(parts[1]);
                BookingStatus status = BookingStatus.valueOf(parts[2]);
                String passengerName = parts[3];
                String bookingTimeStr = parts[4];

                Seat seat = new Seat(seatNumber, seatClass);
                if (!passengerName.equals("null")) {
                    seat.book(new Passenger(passengerName));
                    seat.pay();

                    if (status == BookingStatus.BOOKED) {
                        seat.book(new Passenger(passengerName));
                    } else if (status == BookingStatus.PAID) {
                        seat.pay();
                    } else {
                        seat.releaseBooking();
                    }
                }
                if (!bookingTimeStr.equals("null")) {
                    seat.setBookingTime(LocalDateTime.parse(bookingTimeStr));
                }

                seats.put(seatNumber, seat);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке состояния: " + e.getMessage());
            return false;
        }
        return true;
    }
}
