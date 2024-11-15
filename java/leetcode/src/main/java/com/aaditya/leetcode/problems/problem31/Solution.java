package com.aaditya.leetcode.problems.problem31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // Find the first index where it's not increasing from the right, keeping track of all the numbers
        // up to that point in a sorted set.
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] >= nums[i + 1]) {
                i--;
            } else {
                break;
            }
        }
        if (i < 0) {
            // This means we're all descending.
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i]) {
            j--;
        }
        // Swap
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        Arrays.sort(nums, i + 1, nums.length);
    }

    public static void main(String[] args) throws Exception {
        test(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        test(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        test(new int[]{2, 1, 3}, new int[]{2, 3, 1});
        test(new int[]{2, 3, 1}, new int[]{3, 1, 2});
        test(new int[]{3, 1, 2}, new int[]{3, 2, 1});
        test(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        test(new int[]{1, 1, 2}, new int[]{1, 2, 1});
        test(new int[]{1, 2, 1}, new int[]{2, 1, 1});
    }

    private static void test(int[] nums, int[] expected) throws Exception {
        new Solution().nextPermutation(nums);
        if (!Arrays.equals(expected, nums)) {
            System.out.printf("%s != %s%n", Arrays.toString(expected), Arrays.toString(nums));
            throw new Exception();
        }
    }
}