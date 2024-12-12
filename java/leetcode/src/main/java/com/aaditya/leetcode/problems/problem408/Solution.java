package com.aaditya.leetcode.problems.problem408;

class Solution {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int m = word.length(), n = abbr.length();
        while (i < m && j < n) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (abbr.charAt(j) == '0') {
                return false;
            } else if (Character.isDigit(abbr.charAt(j))) {
                int k = j;
                while (k < n && Character.isDigit(abbr.charAt(k))) k++;
                int numChars = Integer.parseInt(abbr.substring(j, k));
                i += numChars;
                j = k;
            } else {
                return false;
            }
        }
        return i == m && j == n;
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
        System.out.println(validWordAbbreviation("end", "e1d"));
        System.out.println(validWordAbbreviation("end", "e111"));
    }
}