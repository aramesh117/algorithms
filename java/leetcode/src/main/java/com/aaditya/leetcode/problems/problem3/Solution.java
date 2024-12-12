package com.aaditya.leetcode.problems.problem3;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("a"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcd"));
        System.out.println(new Solution().lengthOfLongestSubstring("aabcd"));
        System.out.println(new Solution().lengthOfLongestSubstring("abccab"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcbcefa"));
    }

    public int lengthOfLongestSubstring(String s) {
        var window = new HashSet<Character>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (!window.contains(s.charAt(i))) {
                window.add(s.charAt(i));
                maxLength = Math.max(maxLength, i - j + 1);
                i++;
            } else {
                window.remove(s.charAt(j));
                j++;
            }
        }
        return maxLength;
    }
}