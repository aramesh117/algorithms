package com.aaditya.leetcode.problems.problem408;

class Solution {
    public static boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        String number = "";
        while (i < abbr.length()) {
            var currentChar = abbr.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                if (!number.isBlank()) {
                    var numberParsed = Integer.parseInt(number);
                    builder.append("*".repeat(Math.max(0, numberParsed)));
                }
                builder.append(currentChar);
                number = "";
            } else {
                number += currentChar;
            }
            i++;
        }
        if (!number.isBlank()) {
            var numberParsed = Integer.parseInt(number);
            builder.append("*".repeat(Math.max(0, numberParsed)));
        }
        if (builder.length() != word.length()) {
            return false;
        }
        String constructed = builder.toString();
        for (int j = 0; j < word.length(); j++) {
            if (constructed.charAt(j) != '*' && constructed.charAt(j) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i5a11o1"));
    }
}