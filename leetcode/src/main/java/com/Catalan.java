package com;

import java.util.HashMap;
import java.util.Map;

public class Catalan {
    private static final Map<Integer, Integer> dp = new HashMap<>();

    static {
        dp.put(0, 1);
        dp.put(1, 1);
    }

    public static int catalan(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += catalan(i) * catalan(n - 1 - i);
        }

        dp.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(catalan(5));
    }
}
