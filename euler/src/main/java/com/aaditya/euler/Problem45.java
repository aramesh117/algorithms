package com.aaditya.euler;

public class Problem45 {

    public static long nextCommon(int startingHexagonal) {
        for (int i = startingHexagonal; i < startingHexagonal + 100000; i++) {
            long n = i * (2 * i - 1);
            if (isPentagonal(n) && isTriangular(n)) {
                return n;
            }
        }
        return -1;
    }

    public static boolean isPentagonal(long n) {
        long start = (long) Math.sqrt(2.0 * n / 3.0);
        for (long i = start - 2; i <= start + 2; i++) {
            if (i * (3 * i - 1) == 2 * n) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTriangular(long n) {
        for (long i = (long) Math.sqrt(2 * n) - 2; i <= (long) Math.sqrt(2 * n) + 2; i++) {
            if (i * (i + 1) == 2 * n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(nextCommon(144));
    }
}
