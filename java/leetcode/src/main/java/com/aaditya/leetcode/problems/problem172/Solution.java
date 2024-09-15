package com.aaditya.leetcode.problems.problem172;

public class Solution {
    public static int trailingZeroes(int n) {
        int highestPowerOf5 = (int) Math.floor(Math.log(n) / Math.log(5));
        int res = 0;
        for (int i = 1; i <= highestPowerOf5; i++) {
            res += (int) Math.floorDiv(n, (long) Math.pow(5, i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }
}
