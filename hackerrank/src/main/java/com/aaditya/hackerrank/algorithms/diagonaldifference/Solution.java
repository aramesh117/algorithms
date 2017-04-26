package com.aaditya.hackerrank.algorithms.diagonaldifference;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < N; i++) {
                sum1 += matrix[i][i];
                sum2 += matrix[i][N - 1 - i];
            }
            System.out.println(Math.abs(sum1 - sum2));
        }
    }
}
