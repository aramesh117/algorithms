package com.aaditya.leetcode.problems.problem189;

import java.util.Arrays;

class Solution {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        if (start < 0 || start >= nums.length || end < 0 || end >= nums.length) {
            throw new IllegalArgumentException();
        }
        for (int i = start; i <= (start + end) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end - (i - start)];
            nums[end - (i - start)] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 6);
        System.out.println(Arrays.toString(nums));
    }
}