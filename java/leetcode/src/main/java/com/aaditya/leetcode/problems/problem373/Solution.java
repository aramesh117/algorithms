package com.aaditya.leetcode.problems.problem373;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int nextSum = nums1[0] + nums2[0];
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < nums1.length && j + 1 < nums2.length) {
                if (nums1[i + 1] <= nums2[j + 1]) {
                    i++;
                } else {
                    j++;
                }
            } else if (j + 1 < nums2.length) {
                j++;
            } else if (i + 1 < nums1.length) {
                i++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2, 3}, new int[]{1, 10, 11}, 4));
    }
}

// 1 2 3
// 1, 10, 11
//