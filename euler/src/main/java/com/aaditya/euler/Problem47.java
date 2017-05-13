package com.aaditya.euler;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Problem47 {
    private static final SortedSet<Integer> primes = new TreeSet<>();

    private static void addPrimesLessThan(int N) {
        IntStream.rangeClosed(2, N).forEach(primes::add);
        for (int i = 2; i < N; i++) {
            if (primes.contains(i)) {
                for (int j = 2 * i; j < N; j += i) {
                    primes.remove(j);
                }
            }
        }
    }

    public static void printFirst(int N, int K) {
        // First number
        for (int i = 3; i <= N; i++) {
            // Each of the consecutive numbers.
            boolean allSatisfy = true;
            for (int j = 0; j < K; j++) {
                int finalI = i;
                int finalJ = j;
                allSatisfy &= primes.headSet(i + j).stream().filter(prime -> (finalI + finalJ) % prime == 0).count() == K;
            }
            if (allSatisfy) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            addPrimesLessThan(N);
            printFirst(N, K);
        }
    }
}
