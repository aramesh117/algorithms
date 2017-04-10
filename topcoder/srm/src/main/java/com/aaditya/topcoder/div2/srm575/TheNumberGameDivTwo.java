package com.aaditya.topcoder.div2.srm575;

import java.util.Arrays;

public class TheNumberGameDivTwo {
    public static String find(int n) {
        // 0 is a loss for the first player, 1 is a win.
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    if (dp[i - j] == 0) {
                        dp[i] = 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] == 1 ? "John" : "Brus";
    }

    public static void main(String[] args) {
        System.out.println(find(1000));
    }
}
