package com.aaditya.leetcode.contests.contest34.problem1;

class Solution {
    public static int minChanges(int n, int k) {
        if (k > n) {
            return -1;
        }
        int nMask = (1 << Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 1) - 1;
        int differentBits = n ^ k;
        int impossibleBits = (~n & k & nMask);
        if (impossibleBits != 0) {
            return -1;
        }
        return Integer.bitCount(differentBits);
    }

    public static void main(String[] args) {
        assert minChanges(13, 4) == 2;
        assert minChanges(21, 21) == 0;
        assert minChanges(14, 13) == -1;
    }
}
//    1101 = n
//    0110 = k

//1...1001 = ~k
//    1011 = XOR
//    0010 = result = ((~k) & kMask & (n ^ k)


//    1101 = n
//    0100 = k

//    0011 = ~k & kMask
//    1001 = XOR
//    0000 = result
