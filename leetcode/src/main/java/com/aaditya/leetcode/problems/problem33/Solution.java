package com.aaditya.leetcode.problems.problem33;

public class Solution {
    public static int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // If lo .. mid is sorted.
            if (nums[mid] >= nums[lo]) {
                if (target == nums[mid]) {
                    return mid;
                }
                if (target < nums[lo] || target > nums[mid]) {
                    // The target lies in the right side.
                    lo = mid + 1;
                } else {
                    // target > nums[lo] and < nums[mid]
                    hi = mid - 1;
                }
            } else {
                if (target == nums[mid]) {
                    return mid;
                }

                if (target > nums[mid] && target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 15, 26, 1, 2, 3};
        System.out.println(search(arr, 7));
    }
}
