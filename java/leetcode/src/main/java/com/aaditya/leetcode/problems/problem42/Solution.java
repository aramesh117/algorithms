package com.aaditya.leetcode.problems.problem42;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int current = 0;
        int totalWater = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peekFirst()] < height[current]) {
                int floorIndex = stack.removeFirst();
                int floor = height[floorIndex];
                if (stack.isEmpty()) {
                    // No enclosing left wall, so no more water to add
                    break;
                }
                int leftIndex = stack.peekFirst();
                int left = height[leftIndex];
                int horizontalDistance = current - leftIndex - 1;
                int verticalDistance = Math.min(height[current], left) - floor;
                totalWater += horizontalDistance * verticalDistance;
            }
            stack.addFirst(current);
            current++;
        }
        return totalWater;
    }
}
