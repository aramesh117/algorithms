package com.aaditya.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by aramesh on 4/18/17.
 */
public class SimpleArraySum {
    public static void main(String[] args) {
        int sum = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                sum += scanner.nextInt();
            }
        }
        System.out.println(sum);
    }
}
