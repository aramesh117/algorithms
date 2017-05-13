package com.aaditya.leetcode.problem283;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 11};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : nums) {
            if (num != 0) {
                queue.add(num);
            }
        }
        Arrays.fill(nums, 0);
        int i = 0;
        while (!queue.isEmpty()) {
            nums[i] = queue.poll();
            i++;
        }
    }
}
