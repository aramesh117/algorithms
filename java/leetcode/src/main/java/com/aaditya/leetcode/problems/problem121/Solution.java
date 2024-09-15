package com.aaditya.leetcode.problems.problem121;


class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{-1,-1,4,-3,3}));
    }
}