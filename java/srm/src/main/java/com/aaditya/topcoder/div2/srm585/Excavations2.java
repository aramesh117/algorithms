package com.aaditya.topcoder.div2.srm585;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Excavations2 {
    private static final long[][] dp = new long[50][50];

    static {
        for (int i = 0; i < 50; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    public static long count(int[] kind, int[] found, int K) {
        int[] kindFreq = new int[50];
        Set<Integer> foundSet = new HashSet<Integer>();
        for (int foundKind : found) {
            foundSet.add(foundKind);
        }
        for (int aKind : kind) {
            if (foundSet.contains(aKind)) {
                kindFreq[aKind - 1]++;
            }
        }

        return recurse(kindFreq, 0, K);
    }

    public static long binomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k > n - k) {    // take advantage of symmetry
            k = n - k;
        }
        long c = 1;
        for (int i = 1; i < k + 1; ++i) {
            c = c * (n - (k - i));
            c = c / i;
        }
        return c;
    }

    public static long recurse(int[] freq, int freqIndex, int K) {
        if (freqIndex >= freq.length) {
            return 0;
        }
        if (K < 0) {
            return 0;
        }
        // We need to make sure at least one of all of the found buildings is used.
        if (freq[freqIndex] > 0 && K == 0) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (dp[freqIndex][K] != -1) {
            return dp[freqIndex][K];
        }
        long sum = 0;
        if (freq[freqIndex] > 0) {
            for (int i = 1; i <= freq[freqIndex]; i++) {
                int remainder = K - i;
                long choose = binomial(freq[freqIndex], i);
                long curr = choose * recurse(freq, freqIndex + 1, remainder);
                sum += curr;
            }
            dp[freqIndex][K] = sum;
            return sum;
        } else {
            return recurse(freq, freqIndex + 1, K);
        }
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 1, 1, 2, 3, 4, 3, 2, 2}, new int[]{4,2}, 3));
    }
}
