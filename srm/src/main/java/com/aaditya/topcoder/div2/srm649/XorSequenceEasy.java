package com.aaditya.topcoder.div2.srm649;

public class XorSequenceEasy {
    public static int getmax(int[] A, int N) {
        int numBits = Integer.bitCount(N - 1);
        int[][] largestBitCounts = new int[numBits][2];
        // Count the number of pairs.
        for (int j = 0; j < A.length; j++) {
            for (int k = j + 1; k < A.length; k++) {
                for (int i = numBits - 1; i >= 0; i--) {
                    if ((A[j] >> i & 1) != (A[k] >> i & 1)) {
                        largestBitCounts[i][A[j] >> i & 1]++;
                        break;
                    }
                }
            }
        }
        int total = 0;
        for (int i = 0; i < numBits; i++) {
            total += Math.max(largestBitCounts[i][0], largestBitCounts[i][1]);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(getmax(new int[]{3, 2, 1, 0, 3, 2}, 4));
    }
}
