package com.aaditya.leetcode.problems.problem3;

import java.util.HashSet;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueCharacters = new HashSet<>();
        int longest = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char headChar = s.charAt(j);
            if (!uniqueCharacters.contains(headChar)) {
                uniqueCharacters.add(headChar);
                longest = Math.max(longest, j - i + 1);
                j++;
            } else {
                char tailChar = s.charAt(i);
                uniqueCharacters.remove(tailChar);
                i++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aubb"));
        System.out.println(lengthOfLongestSubstring("fffa"));
        System.out.println(lengthOfLongestSubstring("aubf"));
        System.out.println(lengthOfLongestSubstring("aubfbbabcdefghijk"));
        System.out.println(lengthOfLongestSubstring("abcdefghiiiiabcdefghijklmnopqrstuvwxyz"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

