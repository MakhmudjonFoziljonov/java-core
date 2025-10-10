package lesson6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Меню системы бронирования авиабилетов =====");
            System.out.println("1. Показать все места");
            System.out.println("2. Забронировать место");
            System.out.println("3. Снять бронь");
            System.out.println("4. Показать информацию о брони по номеру места");
            System.out.println("0. Выход");
            System.out.print("Выберите номер: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.displayAllSeats();
                    break;
                case "2":
                    System.out.print("Введите номер места: ");
                    String seatToBook = scanner.nextLine();
                    System.out.print("Введите ФИО: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Выберите класс: ");
                    String classChoice = scanner.nextLine();
                    SeatClass sClass = classChoice.equals("1") ? SeatClass.BUSINESS : SeatClass.ECONOMY;
                    manager.bookSeat(seatToBook, fullName, sClass);
                    break;
                case "3":
                    System.out.print("Введите номер места для снятия брони: ");
                    String seatToCancel = scanner.nextLine();
                    manager.cancelBooking(seatToCancel);
                    break;
                case "4":
                    System.out.print("Введите номер места для просмотра информации: ");
                    String seatToShow = scanner.nextLine();
                    manager.showBookingInfo(seatToShow);
                    break;
                case "0":
                    manager.saveState();
                    running = false;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверная опция. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
        scanner.close();
    }
}
