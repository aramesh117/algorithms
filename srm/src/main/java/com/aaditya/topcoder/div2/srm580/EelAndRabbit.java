package com.aaditya.topcoder.div2.srm580;

public class EelAndRabbit {
    public static int getmax(int[] l, int[] t) {
        int maxEels = 0;
        for (int x = 0; x < t.length; x++) {
            int interval1 = t[x];
            for (int y = 0; y <= x; y++) {
                int interval2 = t[y];
                int numEels = 0;
                for (int i = 0; i < t.length; i++) {
                    int start = t[i], end = t[i] + l[i];
                    boolean containsX = interval1 >= start && interval1 <= end;
                    boolean containsY = interval2 >= start && interval2 <= end;
                    if (containsX || containsY) {
                        numEels++;
                    }
                }
                maxEels = Math.max(numEels, maxEels);
            }
        }
        return maxEels;
    }

    public static void main(String[] args) {
        System.out.println(getmax(new int[]{1}, new int[]{1}));
    }
}

