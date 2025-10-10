package lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Manager {
    private Map<String, Seat> seats;
    private static final String FILE_NAME = "booking_status.txt";

    public Manager() {
        this.seats = loadState();
        if (this.seats == null) {
            System.out.println("Файл с бронированиями не найден. Создается новая схема самолета.");
            this.seats = new LinkedHashMap<>();
            initializeSeats();
        } else {
            System.out.println("Данные о бронированиях успешно загружены.");
        }
    }

    private void initializeSeats() {
        for (int i = 1; i <= 2; i++) {
            for (char col : new char[]{'A', 'B', 'C', 'D'}) {
                String seatNumber = i + "" + col;
                seats.put(seatNumber, new Seat(seatNumber, SeatClass.BUSINESS));
            }
        }
        for (int row = 3; row <= 10; row++) {
            for (char col : new char[]{'A', 'B', 'C', 'D', 'E', 'F'}) {
                String seatNumber = row + "" + col;
                seats.put(seatNumber, new Seat(seatNumber, SeatClass.ECONOMY));
            }
        }
    }

    public void displayAllSeats() {

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

    public void bookSeat(String seatNumber, String fullName, SeatClass desiredClass) {
        Seat seat = seats.get(seatNumber.toUpperCase());
        if (seat == null) {
            System.out.println("Ошибка: Место " + seatNumber + " не существует.");
            return;
        }
        if (seat.getSeatClass() != desiredClass) {
            System.out.println("Ошибка: Место " + seatNumber + " относится к классу " + seat.getSeatClass() + ", а вы выбрали " + desiredClass);
            return;
        }
        if (seat.isBooked()) {
            System.out.println("Ошибка: Место " + seatNumber + " уже занято.");
            return;
        }
        seat.book(new Passenger(fullName));
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
        String passengerName = seat.getPassenger().getFullName();
        seat.cancelBooking();
        System.out.println("Бронь для места " + seatNumber + " (пассажир: " + passengerName + ") успешно отменена.");
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(this.seats);
            System.out.println("Статус бронирований сохранен в файл " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении состояния: " + e.getMessage());
        }
    }

    private Map<String, Seat> loadState() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Map<String, Seat>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке состояния: " + e.getMessage());
            return null;
        }
    }
}