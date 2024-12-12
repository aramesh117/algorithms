package com.aaditya.leetcode.problems.problem680;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abba"));
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s.substring(i + 1, j + 1)) || isPalindrome(s.substring(i, j));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}