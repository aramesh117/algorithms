package com.aaditya.leetcode.contests.contest34.problem4;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Solution {
    /**
     * Explanation: We want the diff between nums and target to be 0. Call the diff array D. Using the subarray
     * increment/decrement operation for [l,r] on nums will affect D in the following way:
     * <p>
     * D[l] += 1 and D[r + 1] -+ 1.
     * <p>
     * The cool insight is this: Since the problem isn't asking about the exact subarray operations, we don't really
     * care about the _end_ of the subarray operation. This is because when incrementing, we can just assume that it
     * will span until right before the next value that's lower than the current increment level, or the end. The only
     * thing that we really care about is the number of operations at the beginning of the subarray.
     * <p>
     * With this, we can generate the layman algorithm:
     * <pre>
     * {@code
     * D = diff of target - nums
     * total_operations = 0
     *
     *  for i in 1..D.length-1:
     *      if sgn(D[i - 1]) != sgn(D[i]):
     *          # This means we can't rely on any existing subarray level, we need to start over for this segment.
     *          total_operations += abs(D[i])
     *  else:
     *      total_operations += abs(D[i]) - abs(D[i - 1])
     *  return total_operations
     * }
     * </pre>
     */
    public static long minimumOperations(int[] nums, int[] target) {
        long[] D = new long[nums.length];
        D[0] = target[0] - nums[0];
        long numOperations = abs(D[0]);
        for (int i = 1; i < D.length; i++) {
            D[i] = target[i] - nums[i];
            if (signum(D[i]) == signum(D[i - 1])) {
                numOperations += max(abs(D[i]) - abs(D[i - 1]), 0);
            } else {
                numOperations += abs(D[i]);
            }
        }
        return numOperations;
    }

    private static byte signum(long u) {
        if (u == 0) {
            return 0;
        } else if (u < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 3, 2}, new int[]{2, 1, 4}));
    }
}