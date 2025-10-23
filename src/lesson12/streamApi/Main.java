package lesson12.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // task 1
        task1(List.of(1, 2, 3, 4, 5, 6));
        System.out.println("---------------- task 1");

        // task 2
        System.out.println(task2(List.of("apple", "banana", "pear", "pineapple")));
        System.out.println("---------------- task 2");

        // task 3
        task3(List.of(10, 2, 33, 4, 25));
        System.out.println("---------------- task 3");

        // task 4
        task4(List.of("Alice", "Bob", "Charlie", "David"));
        System.out.println("---------------- task 4");

        //task 5
        task5();
        System.out.println("---------------- task 5");

        // task6
        System.out.println(task6(List.of("apple", "banana", "kiwi")));
        System.out.println("---------------- task 6");

        // task7
        task7(List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine"));
        System.out.println("---------------- task 7");

        //task 8
        task8(List.of("Tom", "Jerry", "Spike"));
        System.out.println("---------------- task 8");

        //task 9
        task9(List.of("Java is cool", "Streams are powerful"));
        System.out.println("---------------- task 9");

        //task 10
        task10(List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),

            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0)));

        System.out.println("---------------- task 10");
    }


    private static void task1(List<Integer> list) {
        for (Integer i : list) {
            if (i % 2 == 0) {
                System.out.println(i * i);
            }
        }
        list.stream()
            .filter(i -> i % 2 == 0)
            .map(i -> i * i)
            .forEach(System.out::println);
    }

    private static int task2(List<String> list) {
        int counter = 0;
        for (String s : list) {
            if (s.length() > 5) {
                counter++;
            }
        }
//        return counter;
        counter = (int) list.stream()
            .filter(s -> s.length() > 5)
            .count();
        return counter;
    }

    private static void task3(List<Integer> list) {
        int max = 0, min = list.getFirst();
        for (Integer number : list) {
            if (max < number) max = number;
            if (min > number) min = number;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        int min1 = list.stream().min(Integer::compare).get();
        System.out.println("Min1: " + min1);
        int max1 = list.stream().max(Integer::compare).get();
        System.out.println("Max1: " + max1);
    }

    private static void task4(List<String> stringList) {
        double totalIndexLength = 0;
        int size = stringList.size();
        for (String string : stringList) {
            totalIndexLength += string.length();
        }
        System.out.println(totalIndexLength / size);

        var average = stringList.stream()
            .mapToInt(String::length)
            .average();
        System.out.println(average);
    }

    private static void task5() {
        List<String> stringList = new ArrayList<>(List.of("apple", "pear", "apple", "banana", "pear"));
        List<String> result = new ArrayList<>();
        for (String word : stringList) {
            if (!result.contains(word)) {
                result.add(word);
            }
        }
        int listSize = stringList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = i + 1; j < listSize; j++) {
                if (stringList.get(i).length() > stringList.get(j).length()) {
                    String temp = stringList.get(i);
                    stringList.set(i, stringList.get(j));
                    stringList.set(j, temp);
                }
            }
        }
        for (String s : result) {
            System.out.println(s);
        }

        stringList.stream()
            .sorted(Comparator.comparingInt(String::length))
            .distinct()
            .forEach(System.out::println);
    }

    public static Map<String, Integer> task6(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : list) {
            map.put(string, string.length());
        }
        return map;

//        return list.stream()
//            .collect(Collectors.toMap(string -> string, String::length));
    }

    public static void task7(List<String> list) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String str : list) {
            char letter = str.charAt(0);
            if (!map.containsKey(letter)) {
                map.put(letter, new ArrayList<>());
            }
            map.get(letter).add(str);
        }

        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        map = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        map.forEach((letter, value) -> System.out.println(value));
    }

    public static void task8(List<String> list) {
        List<String> stringList = list.subList(0, list.size());

        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i));
            if (i < stringList.size() - 1) {
                System.out.print(", ");
            }
        }
//        String collect = list.stream().collect(Collectors.joining(", "));
//        System.out.println(collect);
    }

    private static void task9(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
            for (String s : string.split(" ")) {
                System.out.println(List.of(s));
            }
        }
        list.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .forEach(s -> System.out.println(List.of(s)));
    }

    private static void task10(List<Product> products) {
        List<String> categories = new ArrayList<>();
        List<Double> prices = new ArrayList<>();
        for (Product product : products) {
            categories.add(product.category());
            prices.add(product.price());
        }
        for (int i = 0; i < categories.size() - 1; i++) {
            for (int j = i + 1; j < prices.size(); j++) {
                if (categories.get(i).equals(categories.get(j))) {
                    System.out.println("Categories: " + categories.get(i));
                    if (prices.get(i) > prices.get(j)) {
                        System.out.println(prices.get(i));
                    } else {
                        System.out.println(prices.get(j));
                    }
                }
            }
        }

        Map<String, Double> maxPricesByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::category,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingDouble(Product::price)),
                    opt -> opt.map(Product::price).orElse(0.0)
                )
            ));

        maxPricesByCategory.forEach((category, price) -> {
            System.out.println("Categories: " + category);
            System.out.println(price);
        });
    }
}

