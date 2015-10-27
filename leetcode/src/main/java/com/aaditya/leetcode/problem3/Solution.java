package com.aaditya.leetcode.problem3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastPosition = new HashMap<>();
        if(s.length() == 0) {
            return 0;
        }
        int maxLengthSoFar = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastPosition.containsKey(s.charAt(i))) {
                maxLengthSoFar = Math.max(maxLengthSoFar, i - lastPosition.get(s.charAt(i)));
                lastPosition.put(s.charAt(i), i);
                start = i;
            } else {
                maxLengthSoFar = Math.max(maxLengthSoFar, i - start + 1);
                lastPosition.put(s.charAt(i), i);
            }
        }
        return maxLengthSoFar;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aubbabcdef"));
    }
}

