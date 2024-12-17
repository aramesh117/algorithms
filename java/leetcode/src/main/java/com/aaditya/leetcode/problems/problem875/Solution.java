package com.aaditya.leetcode.problems.problem875;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        runTest(1, new int[]{1, 1}, 100);
        runTest(1, new int[]{1, 1}, 2);
        runTest(2, new int[]{4, 8}, 6);
        runTest(3, new int[]{3, 9}, 6);
        runTest(5, new int[]{3, 9, 3}, 4);
        runTest(14, new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);
        runTest(14, new int[]{805306368, 805306368, 805306368}, 1000000000);
    }

    private static void runTest(int expected, int[] piles, int h) {
        int result = new Solution().minEatingSpeed(piles, h);
        if (expected != result) {
            System.out.printf("Failed! Expected %s for (%s, %s) but got %s%n%n", expected, Arrays.toString(piles), h, result);
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        long numBananas = 0;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            numBananas += pile;
            max = Math.max(max, pile);
        }
        if (numBananas <= h) {
            return 1;
        } else {
            // Binary search between 2 and max
            long low = Math.floorDiv(numBananas, h);
            long high = max;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                boolean canFinish = canFinish(piles, h, mid);
                boolean canFinishOneLess = canFinish(piles, h, mid - 1);
                if (canFinish && !canFinishOneLess) {
                    return (int) mid;
                } else if (canFinish) {
                    high = mid - 1;
                } else if (!canFinishOneLess) {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private boolean canFinish(int[] piles, int h, long k) {
        if (k == 0) {
            return false;
        }
        long numTurns = 0;
        for (int pile : piles) {
            numTurns += Math.ceilDiv(pile, k);
        }
        return numTurns <= h;
    }
}