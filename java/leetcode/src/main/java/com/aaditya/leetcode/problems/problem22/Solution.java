package com.aaditya.leetcode.problems.problem22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final Map<Integer, List<String>> cache = new HashMap<>();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return List.of("");
        }
        if (n == 1) {
            return List.of("()");
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> iParents = generateParenthesis(i);
            List<String> complements = generateParenthesis(n - 1 - i);
            for (String iParent : iParents) {
                for (String complement : complements) {
                    result.add(String.format("(%s)%s", iParent, complement));
                }
            }
        }
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(10));
    }
}



