//package com.aaditya.leetcode.problems.problem336;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Solution {
//    public List<List<Integer>> palindromePairs(String[] words) {
//        Map<String, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            indexMap.put(words[i], i);
//        }
//
//        for (String word : words) {
//            // Find the center of a palindrome if possible and expand outwards until it's no longer a palindrome or
//            // we hit a boundary.
//            // If we hit a boundary, find the reverse of the string on the side that is not at a boundary.
//            for (int center = 1; center < 2 * word.length() - 1; center++) {
//                int l;
//                int r;
//                if (center % 2 == 0) {
//                    l = center/2;
//                    r = center/2 + 1;
//                } else {
//                    l = center / 2 - 1;
//                    r = center / 2 + 1;
//                }
//
//                while (l >= 0 && r < word.length() - 1 && word.charAt(l) == word.charAt(r)) {
//                    l--;
//                    r++;
//                }
//
//                if (l != 0 && r != word.length() - 1) {
//                    // Not a palindrome, so continue.
//                    continue;
//                }
//            }
//        }
//    }
//}
