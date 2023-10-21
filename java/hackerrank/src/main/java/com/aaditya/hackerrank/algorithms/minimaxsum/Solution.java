package com.aaditya.hackerrank.algorithms.minimaxsum;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long sum = 0;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < 5; i++) {
                int a = scanner.nextInt();
                sum += a;
                min = Math.min(min, a);
                max = Math.max(max, a);
            }
            System.out.println((sum - max) + " " + (sum - min));
        }
    }
}
