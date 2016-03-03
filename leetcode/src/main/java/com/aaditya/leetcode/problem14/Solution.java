package com.aaditya.leetcode.problem14;
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length > 0) {
            String longest = strs[0];
            for (int i = 1; i < strs.length; i++) {
                longest = findLongestCommonPrefix(longest, strs[i]);
            }
            return longest;
        } else {
            return "";
        }
    }

    public static String findLongestCommonPrefix(String a, String b) {
        if (a.length() < b.length()) {
            int i;
            for (i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    break;
                }
            }
            return a.substring(0, i);
        } else {
            int i;
            for (i = 0; i < b.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    break;
                }
            }
            return a.substring(0, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abcd", "", "abc"}));
    }
}
