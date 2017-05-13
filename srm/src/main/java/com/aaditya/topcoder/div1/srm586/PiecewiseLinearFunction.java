package com.aaditya.topcoder.div1.srm586;

public class PiecewiseLinearFunction {
    public static int maximumSolutions(int[] Y) {
        for (int i = 1; i < Y.length; i++) {
            if (Y[i] == Y[i - 1]) {
                return -1;
            }
        }

        // For each of the different Y values, get the number of solutions for y + 1 and y - 1 and keep a running max.
        int maxSolutions = Integer.MIN_VALUE;
        for (int i = 0; i < Y.length; i++) {
            for (double j = -0.5; j < 1; j += 0.5) {
                double y = Y[i] + j;
                int numSolutions = 0;
                // Find number of intersections of y with Y.
                if (Math.abs(y - Y[0]) < 1.0e-6) {
                    numSolutions++;
                }
                for (int k = 1; k < Y.length; k++) {
                    if (y > Y[k - 1] && y <= Y[k] || y < Y[k - 1] && y >= Y[k]) {
                        numSolutions++;
                    }
                }
                maxSolutions = Math.max(maxSolutions, numSolutions);
            }
        }
        return maxSolutions;
    }

    public static void main(String[] args) {
        int[] Y = {-999999999, 1000000000, -1000000000, 1000000000, -999999999};
        System.out.println(maximumSolutions(Y));
    }
}
