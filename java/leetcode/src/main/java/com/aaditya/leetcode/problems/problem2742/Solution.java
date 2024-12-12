package com.aaditya.leetcode.problems.problem2742;

class Solution {
    private int[][] dp;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return helper(0, n, cost, time);
    }

    private int helper(int index, int remainingJobs, int[] cost, int[] time) {
        int n = cost.length;
        if (remainingJobs <= 0) {
            return 0;
        }
        if (index >= n) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][remainingJobs] != Integer.MAX_VALUE) {
            return dp[index][remainingJobs];
        }

        int paint = cost[index] + helper(index + 1, remainingJobs - time[index] - 1, cost, time);
        int dontPaint = helper(index + 1, remainingJobs, cost, time);
        int value = Math.min(dontPaint, paint);
        dp[index][remainingJobs] = value;
        return value;
    }
}