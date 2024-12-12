package com.aaditya.leetcode.problems.problem336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordToIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordToIndexMap.put(words[i], i);
        }
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // Case 1
            String reversed = reverse(word);
            if (wordToIndexMap.containsKey(reversed) && wordToIndexMap.get(reversed) != i) {
                result.add(List.of(i, wordToIndexMap.get(reversed)));
            }
            // Case 2
            for (String suffix : allValidSuffixes(word)) {
                if (wordToIndexMap.containsKey(reverse(suffix))) {
                    result.add(List.of(wordToIndexMap.get(reverse(suffix)), i));
                }
            }
            for (String prefix : allValidPrefixes(word)) {
                if (wordToIndexMap.containsKey(reverse(prefix))) {
                    result.add(List.of(i, wordToIndexMap.get(reverse(prefix))));
                }
            }
        }
        return result;
    }

    private List<String> allValidPrefixes(String word) {
        var result = new ArrayList<String>();
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word, i, word.length() - 1)) {
                result.add(word.substring(0, i));
            }
        }
        return result;
    }

    private List<String> allValidSuffixes(String word) {
        ArrayList<String> suffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                suffixes.add(word.substring(i + 1));
            }
        }
        return suffixes;
    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start <= end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}