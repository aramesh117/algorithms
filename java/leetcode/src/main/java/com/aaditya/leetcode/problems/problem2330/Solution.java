package com.aaditya.leetcode.problems.problem2330;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().makePalindrome("aaaxxx"));
        System.out.println(new Solution().makePalindrome("abccyz"));
        System.out.println(new Solution().makePalindrome(""));
        System.out.println(new Solution().makePalindrome("a"));
        System.out.println(new Solution().makePalindrome("aa"));
    }

    public boolean makePalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        if (isPalindrome(s)) {
            return true;
        }
        int numSwaps = 2;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (numSwaps > 0) {
                    i++;
                    j--;
                    numSwaps--;
                } else {
                    return false;
                }
            }
        }
        return numSwaps == 0 || numSwaps == 1;
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