package com.aaditya.leetcode.problems.problem127;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);
        // Construct graph with edges
        var adj = new HashMap<String, List<String>>();
        for (String s : wordList) {
            for (String s1 : wordList) {
                if (!Objects.equals(s, s1) && numDiffCharacters(s1, s) == 1) {
                    adj.computeIfAbsent(s, _ -> new ArrayList<>()).add(s1);
                    adj.computeIfAbsent(s1, _ -> new ArrayList<>()).add(s);
                }
            }
        }

        var queue = new ArrayDeque<BfsEntry>();
        var visited = new HashSet<String>();
        queue.offer(new BfsEntry(beginWord, 1));
        while (!queue.isEmpty()) {
            BfsEntry entry = queue.poll();
            visited.add(entry.word);
            if (Objects.equals(entry.word, endWord)) {
                return entry.level;
            } else {
                for (String neighbor : adj.getOrDefault(entry.word, List.of())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(new BfsEntry(neighbor, entry.level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private int numDiffCharacters(String s1, String s) {
        int numDiffs = 0;
        char[] charArray1 = s1.toCharArray();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray1[i]) {
                numDiffs++;
            }
        }
        return numDiffs;
    }

    record BfsEntry(String word, int level) {
    }
}