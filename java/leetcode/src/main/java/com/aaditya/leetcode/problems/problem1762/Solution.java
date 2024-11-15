package com.aaditya.leetcode.problems.problem1762;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> indices = new LinkedList<>();
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxSoFar) {
                indices.addFirst(i);
                maxSoFar = Math.max(maxSoFar, heights[i]);
            }
        }
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findBuildings(new int[]{4, 2, 3, 1})));
        System.out.println(Arrays.toString(new Solution().findBuildings(new int[]{1, 2, 2})));
        System.out.println(Arrays.toString(new Solution().findBuildings(new int[]{0})));
    }
}