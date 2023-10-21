package com.aaditya.leetcode.problems.problem340;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        int best = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            countMap.compute(s.charAt(right), (character, integer) -> {
                if (integer == null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            });
            if (countMap.size() > k) {
                // Move the left to the right until the number of distinct characters is less than or equal to k.
                while (countMap.size() > k) {
                    char leftChar = s.charAt(left);
                    countMap.compute(leftChar, (character, integer) ->
                    {
                        if (integer != null) {
                            if (integer == 1) {
                                return null;
                            } else {
                                return integer - 1;
                            }
                        } else {
                            return null;
                        }
                    });
                    left++;
                }
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
