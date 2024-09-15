package com.aaditya.leetcode.problems.problem215;

import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> rawQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int num : nums) {
            rawQueue.add(num);
            minQueue.add(num);
            if (rawQueue.size() > k) {
                Integer smallest = minQueue.poll();
                rawQueue.remove(smallest);
            }
        }
        return minQueue.peek();
    }

    public static void main(String[] args) {
//        System.out.println(findKthLargest(new int[]{1, 2, 3, 4}, 4));
        System.out.println(findKthLargest(new int[]{4, 4, 4, 4, 1, 1, 1, 3, 3}, 7));
    }
}
