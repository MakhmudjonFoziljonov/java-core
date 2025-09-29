package lesson2;

import java.math.BigInteger;


public class Lesson2 {
    // 1)
    public void print1to100() {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%3d ", i);
            if (i % 10 == 0) System.out.println();
        }
    }

    // 2)
    public long sumToN(int N) {
        if (N <= 0) return 0;
        return (long) N * (N + 1) / 2;
    }

    // 3)
    public BigInteger productToN(int N) {
        if (N == 0) return BigInteger.ONE;
        BigInteger prod = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        return prod;
    }

    // 4)
    public long sumEvenToN(int N) {
        if (N < 2) return 0;
        long k = N / 2;
        return k * (k + 1);
    }

    // 5)
    public long sumDigits(long x) {
        long n = Math.abs(x);
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // 6)
    public long reverseNumber(long x) {
        boolean neg = x < 0;
        long n = Math.abs(x);
        long rev = 0;
        while (n > 0) {
            int d = (int) (n % 10);
            rev = rev * 10 + d;
            n /= 10;
        }
        return neg ? -rev : rev;
    }

    // 7)
    public BigInteger factorial(int N) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= N; i++) res = res.multiply(BigInteger.valueOf(i));
        return res;
    }

    // 8)
    public int firstDivisibleBy7GreaterThan1000() {
        int base = 1000 / 7;
        return (base + 1) * 7;
    }

    // 9)
    public void printPrimesUpToN(int N) {
        if (N < 2) {
            System.out.println("Нет простых чис до " + N);
            return;
        }
        boolean[] isComposite = new boolean[N + 1];
        int limit = (int) Math.sqrt(N);
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        System.out.println("Primes <= " + N + ":");
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                System.out.print(i + " ");
                count++;
                if (count % 20 == 0) System.out.println();
            }
        }
        System.out.println();
        System.out.println("Total primes: " + count);
    }

    // 10) Нарисовать треугольники из звездочек:
    public void drawTriangles(int n) {
        for (int i = 1; i <= n; i++) {
            printChars('*', i);
            printChars(' ', 4 - i + 1);
            printChars('*', n - i + 1);
            System.out.println();
        }
    }

    public void drawTrianglesReverse(int n) {
        for (int i = n; i >= 1; i--) {
            printChars('*', i);
            printChars(' ', 4 - i + 1);
            printChars('*', n - i + 1);
            System.out.println();
        }
    }

    private void printChars(char c, int times) {
        for (int i = 0; i < times; i++) System.out.print(c);
    }
}

