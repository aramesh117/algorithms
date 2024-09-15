package com.aaditya.leetcode.problems.problem137;

class Solution {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sumForBiti = 0;
            for (int num : nums) {
                sumForBiti += (num >> i) & 1;
            }
            ans |= (sumForBiti % 3) << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Solution.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(Solution.singleNumber(new int[]{2, 2, 999, 2}));
        System.out.println(Solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(Solution.singleNumber(new int[]{4, 1, 1, 1, 6, 6, 6}));
        System.out.println(Solution.singleNumber(new int[]{-4, 1, 1, 1, 6, 6, 6}));
    }
}
