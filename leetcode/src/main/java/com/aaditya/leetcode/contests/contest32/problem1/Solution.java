package com.aaditya.leetcode.contests.contest32.problem1;

import java.util.Arrays;

public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        if (Arrays.equals(copy, nums)) {
            return 0;
        }
        int firstDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                firstDiff = i;
                break;
            }
        }
        int lastDiff = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                lastDiff = i;
                break;
            }
        }
        return lastDiff - firstDiff + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(findUnsortedSubarray(nums));
    }
}
