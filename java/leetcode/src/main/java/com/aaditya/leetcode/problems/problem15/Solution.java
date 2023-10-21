package com.aaditya.leetcode.problems.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[0]);
                list1.add(nums[1]);
                list1.add(nums[2]);
                list.add(list1);
                return list;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && (nums[i] == nums[i - 1]))
                continue;
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                if (a + b + c == 0) {
                    res.add(Arrays.asList(a, b, c));
                    while (start < end && nums[start] == b) start++;
                    while (start < end && nums[end] == c) end--;
                } else {
                    if (a + b + c > 0) {
                        while (end > 0 && nums[end] == c) {
                            end--;
                        }
                    } else {
                        while (start < nums.length && nums[start] == b) {
                            start++;
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,-3,0,0,-2}));
    }
}
