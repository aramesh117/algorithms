package com.aaditya.leetcode.problems.problem1347;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("bab", "aba"));
    }

    public int minSteps(String s, String t) {
        char[] sArray = new char[26];
        char[] tArray = new char[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(sArray[i] - tArray[i]);
        }
        return diff / 2;
    }
}