package com.aaditya.leetcode.problems.problem45;

import java.util.Arrays;

class Solution {
    /**
     * OPT(kth position) = min jump count of { all ways to reach the kth position }
     */
    public static int jump(int[] nums) {
        int[] minJumps = new int[nums.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int sourceMin = minJumps[i];
            int jumpMax = nums[i];
            for (int j = 1; j <= jumpMax; j++) {
                if (i + j < nums.length) {
                    minJumps[i + j] = Math.min(minJumps[i + j], 1 + sourceMin);
                }
            }
        }
        return minJumps[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(jump(new int[]{6, 0, 0, 0, 0, 0}));
        System.out.println(jump(new int[]{5,1,1,1,1,1,4}));
    }

}