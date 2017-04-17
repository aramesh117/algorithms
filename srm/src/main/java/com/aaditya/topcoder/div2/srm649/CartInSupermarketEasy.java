package com.aaditya.topcoder.div2.srm649;

import java.util.Arrays;

public final class CartInSupermarketEasy {
    private static final int[][] memo = new int[101][101];

    static {
        for (int i = 0; i < 101; i++) {
            Arrays.fill(memo[i], -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(calc(45, 5));
    }

    public static int calc(int N, int K) {
        if (memo[N][K] != -1) {
            return memo[N][K];
        }
        if(N == 0) {
            memo[N][K] = 0;
            return 0;
        }
        if(K <= 0) {
            memo[N][K] = N;
            return N;
        }
        int withoutDivision;
        if (K > 0) {
            withoutDivision = 1 + calc(N - 1, K);
        } else {
            withoutDivision = Integer.MAX_VALUE;
        }
        int withDivision = Integer.MAX_VALUE;
        for (int x = 1; x < N; x++) {
            for (int y = 0; y < K; y++) {
                int tempWithDivision = 1 + Math.max(calc(x, y), calc(N - x, K - 1 - y));
                withDivision = Math.min(tempWithDivision, withDivision);
            }
        }
        memo[N][K] = Math.min(withoutDivision, withDivision);
        return memo[N][K];
    }
}
