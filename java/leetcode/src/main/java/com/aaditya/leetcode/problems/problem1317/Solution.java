package com.aaditya.leetcode.problems.problem1317;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int N = n;
        int a = 0, b = 0, digitPlace = 1;
        while (n > 0) {
            int d = n % 10;
            n /= 10;

            if ((d == 0 || d == 1) && n > 0) {
                a += digitPlace * (1 + d);
                b += digitPlace * 9;
                n--;
            } else {
                a += digitPlace;
                b += digitPlace * (d - 1);
            }
            digitPlace *= 10;
        }

        return new int[]{a, b};
    }
}