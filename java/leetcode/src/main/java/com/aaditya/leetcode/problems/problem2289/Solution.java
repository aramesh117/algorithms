package com.aaditya.leetcode.problems.problem2289;

import org.junit.jupiter.api.Assertions;

class Solution {
    public static void main(String[] args) {
        Assertions.assertEquals(3, new Solution().totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        Assertions.assertEquals(0, new Solution().totalSteps(new int[]{1, 1, 1, 1, 1, 2}));
        Assertions.assertEquals(1, new Solution().totalSteps(new int[]{1, 0}));
        Assertions.assertEquals(3, new Solution().totalSteps(new int[]{1, 0, 0, 0, 1, 0}));
        Assertions.assertEquals(0, new Solution().totalSteps(new int[]{4, 5, 7, 7, 13}));
        Assertions.assertEquals(0, new Solution().totalSteps(new int[]{1}));
        Assertions.assertEquals(1, new Solution().totalSteps(new int[]{0, 0, 0, 1, 0}));
        Assertions.assertEquals(9, new Solution().totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}));
        Assertions.assertEquals(9, new Solution().totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}));
    }

    public int totalSteps(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int i = 1;
        int currentHill = nums[0];
        int currentValleyWidth = 0;
        int maxValleyWidth = 0;
        while (i < nums.length) {
            if (nums[i] < currentHill) {
                currentValleyWidth++;
            } else {
                currentHill = nums[i];
                currentValleyWidth = 0;
            }
            maxValleyWidth = Math.max(maxValleyWidth, currentValleyWidth + 1);
            i++;
        }
        return Math.max(0, maxValleyWidth - 1);
    }
}
