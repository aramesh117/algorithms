package com.aaditya.topcoder.div2.srm653;

public class CountryGroup {
    public static int solve(int[] a) {
        int i = 0;
        int numCountries = 0;
        while (i < a.length) {
            int curCountry = a[i];
            int j = i;
            while (j < i + curCountry) {
                if (j == a.length || a[j] != curCountry) {
                    return -1;
                }
                j++;
            }
            numCountries++;
            i = i + curCountry;
        }
        return numCountries;
    }

    public static void main(String[] args) {
        System.out.println(CountryGroup.solve(new int[]{2,2,3,3,3,3}));
    }
}
