package com.aaditya.leetcode.contests.contest34.problem2;

class Solution {
    public static boolean doesAliceWin(String s) {
        int numVowels = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVowels++;
            }
        }
        return numVowels != 0;
    }

    public static void main(String[] args) {
        assert doesAliceWin("leetcoder");
        assert !doesAliceWin("bbcd");
        assert doesAliceWin("e");
        assert !doesAliceWin("");
        assert doesAliceWin("vvee");
    }
}
