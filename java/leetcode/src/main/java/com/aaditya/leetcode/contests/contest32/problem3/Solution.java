package com.aaditya.leetcode.contests.contest32.problem3;

public class Solution {

    public static int longestCommonSubstring(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static int minDistance(String word1, String word2) {
        // First find the longest common subsequence, and then find the number of characters that must be deleted
        // from each of the original strings.
        int lcs = longestCommonSubstring(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("a", "abcd"));
    }
}
