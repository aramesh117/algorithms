package com.aaditya.codefights;

public class ProductExceptSelf {
    public static int productExceptSelf(int[] nums, int m) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % m;
        }
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product = (product * nums[j]) % m;
                }
            }
            f[i] = product;
        }
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum = (sum + f[i]) % m;
        }
        return sum;
    }
}
