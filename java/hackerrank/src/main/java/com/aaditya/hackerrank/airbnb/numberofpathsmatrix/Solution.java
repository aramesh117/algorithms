package com.aaditya.hackerrank.airbnb.numberofpathsmatrix;

import java.util.Scanner;

public class Solution {
    public static final int MOD = 1000000007;

    public static int numPaths(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] paths = new int[rows][cols];
        if (rows == 1) {
            // If any of the columns is zero, then there is no path.
            for (int i = 0; i < cols; i++) {
                if (matrix[0][i] == 0) {
                    return 0;
                }
            }
            return 1;
        }
        if (cols == 1) {
            // If any of the rows is zero, then there is no path, otherwise there is exactly one path.
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    return 0;
                }
            }
            return 1;
        }
        if (matrix[rows - 1][cols - 1] == 0) {
            return 0;
        }
        // Initial conditions:
        System.arraycopy(matrix[rows - 1], 0, paths[rows - 1], 0, cols);
        for (int i = 0; i < rows; i++) {
            paths[i][cols - 1] = matrix[i][cols - 1];
        }
        // In the last row, if any entries in matrix is zero, then all entries before must be zero.
        int lastRowZero = -1;
        for (int i = cols - 1; i >= 0; i--) {
            if (matrix[rows - 1][i] == 0) {
                lastRowZero = i;
            }
            if (lastRowZero != -1) {
                paths[rows - 1][i] = 0;
            }
        }
        // In the last column, if any entries in matrix is zero, then all entries before must be zero.
        int lastColZero = -1;
        for (int i = rows - 1; i >= 0; i--) {
            if (matrix[i][cols - 1] == 0) {
                lastColZero = i;
            }
            if (lastColZero != -1) {
                paths[i][cols - 1] = 0;
            }
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
