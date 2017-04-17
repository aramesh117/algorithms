package com.aaditya.leetcode.problem45;

import java.util.Arrays;

public class Solution {
    // OPT(j) = min(for i in 1 to nums[i]:
    //                1 + OPT(j + i))
    private int[] dp;

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,1,4,1,1,1,1,1}));
    }

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jumpHelper(nums, 0);
    }

    private int jumpHelper(int[] nums, int j) {
        if (j >= nums.length - 1) {
            return 0;
        }
        if (dp[j] != -1) {
            return dp[j];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[j]; i++) {
            int curr = jumpHelper(nums, j + i) + 1;
            min = Math.min(curr, min);
        }
        dp[j] = min;
        return min;
    }
}
