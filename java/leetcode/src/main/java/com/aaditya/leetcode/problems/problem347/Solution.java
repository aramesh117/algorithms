package com.aaditya.leetcode.problems.problem347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        var freqOrdered = new TreeMap<Integer, List<Integer>>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            freqOrdered.computeIfAbsent(entry.getValue(), ArrayList::new).add(entry.getKey());
        }
        ArrayList<Integer> mostFreq = new ArrayList<>();
        for (var entry : freqOrdered.entrySet()) {
            mostFreq.addAll(entry.getValue());
            if (mostFreq.size() >= k) {
                return mostFreq.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return mostFreq.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1}, 2)));
    }
}