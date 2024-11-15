package com.aaditya.leetcode.problems.problem1570;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class SparseVector {

    private final Map<Integer, Integer> indexToValue;

    SparseVector(int[] nums) {
        this.indexToValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.indexToValue.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        HashSet<Integer> intersection = new HashSet<>(this.indexToValue.keySet());
        intersection.retainAll(vec.indexToValue.keySet());
        return intersection.stream().map(k -> this.indexToValue.get(k) * vec.indexToValue.get(k)).reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        SparseVector sparseVector = new SparseVector(new int[]{0, 0, 0, 0});
        System.out.println(sparseVector.dotProduct(new SparseVector(new int[]{0, 0, 4, 3})));
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);