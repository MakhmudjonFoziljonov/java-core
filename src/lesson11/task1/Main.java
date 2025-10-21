package lesson11.task1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Enter anyone message bro, If you want to stop the program, type 'exit': ");
        String message = scanner.nextLine();

        while (true) {
            var messageService = new MessageService();

            var publisher = new Publisher(messageService, message);
            var subscriber = new Subscriber(messageService, message);

            executorService.execute(publisher);
            executorService.execute(subscriber);

            String turnOff = scanner.nextLine();
            if (turnOff.equals("exit")) {
                publisher.exit();
                subscriber.exit();
                executorService.shutdown();
                System.out.println("Program stopped. Goodbye!");
                break;
            }
        }
        System.exit(0);

    }
}
