package com.aaditya.topcoder.div1.srm587;

public class JumpFurther {
    public static int furthest(int N, int badStep) {
        int max = N * (N + 1) / 2;
        if (badStep <= max) {
            if (isTriangle(badStep)) {
                return max - 1;
            } else {
                return max;
            }
        } else {
            return max;
        }
    }

    public static boolean isTriangle(int N) {
        int K = (int) Math.sqrt(N * 2);
        for (int i = K - 2; i <= K + 2; i++) {
            if (i * (i + 1) / 2 == N) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(furthest(1, 757065));
    }
}
