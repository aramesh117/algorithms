package com.aaditya.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (remainderIndexMap.containsKey(nums[i])) {
                int res1 = remainderIndexMap.get(nums[i]) + 1;
                int res2 = i + 1;
                return new int[]{res1, res2};
            } else {
                remainderIndexMap.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
}
