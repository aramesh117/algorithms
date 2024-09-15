package com.aaditya.leetcode.problems.problem209;

class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = nums[0];
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        while (true) {
            if (currentSum < target) {
                j++;
                if (j >= nums.length) {
                    break;
                }
                currentSum += nums[j];
            } else if (currentSum == target) {
                minLength = Math.min(minLength, j - i + 1);
                currentSum -= nums[i];
                i++;
            } else {
                minLength = Math.min(minLength, j - i + 1);
                currentSum -= nums[i];
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
//        System.out.println(minSubArrayLen(3, new int[]{1, 2, 3, 4, 5}));
    }

}