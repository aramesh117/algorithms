package com.aaditya.topcoder.div2.srm647;

public class PeacefulLine {

    public static String makeLine(int[] x) {
        int n = x.length;
        int[] ages = new int[26];
        for (int i = 0; i < n; i++) {
            ages[x[i]]++;
        }
        int max = Integer.MIN_VALUE;
        for (int age : ages) {
            if (age > max) {
                max = age;
            }
        }
        System.out.println(max);
        if (n % 2 == 0) {
            if (max > n / 2) {
                return "impossible";
            } else {
                return "possible";
            }
        } else {
            if (max > n / 2 + 1) {
                return "impossible";
            } else {
                return "possible";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(makeLine(new int[]{1,1,1,2}));
    }
}
