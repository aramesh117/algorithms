package com.aaditya.leetcode.problem55;

public class Solution {
    public static boolean canJump(int[] nums) {
        int lastGood = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGood) {
                lastGood = i;
            }
        }
        return lastGood == 0;
    }

}
