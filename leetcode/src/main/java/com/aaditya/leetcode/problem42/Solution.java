package com.aaditya.leetcode.problem42;

import java.util.TreeSet;

public class Solution {
    public static int trap(int[] heights) {
        TreeSet<Integer> uniqHeights = new TreeSet<>();
        uniqHeights.add(0);
        for (int h : heights) {
            uniqHeights.add(h);
        }
        int total = 0;
        for (int h : uniqHeights) {
            if (h > 0) {
                total += (h - uniqHeights.lower(h)) * getWaterForHeight(h, heights);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int getWaterForHeight(int h, int[] heights) {
        int lastIndex = -1;
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] >= h) {
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    total += i - lastIndex - 1;
                    lastIndex = i;
                }
            }
        }
        return total;
    }
}
