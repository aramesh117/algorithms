package com.aaditya.topcoder.div2.srm653;

/**
 * Created by aramesh on 2/28/16.
 */
public class CountryGroup {

    public static int solve(int[] a) {
        int j = 0;
        int numCountries = 0;
        int first = a[0];
        while (j < a.length) {
            int streakLength = 0;
            first = a[j];
            // While the streak is continuing
            try {
                while (streakLength < first && first == a[j]) {
                    j++;
                    streakLength++;
                }
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return -1;
            }
            if (first != streakLength) {
                return -1;
            }
            numCountries++;
        }
        return numCountries;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,1,2,2,1,2}));
    }
}
