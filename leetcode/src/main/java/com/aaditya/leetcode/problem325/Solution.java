package com.aaditya.leetcode.problem325;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 1};
        System.out.println(maxSubArrayLen(nums, 0));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int[] totals = new int[nums.length + 1];
        int total = 0;
        totals[0] = total;
        for (int i = 1; i <= nums.length; i++) {
            total += nums[i - 1];
            totals[i] = total;
        }

        int maxSize = 0;
        for (int i = 0; i < totals.length - 1; i++) {
            for (int j = i + 1; j < totals.length; j++) {
                if (totals[j] - totals[i] == k) {
                    maxSize = Math.max(maxSize, j - i);
                }
            }
        }
        return maxSize;
    }
}
