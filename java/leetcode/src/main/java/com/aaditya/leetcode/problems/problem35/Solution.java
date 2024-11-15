package com.aaditya.leetcode.problems.problem35;

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int hi = nums.length - 1;
        int low = 0;
        while (low <= hi) {
            int mid = (low + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 4, 5, 6}, 10));
    }
}