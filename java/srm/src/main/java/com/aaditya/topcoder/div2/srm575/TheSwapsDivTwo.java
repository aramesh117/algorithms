package com.aaditya.topcoder.div2.srm575;

public class TheSwapsDivTwo {
    public static int find(int[] sequence) {
        int unique = 0;
        boolean firstSwap = true;
        for (int i = 0; i < sequence.length; i++) {
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] != sequence[j]) {
                    unique++;
                } else if (firstSwap) {
                    unique++;
                    firstSwap = false;
                }
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{1,1}));
    }
}
