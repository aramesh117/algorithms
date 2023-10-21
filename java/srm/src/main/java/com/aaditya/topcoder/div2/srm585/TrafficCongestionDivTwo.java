package com.aaditya.topcoder.div2.srm585;

import java.util.Arrays;

public class TrafficCongestionDivTwo {
    private static long[] dp = new long[61];
    public static long theMinCars(int treeHeight) {
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        if (dp[treeHeight] != -1) {
            return dp[treeHeight];
        } else {
            for (int i = 4; i <= treeHeight; i++) {
                long numCars = 0;
                for (int j = 0; j <= i - 2; j++) {
                    numCars += dp[j];
                }
                dp[i] = 2 * numCars + 1;
            }
            return dp[treeHeight];
        }
    }

    public static void main(String[] args) {
        System.out.println(theMinCars(60));
    }
}
