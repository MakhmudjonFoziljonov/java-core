package lesson2;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Lesson2 lesson2 = new Lesson2();
        Scanner sc = new Scanner(System.in);

        // 1) Вывести числа от 1 до 100 (каждые 10 цифр в одну строку)

        System.out.println(" Numbers 1..100:");
        lesson2.print1to100();
        System.out.println();

        // 2) Сумма чисел от 1 до N (ввод N с клавиатуры).

        System.out.print("Введите N для суммы 1..N: ");
        int N = sc.nextInt();
        System.out.println("Sum 1..N = " + lesson2.sumToN(N));
        System.out.println();

        // 3) Произведение чисел от 1 до N.

        System.out.print("Введите N для произведения 1..N : ");
        int _prod = sc.nextInt();
        if (_prod < 0) {
            System.out.println("Произведение для отрицательного N не определено в этой программе.");
        } else {
            System.out.println("Product 1..N = " + lesson2.productToN(_prod));
        }
        System.out.println();

        // 4) Сумма четных чисел от 1 до N.
        System.out.print("Введите N для суммы чётных 1..N: ");
        int Neven = sc.nextInt();
        System.out.println("Sum of even numbers 1..N = " + lesson2.sumEvenToN(Neven));
        System.out.println();

        // 5) Сумма цифр числа (например, 1234 → 10).
        System.out.print("Введите целое число для суммы цифр: ");
        long numForSumDigits = sc.nextLong();
        System.out.println("Sum of digits = " + lesson2.sumDigits(numForSumDigits));
        System.out.println();

        // 6) Разворот числа (например, 1234 → 4321).
        System.out.print("Введите целое число для разворота: ");
        long numForReverse = sc.nextLong();
        System.out.println("Reversed = " + lesson2.reverseNumber(numForReverse));
        System.out.println();

        // 7) Найти факториал N (через цикл, не рекурсией).
        System.out.print("Введите N для факториала: ");
        int _fact = sc.nextInt();
        if (_fact < 0) {
            System.out.println("Факториал для отрицательного N не определён.");
        } else {
            System.out.println("Factorial = " + lesson2.factorial(_fact));
        }
        System.out.println();

        // 8) Найти первое число, которое делится на 7 и больше 1000.
        System.out.println(" First number > 1000 and divisible by 7: " + lesson2.firstDivisibleBy7GreaterThan1000());
        System.out.println();

        // 9) Вывести все простые числа до N.
        System.out.print(" Введите N. Выведем все простые числа <= N: ");
        int _primes = sc.nextInt();
        lesson2.printPrimesUpToN(_primes);
        System.out.println();

        // 10) Нарисовать треугольники из звездочек (по образцу)
        System.out.println("Triangles :");
        int triangleN = 4;
        lesson2.drawTriangles(triangleN);
        System.out.println();
        lesson2.drawTrianglesReverse(triangleN);
        System.out.println();

        sc.close();
    }

}