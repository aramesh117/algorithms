package com.aaditya.leetcode.problems.problem55;

public class Solution {
    public static boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (destination - i <= nums[i]) {
                destination = i;
            }
        }
        return destination == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{5, 0, 0, 0, 4}));
        System.out.println(canJump(new int[]{0, 0, 0, 0, 4}));
        System.out.println(canJump(new int[]{1, 2, 2, 0, 4}));
    }

}
