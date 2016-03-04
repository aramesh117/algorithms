package com.aaditya.leetcode.problem22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.singletonList("");
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> A = generateParenthesis(i);
            List<String> B = generateParenthesis(n - 1 - i);
            for (String a : A) {
                for (String b : B) {
                    res.add("(" + a + ")" + b);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
}

