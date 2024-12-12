package com.aaditya.leetcode.contests.contest425.problem2;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleToRearrange("abcd", "cdab", 2));
        System.out.println(new Solution().isPossibleToRearrange("dawdawwadwad", "waddawdawdaw", 4));
        System.out.println(new Solution().isPossibleToRearrange("abcd", "acdb", 2));
        System.out.println(new Solution().isPossibleToRearrange("abcd", "acdb", 2));
    }

    public boolean isPossibleToRearrange(String s, String t, int k) {
        var substrings = new ArrayList<String>();
        int lengthPerSubstring = s.length() / k;
        for (int i = 0; i < k; i++) {
            substrings.add(s.substring(i * lengthPerSubstring, (i + 1) * lengthPerSubstring));
        }

        Collections.sort(substrings);

        var destSubstrings = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            destSubstrings.add(t.substring(i * lengthPerSubstring, (i + 1) * lengthPerSubstring));
        }

        Collections.sort(destSubstrings);

        return substrings.equals(destSubstrings);
    }
}