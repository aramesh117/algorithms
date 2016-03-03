package com.aaditya.topcoder.div2.srm653;

public class RockPaperScissorsMagicEasy {
    public static int MOD = 1000000007;

    public static int count(int[] card, int score) {
        int N = card.length;
        int k = score;
        // (N C k) * (2^(N - k))
        if (k == N) {
            return 1;
        } else {
            if (k > N) {
                return 0;
            } else {
                long nck = nCk(N, k);
                long assignments = modPow(2, N - k, MOD);
                int res = (int) ((nck * assignments) % MOD);
                return res;
            }
        }
    }

    public static int nCk(int n, int k) {
        long num = 1;
        for (int i = n - k + 1; i <= n; i++) {
            num = (num * i) % MOD;
        }

        long denom = 1;
        for (int i = 1; i <= k; i++) {
            denom = (denom * i) % MOD;
        }

        long denomInverse = modInverse(denom, MOD);
        return (int) ((num * denomInverse) % MOD);
    }

    // Use 64 bits integers to avoid overflow errors during multiplication.
    public static long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while (x > 0) {
            if (x % 2 != 0) {
                res = (res * a) % p;
            }
            a = (a * a) % p;
            x /= 2;
        }
        return res;
    }

    public static long modInverse(long a, long p) {
        //calculates the modular multiplicative of a mod m.
        //(assuming p is prime).
        return modPow(a, p - 2, p);
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 7));
    }
}
