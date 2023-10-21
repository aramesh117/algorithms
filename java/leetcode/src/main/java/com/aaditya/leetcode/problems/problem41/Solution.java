package com.aaditya.leetcode.problems.problem41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        boolean[] buckets = new boolean[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                buckets[num - 1] = true;
            }
        }
        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i]) {
                return i + 1;
            }
        }
        return buckets.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1}));
    }
}
