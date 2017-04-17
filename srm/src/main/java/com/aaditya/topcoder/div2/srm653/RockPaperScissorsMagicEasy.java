package com.aaditya.topcoder.div2.srm653;

public class RockPaperScissorsMagicEasy {
    public static int MOD = 1000000007;

    public static final int count(int[] card, int score) {
        if (score > card.length || score < 0) {
            return 0;
        }

        long powerTwoPart = twoPowerMod(card.length - score);
        long chooseNum = multiplyMod(card.length - score + 1, card.length);
        int chooseDen = getInverse(multiplyMod(1, score), MOD);
        return (int) ((((powerTwoPart * chooseNum) % MOD ) * chooseDen) % MOD);
    }

    public static int twoPowerMod(int n) {
        assert n >= 1;
        int cum = 1;
        for (int i = 0; i < n; i++) {
            long temp = (long) cum << 1;
            cum = (int) (temp % MOD);
        }
        return cum;
    }

    public static int multiplyMod(int a, int b) {
        assert a <= b;
        int cum = 1;
        for (int i = a; i <= b; i++) {
            long temp = (long) cum * i;
            cum  = (int) (temp % MOD);
        }
        return cum;
    }

    public static final int getInverse(int a, int n) {
        int t = 0, newT = 1;
        int r = n, newR = a;
        while (newR != 0) {
            int quotient = r / newR;
            int tempNewT = newT;
            newT = t - quotient * newT;
            t = tempNewT;
            int tempNewR = newR;
            newR = r - quotient * newR;
            r = tempNewR;
        }
        if (r > 1) {
            throw new RuntimeException("a is not invertible.");
        }
        if (t < 0) {
            return n + t;
        }
        return t;
    }

    public static void main(String[] args) {
    }
}
