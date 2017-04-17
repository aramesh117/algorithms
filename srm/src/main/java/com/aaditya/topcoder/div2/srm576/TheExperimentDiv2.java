package com.aaditya.topcoder.div2.srm576;

import java.util.Arrays;

public class TheExperimentDiv2 {
    public static int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {
        int[] ret = new int[leftEnd.length];
        for (int i = 0; i < leftEnd.length; i++) {
            for (int j = leftEnd[i]; j < leftEnd[i] + L; j++) {
                ret[i] += intensity[j];
                intensity[j] = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(determineHumidity(new int[]{5,5}, 2, new int[]{0, 0})));
    }
}
