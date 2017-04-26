package com.aaditya.hackerrank.algorithms.plusminus;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int pos = 0;
            int zero = 0;
            int neg = 0;
            for (int i = 0; i < N; i++) {
                int a = scanner.nextInt();
                pos += a > 0 ? 1 : 0;
                zero += a == 0 ? 1 : 0;
                neg += a < 0 ? 1 : 0;
            }
            System.out.printf("%.6f\n", (float) pos / N);
            System.out.printf("%.6f\n", (float) neg / N);
            System.out.printf("%.6f\n", (float) zero / N);
        }
    }
}
