package com.aaditya.leetcode.problem11;

public class Solution {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int j = height.length - 1;
        int i = 0;
        while (i <= j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {
                1, 2, 3, 11, 8, 155000, 10
        };
        System.out.println(maxArea(heights));
    }
}
