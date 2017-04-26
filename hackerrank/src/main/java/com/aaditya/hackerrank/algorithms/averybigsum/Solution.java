package com.aaditya.hackerrank.algorithms.averybigsum;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}
