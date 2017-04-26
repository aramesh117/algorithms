package com.aaditya.hackerrank.algorithms.staircase;

import java.util.Scanner;

public class Solution {
    private static void StairCase(int N) {
        for (int line = 0; line < N; line++) {
            StringBuilder stringBuilder = new StringBuilder(N);
            for (int c = 0; c < N; c++) {
                if (c < N - 1 - line) {
                    stringBuilder.append(' ');
                } else {
                    stringBuilder.append('#');
                }
            }
            System.out.println(stringBuilder);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        StairCase(_n);

    }
}
