package com.aaditya.leetcode.problems.problem3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("aubb"));
//        System.out.println(lengthOfLongestSubstring("fffa"));
//        System.out.println(lengthOfLongestSubstring("aubf"));
//        System.out.println(lengthOfLongestSubstring("aubfbbabcdefghijk"));
        System.out.println(lengthOfLongestSubstring("abcdefghiiiiabcdefghijklmnopqrstuvwxyz"));
//        System.out.println(lengthOfLongestSubstring("aab"));
//        System.out.println(lengthOfLongestSubstring("abba"));
//        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}

