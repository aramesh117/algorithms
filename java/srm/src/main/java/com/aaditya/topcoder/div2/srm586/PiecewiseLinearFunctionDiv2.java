package com.aaditya.topcoder.div2.srm586;

public class PiecewiseLinearFunctionDiv2 {
    public static int[] countSolutions(int[] Y, int[] query) {
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int val = query[i];
            int numSolutions = 0;
            // Initial solution, so that the other intervals can be exclusive, inclusive.
            if (val == Y[0]) {
                numSolutions++;
            }
            for (int j = 1; j < Y.length; j++) {
                // Infinite solutions if the value is equal to both of the points.
                if (val == Y[j - 1] && Y[j - 1] == Y[j]) {
                    numSolutions = -1;
                    break;
                }
                if (val > Y[j - 1] && val <= Y[j] || val < Y[j - 1] && val >= Y[j]) {
                    numSolutions++;
                }
            }
            res[i] = numSolutions;
        }
        return res;
    }
}
