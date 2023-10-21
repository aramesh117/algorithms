package com.aaditya.hackerrank.airbnb.jumpingjack;

public class Solution {
    public static int maxStep(int n, int k) {
        if (isTriangular(k)) {
            return n * (n + 1) / 2 - 1;
        } else {
            return n * (n + 1) / 2;
        }
    }

    public static boolean isTriangular(int k) {
        for (int i = 0; i <= k; i++) {
            if (i * (i + 1) / 2 == k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxStep(5, 3));
    }
}

