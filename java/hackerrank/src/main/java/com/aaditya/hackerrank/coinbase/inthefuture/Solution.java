package com.aaditya.hackerrank.coinbase.inthefuture;

public class Solution {
    static int minNum(int A, int K, int P) {
        // No catching up because Asha is ahead (positive P) and Kelly cannot catch up.
        if (K <= A) {
            return -1;
        }
        return P/(K - A) + 1;
    }
    public static void main(String[] args) {
        System.out.println(minNum(1, 3, 3));
    }
}
