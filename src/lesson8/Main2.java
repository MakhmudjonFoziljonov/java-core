package lesson8;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers like (1 2 3 45 5): ");
        String numbers = scanner.nextLine();

        String[] strings = numbers.trim().split("\\s+");
        Set<Integer> set = new LinkedHashSet<>();

        for (String string : strings) {
                int n = Integer.parseInt(string);
                set.add(n);
        }
        System.out.println("Unique numbers: " + set);
    }
}
