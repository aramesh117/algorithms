package com.aaditya.leetcode.problems.problem136;

class Solution {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumber(new int[]{-1,-1,11,11,-5}));
    }
}