package com.aaditya.leetcode.problems.problem80;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int currValue = nums[0];
        int currRunLength = 0;
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currValue) {
                currRunLength++;
            } else {
                currValue = nums[i];
                currRunLength = 1;
            }
            if (currRunLength > 2) {
                nums[i] = Integer.MAX_VALUE;
                k--;
            }
        }
        Arrays.sort(nums);
        return k;
    }

    public static void main(String[] args) {
//        int[] testCase = {0,0,1,1,1,1,2,3,3};
//        int[] testCase = {1,1,1,2,2,3};
//        int[] testCase = {1};
//        int[] testCase = {1,1,1,1,1};
        int[] testCase = {-10000,-10000,-10000,-1,-1,-1,2};
        System.out.println(removeDuplicates(testCase));
        System.out.println(Arrays.toString(testCase));
    }
}
