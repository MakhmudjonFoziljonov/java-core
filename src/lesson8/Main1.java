package lesson8;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<User> queue = new LinkedList<>();
        System.out.println("Enter Your name: ");
        int id = 1;

        while (true) {
            System.out.println("\n=== Online Post Office ===");
            System.out.println("1. Add user");
            System.out.println("2. Operation delete user");
            System.out.println("3. Show queue");
            System.out.println("0. Exit");
            System.out.print("Choose operations: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter your name: ");
                    var name = scanner.nextLine();
                    var user = new User(id++, name);
                    queue.add(user);
                    System.out.println("Order number " + user.getId());
                }
                case 2 -> {
                    if (queue.isEmpty()) System.out.print("Queue is empty");
                    else {
                        var user = queue.poll();
                        System.out.println("User " + user + " removed from queue");
                    }
                }
                case 3 -> {
                    for (User user : queue) {
                        System.out.println(user);
                    }
                }
                case 0 -> scanner.close();
                default -> System.out.println("Buy ");
            }

        }

    }


    @Getter
    @Setter
    @RequiredArgsConstructor
    static class User {
        private final int id;
        private final String name;

        @Override
        public String toString() {
            return id + " — " + name;
        }
    }

}
