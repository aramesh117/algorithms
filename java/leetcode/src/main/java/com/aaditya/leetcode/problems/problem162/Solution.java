package com.aaditya.leetcode.problems.problem162;

class Solution {
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = Math.floorDiv(low + high, 2);
            if (peak(nums, mid)) {
                return mid;
            } else if (upwards(nums, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static boolean upwards(int[] nums, int i) {
        boolean greaterThanLeft = i == 0 || nums[i] >= nums[i - 1];
        boolean lessThanRight;
        if (i < nums.length - 1) {
            lessThanRight = nums[i] <= nums[i + 1];
        } else {
            lessThanRight = false;
        }
        return greaterThanLeft && lessThanRight;
    }

    private static boolean peak(int[] nums, int i) {
        boolean greaterThanLeft = i == 0 || nums[i] >= nums[i - 1];
        boolean greaterThanRight = i + 1 >= nums.length || nums[i] >= nums[i + 1];
        return greaterThanRight && greaterThanLeft;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4, 5, 5, 10, 7, 1, 1, 1, 1, -1, -1, Integer.MIN_VALUE}));
        System.out.println(findPeakElement(new int[]{-1, 1, 2}));
        System.out.println(findPeakElement(new int[]{0}));
        System.out.println(findPeakElement(new int[]{1, -1}));
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(findPeakElement(new int[]{6, 5, 4, 3, 2, 3, 2}));
    }
}