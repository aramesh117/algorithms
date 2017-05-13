package com.aaditya.leetcode.problem34;

import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        // Find the first occurrence of target.
        // Once this is found, we can do a modified binary search before and after again to find the lower bound and
        // upper bound.
        int initialIndex = Arrays.binarySearch(nums, target);
        if (initialIndex < 0) {
            return new int[]{-1, -1};
        }
        // Find number closest to target but less in the lower half. If there is no number less than target, then
        // return 0.
        int high = initialIndex;
        int low = 0;
        int lowerIndex = high;
        if (nums[low] == target) {
            lowerIndex = low;
        } else {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    if (nums[mid + 1] == target) {
                        lowerIndex = mid + 1;
                        break;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            }
        }

        int upperIndex = nums.length - 1;
        low = initialIndex;
        high = nums.length - 1;
        if (nums[high] == target) {
            upperIndex = high;
        } else {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] > target) {
                    if (nums[mid - 1] == target) {
                        upperIndex = mid - 1;
                        break;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{lowerIndex, upperIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 2)));
    }
}
