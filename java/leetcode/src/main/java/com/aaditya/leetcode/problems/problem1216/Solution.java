package com.aaditya.leetcode.problems.problem1216;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidPalindrome("abcdeca", 2));
        System.out.println(new Solution().isValidPalindrome("abbababa", 1));
        System.out.println(new Solution().isValidPalindrome("cabcabbbbaddddacdaaabdabaaddcdcadcbbaddddacacbcbcdbacadccbbabbbbbdccbbcddcbcbcccbccbadbdcddbbdcbbccbcddcbacacdabcdcccadadacddcbcddbcbadbdddbbbacbddccddcbaadaadadddaccaddabcbaabdbcdaadbcbdacdadbbdbaabaaaabdaadbadbbdcb", 216));
    }

    public boolean isValidPalindrome(String s, int k) {
        byte[][][] dp = new byte[s.length() + 1][s.length() + 1][s.length() + 1];
        // 0 = not initialized
        // 1 = possible
        // 2 = not possible
        return isValidPalindrome(s, k, dp, 0, s.length() - 1);
    }

    private boolean isValidPalindrome(String s, int k, byte[][][] dp, int i, int j) {
        if (dp[i][j][k] == 1) {
            return true;
        } else if (dp[i][j][k] == 2) {
            return false;
        }
        if (k == 0) {
            return isPalindrome(s.substring(i, j + 1));
        }
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                boolean deleteAtI = isValidPalindrome(s, k - 1, dp, i + 1, j);
                boolean deleteAtJ = isValidPalindrome(s, k - 1, dp, i, j - 1);
                boolean result = deleteAtI || deleteAtJ;
                if (result) {
                    dp[i][j][k] = 1;
                } else {
                    dp[i][j][k] = 2;
                }
                return result;
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
