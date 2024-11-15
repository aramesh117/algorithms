package com.aaditya.leetcode.problems.problem48;

class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int rowLimit;
        int colLimit;
        if (n % 2 == 1) {
            rowLimit = n / 2 + 1;
            colLimit = n / 2;
        } else {
            rowLimit = n / 2;
            colLimit = n / 2;
        }
        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                int first = matrix[i][j]; // 1,2
                int second = matrix[j][n - 1 - i]; // 2,5
                int third = matrix[n - 1 - i][n - 1 - j]; //
                int fourth = matrix[n - 1 - j][i]; // [2][0]
                matrix[i][j] = fourth;
                matrix[j][n - 1 - i] = first;
                matrix[n - 1 - i][n - 1 - j] = second;
                matrix[n - 1 - j][i] = third;
            }
        }
    }

//    public static void main(String[] args) {
//        int n = 5;
//        int[][] matrix = new int[n][n];
//        int count = 1;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                matrix[i][j] = count;
//                count += 1;
//            }
//        }
//        evenSpacedMatrix(matrix);
//        System.out.println();
//        Solution.rotate(matrix);
//        evenSpacedMatrix(matrix);
//    }
//
//    private static void evenSpacedMatrix(int[][] matrix) {
//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                System.out.printf("%3d", anInt);
//            }
//            System.out.println();
//        }
//    }

}



