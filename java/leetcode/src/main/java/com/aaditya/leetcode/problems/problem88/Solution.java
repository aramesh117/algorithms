package com.aaditya.leetcode.problems.problem88;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        run(new int[]{0}, new int[]{1});
        run(new int[]{1, 0, 0}, new int[]{-1, 1});
        run(new int[]{0, 0}, new int[]{-1, 1});
        run(new int[]{100, 0, 0}, new int[]{-1, 1});
        run(new int[]{100, 101}, new int[]{});
        run(new int[]{2, 0}, new int[]{1});
    }

    private static void run(int[] nums1, int[] nums2) {
        new Solution().merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else if (n == 0 && m >= 0) {
            return;
        }
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p >= 0 && p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            } else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }
        if (p1 >= 0) {
            while (p >= 0) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }
        if (p2 >= 0) {
            while (p >= 0) {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }
    }
}