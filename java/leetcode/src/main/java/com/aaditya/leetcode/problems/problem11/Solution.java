package com.aaditya.leetcode.problems.problem11;

public class Solution {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        System.out.println(maxArea(heights));
    }
}
