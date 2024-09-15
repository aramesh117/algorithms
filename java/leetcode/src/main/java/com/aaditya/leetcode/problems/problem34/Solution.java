package com.aaditya.leetcode.problems.problem34;

import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int startingIndex = Arrays.binarySearch(nums, target);
        if (startingIndex < 0) {
            return new int[]{-1, -1};
        }

        // Upper bound search
        int low = startingIndex;
        int high = nums.length - 1;
        int upperBound;
        while (low <= high) {
            int mid = Math.floorDiv(low + high, 2);
            if (nums[mid] == target && mid + 1 < nums.length && nums[mid + 1] != target) {
                upperBound = mid;
                low = mid + 1;
            } else if (nums[mid] == target) {
                low = mid + 1;
            } else {
                // nums[i] > target since it's sorted
                high = mid - 1;
            }
        }
        upperBound = high;

        low = 0;
        high = startingIndex;
        int lowerBound = -1;
        while (low <= high) {
            int mid = Math.floorDiv(low + high, 2);
            if (nums[mid] == target && nums[mid] != target) {
                upperBound = mid;
                low = mid + 1;
            } else if (nums[mid] == target) {
                high = mid - 1;
            } else {
                // nums[i] > target since it's sorted
                low = mid + 1;
            }
        }
        lowerBound = low;

        return new int[]{lowerBound, upperBound};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 3, 3}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 2}, 1)));
    }
}
