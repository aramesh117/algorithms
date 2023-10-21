package com.aaditya.leetcode.problems.problem17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final Map<Character, List<Character>> DIGIT_MAPPINGS = new HashMap<>(10);

    static {
        DIGIT_MAPPINGS.put('1', new ArrayList<Character>());
        DIGIT_MAPPINGS.put('2', Arrays.asList('a', 'b', 'c'));
        DIGIT_MAPPINGS.put('3', Arrays.asList('d', 'e', 'f'));
        DIGIT_MAPPINGS.put('4', Arrays.asList('g', 'h', 'i'));
        DIGIT_MAPPINGS.put('5', Arrays.asList('j', 'k', 'l'));
        DIGIT_MAPPINGS.put('6', Arrays.asList('m', 'n', 'o'));
        DIGIT_MAPPINGS.put('7', Arrays.asList('p', 'q', 'r', 's'));
        DIGIT_MAPPINGS.put('8', Arrays.asList('t', 'u', 'v'));
        DIGIT_MAPPINGS.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        DIGIT_MAPPINGS.put('0', Collections.singletonList(' '));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = Collections.singletonList("");
        for (char digit : digits.toCharArray()) {
            List<String> intermediate = new ArrayList<>();
            for (String r : res) {
                for (char alph : DIGIT_MAPPINGS.get(digit)) {
                    intermediate.add(r + alph);
                }
            }
            res = intermediate;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
