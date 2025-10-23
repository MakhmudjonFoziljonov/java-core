package lesson12.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        //task 1
        Predicate<String> stringPredicate = task1();
        System.out.println(stringPredicate.test("Mahmudjon"));
        System.out.println(stringPredicate.test(""));
        System.out.println(stringPredicate.test("123"));
        System.out.println("----------------------");

        //task 2
        Function<String, Integer> stringIntegerFunction = task2();
        System.out.println(stringIntegerFunction.apply("String"));
        System.out.println(stringIntegerFunction.apply("MakhmudjonFoziljonov"));
        System.out.println("----------------------");

        //task 3
        Supplier<UUID> uuidSupplier = task3();
        System.out.println(uuidSupplier.get());
        System.out.println("----------------------");

        //task 4
        Consumer<String> consumer = task4();
        consumer.accept("abcd");
        System.out.println("----------------------");


        //task 5
        BiFunction<Integer, Integer, Integer> integerIntegerIntegerBiFunction = task5();
        System.out.println(integerIntegerIntegerBiFunction.apply(7, 10));
        System.out.println(integerIntegerIntegerBiFunction.apply(-122, 210));
        System.out.println("----------------------");

        //task 6
        Function<String, String> stringStringFunction = task6();
        System.out.println(stringStringFunction.apply("     drerfferfw "));
        System.out.println("----------------------");

        // task 7
        Consumer<String> consumer1 = task7();
        consumer1.accept("Consumer Task 7");
        System.out.println("----------------------");


        // task 8
        Predicate<Integer> integerPredicate = task8();
        System.out.println(integerPredicate.test(-3));
        System.out.println("----------------------");

        // task9
        BiFunction<Integer, Integer, String> integerIntegerStringBiFunction = task9();
        System.out.println(integerIntegerStringBiFunction.apply(4, 4));
        System.out.println("----------------------");

        //task 10
        UnaryOperator<String> stringUnaryOperator = task10();
        System.out.println(stringUnaryOperator.apply("wqeewwew"));
        System.out.println("----------------------");

        //task 11
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> predicate = n -> n % 2 == 0;

        List<String> list2 = List.of("Math", "python", "Go", "java");
        Predicate<String> predicate2 = s -> s.length() <= 2;
        System.out.println(task11(list, predicate));
        System.out.println(task11(list2, predicate2));
        System.out.println("----------------------");

        //task 12
        List<String> stringList = List.of("Math", "python", "Go", "java");
        System.out.println(task12(stringList, String::length));
        System.out.println("----------------------");

        //task 13
        List<String> strtList = List.of("Math", "python", "Go", "java");
        task13(strtList, System.out::println);
        System.out.println("----------------------");


        //task 14
        System.out.println(task14(() -> 5, 2));
        System.out.println(task14(() -> 12, 5));
        System.out.println("----------------------");

    }

    public static Predicate<String> task1() {
        return s -> s != null && s.length() > 3;
    }

    public static Function<String, Integer> task2() {
        return String::length;
    }

    public static Supplier<UUID> task3() {
        return UUID::randomUUID;
    }

    public static Consumer<String> task4() {
        return s -> System.out.println(s.toUpperCase());
    }

    public static BiFunction<Integer, Integer, Integer> task5() {
        return (r1, r2) -> r1 + r2;
    }

    public static Function<String, String> task6() {
        return s -> s.trim().toUpperCase();
    }

    public static Consumer<String> task7() {
        Consumer<String> st = System.out::println;
        Consumer<String> consumer = s -> System.out.println(s.length());
        return st.andThen(consumer);
    }

    public static Predicate<Integer> task8() {
        Predicate<Integer> isPositive = s -> s < 0;
        return isPositive.and(s -> s % 2 != 0);
    }

    public static BiFunction<Integer, Integer, String> task9() {
        BiFunction<Integer, Integer, Integer> multiply = (r1, r2) -> r1 * r2;
        return multiply.andThen(x -> "Result: " + x);

    }

    public static UnaryOperator<String> task10() {
        return t -> t + "!!!";
    }

    public static <T> List<T> task11(List<T> list, Predicate<T> predicate) {
        List<T> numbersOrChars = new ArrayList<>();
        for (T numOrChar : list) {
            boolean test = predicate.test(numOrChar);
            if (test) {
                numbersOrChars.add(numOrChar);
            }
        }
        return numbersOrChars;
    }

    public static <T, R> List<R> task12(List<T> list, Function<T, R> mapper) {
        List<R> intList = new ArrayList<>();
        for (T st : list) {
            R apply = mapper.apply(st);
            intList.add(apply);
        }
        return intList;
    }

    public static <T> void task13(List<T> list, Consumer<T> consumer) {
        for (T elem : list) {
            consumer.accept(elem);
        }
    }

    public static <T> List<T> task14(Supplier<T> supplier, int n) {
        List<T> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(supplier.get());
        }
        return numbers;
    }

}
