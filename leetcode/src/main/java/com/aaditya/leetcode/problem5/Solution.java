package com.aaditya.leetcode.problem5;

public class Solution {
    // The possible centers can be from 0 -> 2*s.length - 1, where if center c = 2 * j, then the center is between'
    // the characters j - 1 and j, and if c = 2 * j + 1, then it is the character j.

    public static String findLargestPalindromeFromCenter(int c, String s) {
        String pal = "";
        if (c % 2 == 0) {
            // Center is between two characters.
            int j = c / 2;
            int l = j - 1;
            int u = j;
            int bestl = -1;
            int bestu = -1;
            while (l >= 0 && u < s.length()) {
                if (s.charAt(l) == s.charAt(u)) {
                    bestl = l;
                    bestu = u;
                    l--;
                    u++;
                } else {
                    break;
                }
            }
            if (bestl != -1 && bestu != -1) {
                pal = s.substring(bestl, bestu + 1);
            }
        } else {
            int j = (c - 1) / 2;
            int l = j - 1;
            int u = j + 1;
            int bestl = -1;
            int bestu = -1;
            while (l >= 0 && u < s.length()) {
                if (s.charAt(l) == s.charAt(u)) {
                    bestl = l;
                    bestu = u;
                    l--;
                    u++;
                } else {
                    break;
                }
            }
            if (bestl != -1 && bestu != -1) {
                pal = s.substring(bestl, bestu + 1);
            }
        }
        return pal;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String longest = "";
        int longestLen = Integer.MIN_VALUE;
        for(int i = 0; i <= 2 * s.length() + 1; i++) {
            String longestPalindrome = findLargestPalindromeFromCenter(i, s);
            if(longestPalindrome.length() > longestLen) {
                longest = longestPalindrome;
                longestLen = longestPalindrome.length();
            }
        }
        return longest;
    }
}
