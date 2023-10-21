package com.aaditya.euler;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Problem46 {

    private static final SortedSet<Integer> primes = new TreeSet<>();

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int numWays(int N) {
        return (int) primes.headSet(N).stream().filter(prime -> {
            int remainder = N - prime;
            return remainder % 2 == 0 && isPerfectSquare(remainder / 2);
        }).count();
    }

    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.round(Math.sqrt(n));
        return sqrt * sqrt == n;
    }

    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            int numCases = scanner.nextInt();
//            IntStream.Builder builder = IntStream.builder();
//            for (int i = 0; i < numCases; i++) {
//                builder.add(scanner.nextInt());
//            }
//            IntStream input = builder.build();
//            input.map(Problem46::numWays).forEach(System.out::println);
//        }
        primes.add(2);
        IntStream.rangeClosed(3, 500000).filter(Problem46::isPrime).forEach(primes::add);
        System.out.println(IntStream.iterate(9, i -> i + 2).filter(value -> !primes.contains(value) && numWays(value) == 0).findFirst());
    }
}
