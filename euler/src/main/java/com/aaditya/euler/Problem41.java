package com.aaditya.euler;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem41 {
    public static void main(String[] args) {
        long max = Long.MIN_VALUE;
        for (int i = 9; i >= 1; i--) {
            String perm = "";
            for (int j = 1; j <= i; j++) {
                perm += j;
            }
            char[] perm2 = getNextPermutation(perm.toCharArray());
            while (!Arrays.equals(perm.toCharArray(), perm2)) {
                System.out.printf("Testing %s\n", new String(perm2));
                if (isPrime(Long.parseLong(new String(perm2)))) {
                    max = Math.max(max, Long.parseLong(new String(perm2)));
                }
                perm2 = getNextPermutation(perm2);
            }
        }
    }

    public static boolean isPrime(long a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static char[] getNextPermutation(char[] a) {
        char[] b = Arrays.copyOf(a, a.length);
        int i = b.length - 1;
        while (i > 0 && b[i - 1] > b[i]) {
            i--;
        }
        if (i == 0) {
            // Last permutation when the entire suffix is in descending order.
            Arrays.sort(b);
            return b;
        }
        int pivot = i - 1;
        i = b.length - 1;
        while (b[i] < b[pivot]) {
            i--;
        }

        if (i == b.length) {
            i = b.length - 1;
        }
        char temp = b[i];
        b[i] = b[pivot];
        b[pivot] = temp;
        Arrays.sort(b, pivot + 1, b.length);
        return b;
    }

}
