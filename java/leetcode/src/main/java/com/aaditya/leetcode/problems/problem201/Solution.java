package com.aaditya.leetcode.problems.problem201;

class Solution {
    public static int rangeBitwiseAnd(int left, int right) {
        int bitLength = Integer.bitCount(Integer.highestOneBit(left ^ right) * 2 - 1);
        int commonPrefix = -1 << bitLength;
        return left & commonPrefix;
    }
}