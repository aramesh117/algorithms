package com.aaditya.leetcode.problems.problem1004;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxSize = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                right++;
                k--;
            }
            if (k < 0) {
                k += (1 - nums[left]);
                left++;
            }
            maxSize = Math.max(maxSize, right - left);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(new Solution().longestOnes(new int[]{0, 0, 0}, 3));
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 0}, 3));
        System.out.println(new Solution().longestOnes(new int[]{0, 1, 0, 1, 0}, 3));
    }
}