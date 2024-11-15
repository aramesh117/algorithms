package com.aaditya.leetcode.problems.problem215;

import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int num : nums) {
            minQueue.add(num);
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        return minQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1, 2, 3, 4}, 4)); // Should be 1
        System.out.println(findKthLargest(new int[]{1, 1, 1, 2, 3, 4, 5}, 8)); //
    }
}
