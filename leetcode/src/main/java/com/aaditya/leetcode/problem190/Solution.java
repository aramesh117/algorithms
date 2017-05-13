package com.aaditya.leetcode.problem190;

public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        int upper = 1 << 31;
        int lower = 1;
        for (int i = 0; i < 32; i++) {
            res |= (n & upper) == 0 ? 0 : lower;
            upper = upper >>> 1;
            lower = lower << 1;
        }
        return res;
    }


//    1010101
//    upper = 10000...0
//    lower = 1
//    res = 0
//    i = 0:
//      n & upper = 0

    public static void main(String[] args) {
        int n = 0b1011111;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(reverseBits(n)));
        System.out.println(Integer.toBinaryString(reverseBits(n)).length());
    }
}
