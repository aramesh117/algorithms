package com.aaditya.hackerrank.airbnb.numberofpathsmatrix;

import java.util.Scanner;

public class Solution {
    public static final int MOD = 1000000007;
    public static int numPaths(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] paths = new int[rows][cols];
        // Initial conditions:
        System.arraycopy(matrix[rows - 1], 0, paths[rows - 1], 0, cols);
        for (int i = 0; i < rows; i++) {
            paths[i][cols - 1] = matrix[i][cols - 1];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = (paths[i + 1][j] + paths[i][j + 1]) % MOD;
                }
            }
        }
        return paths[0][0];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(numPaths(matrix));
        }
    }
}
