package com.aaditya.leetcode.problems.problem91;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<String, Integer> dp = new HashMap<>();

    public static int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            int value = Integer.parseInt(s);
            if (value > 0 && value <= 26) {
                dp.put(s, 1);
                return 1;
            } else {
                dp.put(s, 0);
                return 0;
            }
        }
        if (s.length() == 2) {
            if (Integer.parseInt(s) <= 26) {
                int res = 1;
                if (s.charAt(0) != '0' && s.charAt(1) != '0') {
                    res += 1;
                }
                dp.put(s, res);
                return res;
            } else {
                int res = 1;
                if (s.charAt(0) == '0' || s.charAt(1) == '0') {
                    res = 0;
                }
                dp.put(s, res);
                return res;
            }
        }
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        int res = numDecodings(s.substring(1));
        if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            res += numDecodings(s.substring(2));
        }
        dp.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings(""));
    }
}

