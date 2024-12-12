package com.aaditya.leetcode.problems.problem269;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new Solution().alienOrder(new String[]{"z", "x"}));
        System.out.println(new Solution().alienOrder(new String[]{"z", "x", "z"}));
        System.out.println(new Solution().alienOrder(new String[]{"z", "z"}));
        System.out.println(new Solution().alienOrder(new String[]{"a", "b", "bcc"}));
        System.out.println(new Solution().alienOrder(new String[]{"a"}));
        System.out.println(new Solution().alienOrder(new String[]{"axc", "x"}));
        System.out.println(new Solution().alienOrder(new String[]{"aaa", "aab"}));
        System.out.println(new Solution().alienOrder(new String[]{"ac", "ab", "zc", "zb"}));
        System.out.println(new Solution().alienOrder(new String[]{"abc", "ab"}));
    }

    public String alienOrder(String[] words) {
        var orderGraph = new HashMap<Character, Set<Character>>();
        for (int i = 0; i < words[0].length(); i++) {
            orderGraph.putIfAbsent(words[0].charAt(i), new HashSet<>());
        }
        for (int i = 1; i < words.length; i++) {
            if ((!words[i - 1].equals(words[i])) && words[i - 1].startsWith(words[i])){
                return "";
            }
            addEdge(words[i - 1], words[i], orderGraph);
        }

        int[] inDegrees = new int[26];
        Arrays.fill(inDegrees, -1);

        int numTotalCharacters = 0;
        for (Character key : orderGraph.keySet()) {
            inDegrees[key - 'a'] = 0;
            numTotalCharacters++;
        }

        for (var entry : orderGraph.entrySet()) {
            for (Character c : entry.getValue()) {
                inDegrees[c - 'a']++;
            }
        }

        var queue = new ArrayDeque<Character>();
        for (int i = 0; i < 26; i++) {
            if (inDegrees[i] == 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Character currSource = queue.poll();
            result.append(currSource);

            for (Character neighbor : orderGraph.getOrDefault(currSource, Set.of())) {
                int newDegree = --inDegrees[neighbor - 'a'];
                if (newDegree == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (numTotalCharacters != result.length())
            return "";

        return result.toString();
    }

    private void addEdge(String first, String second, Map<Character, Set<Character>> orderGraph) {
        for (int i = 0; i < first.length(); i++) {
            orderGraph.putIfAbsent(first.charAt(i), new HashSet<>());
        }
        for (int i = 0; i < second.length(); i++) {
            orderGraph.putIfAbsent(second.charAt(i), new HashSet<>());
        }
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            if (firstChar != secondChar) {
                orderGraph.get(firstChar).add(secondChar);
                return;
            }
        }
    }
}