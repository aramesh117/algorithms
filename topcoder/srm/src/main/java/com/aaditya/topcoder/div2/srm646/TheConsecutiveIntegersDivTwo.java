package com.aaditya.topcoder.div2.srm646;

//250
public class TheConsecutiveIntegersDivTwo {
    public static int find(int[] numbers, int k) {
        if(k == 1) {
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                minDiff = Math.min(minDiff, Math.abs(numbers[i] - numbers[j]));
            }
        }
        return Math.max(0, minDiff - 1);
    }
}
