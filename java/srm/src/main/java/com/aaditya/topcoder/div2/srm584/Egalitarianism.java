package com.aaditya.topcoder.div2.srm584;

public class Egalitarianism {
    public static int MAX = 1 << 20;

    public static int maxDifference(String[] isFriend, int d) {
        // Find all-pairs shortest paths and look at the maximum.
        // If any of the shortest paths is infinite, then return -1.
        int[][] shortestPath = new int[isFriend.length][isFriend.length];
        for (int i = 0; i < isFriend.length; i++) {
            for (int j = 0; j < isFriend.length; j++) {
                if (isFriend[i].charAt(j) == 'Y') {
                    shortestPath[i][j] = 1;
                } else {
                    if (j == i) {
                        shortestPath[i][j] = 0;
                    } else {
                        shortestPath[i][j] = MAX;
                    }
                }
            }
        }
        // i to j through k
        for (int k = 0; k < isFriend.length; k++) {
            for (int i = 0; i < isFriend.length; i++) {
                for (int j = 0; j < isFriend.length; j++) {
                    if (shortestPath[i][k] + shortestPath[k][j] < shortestPath[i][j]) {
                        shortestPath[i][j] = shortestPath[i][k] + shortestPath[k][j];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < isFriend.length; i++) {
            for (int j = 0; j < isFriend.length; j++) {
                max = Math.max(shortestPath[i][j], max);
            }
        }
        return max == MAX ? -1 : d * max;
    }
}
