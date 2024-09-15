package com.aaditya.leetcode.problems.problem122;

class Solution {

    public static int maxProfit(int[] prices) {
        long total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return (int) total;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{9, 9, 0, 3, 4, 6, 8, 10, 12, 2}));
    }
}
