package com.aaditya.euler;

public class Problem33 {
    public static void main(String[] args) {
        int denomProd = 1;
        int numProd = 1;
        // Num
        for (int i = 10; i < 99; i++) {
            // Denom
            for (int j = i + 1; j <= 99; j++) {
                float canceled = (float) (i / 10) / ((float) (j % 10));
                float original = (float) (i) / (float) j;
                if (Math.abs(canceled - original) < 1.0e-6) {
                    if (i % 10 == j / 10) {
                        System.out.println(String.format("%d/%d", i, j));
                        numProd *= i;
                        denomProd *= j;
                    }
                }
            }
        }
        System.out.println((float) numProd / (float) denomProd);
    }
}
