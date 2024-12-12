package com.aaditya.leetcode.problems.problem767;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aaaaabbcde"));
        System.out.println(new Solution().reorganizeString("abcd"));
        System.out.println(new Solution().reorganizeString("aabbccdd"));
        System.out.println(new Solution().reorganizeString("aaaa"));
    }

    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(new int[]{-freq[i], i + 'a'});
            }
        }
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] nextChar = pq.poll();
            int nextCharCount = nextChar[0];
            int nextCharacter = nextChar[1];
            if (result.isEmpty() || result.charAt(result.length() - 1) != nextCharacter) {
                result.append((char) nextCharacter);
                if (nextCharCount + 1 < 0) {
                    pq.add(new int[]{nextCharCount + 1, nextCharacter});
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                int[] nextNextChar = pq.poll();
                int nextNextCharCount = nextNextChar[0];
                int nextNextCharacter = nextNextChar[1];
                result.append((char) (nextNextCharacter));
                // Add back next char
                pq.add(new int[]{nextCharCount, nextCharacter});
                if (nextNextCharCount + 1 < 0) {
                    pq.add(new int[]{nextNextCharCount + 1, nextNextCharacter});
                }
            }
        }
        return result.toString();
    }
}