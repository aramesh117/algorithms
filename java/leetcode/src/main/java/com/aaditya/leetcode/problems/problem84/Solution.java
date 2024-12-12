package com.aaditya.leetcode.problems.problem84;

import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        var stack = new ArrayDeque<Integer>();
        stack.push(-1);
        int maxRectangle = Integer.MIN_VALUE;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                // Should never happen
                return -1;
            }
            if (stack.peek() == -1) {
                stack.push(i);
            } else if (heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                    Integer prevHeightStart = stack.pop();
                    int currentHeight = heights[prevHeightStart];
                    int currentWidth = i - 1 - stack.peek();
                    maxRectangle = Math.max(maxRectangle, currentWidth * currentHeight);
                }
                stack.push(i);
            }
        }
        while (stack.peek() != -1) {
            Integer prevHeightStart = stack.pop();
            int currentHeight = heights[prevHeightStart];
            int currentWidth = length - 1 - stack.peek();
            maxRectangle = Math.max(maxRectangle, currentWidth * currentHeight);
        }

        return maxRectangle;
    }
}