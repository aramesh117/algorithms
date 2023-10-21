package com.aaditya.euler;

public class Problem28 {
    public static void main(String[] args) {
        long sum = 1;
        int value = 1;
        for (int i = 3; i <= 1001; i += 2) {
            for (int j = 0; j < 4; j++) {
                value += i - 1;
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
