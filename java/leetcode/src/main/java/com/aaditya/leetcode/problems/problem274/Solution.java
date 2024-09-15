package com.aaditya.leetcode.problems.problem274;

import java.util.TreeMap;

public class Solution {
    public static int hIndex(int[] citations) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int citation : citations) {
            if (freq.containsKey(citation)) {
                freq.put(citation, freq.get(citation) + 1);
            } else {
                freq.put(citation, 1);
            }
        }

        // Descending order
        int numPapersWithCitationsGeq = 0;
        int maxHIndex = 0;
        for (var entry : freq.descendingMap().entrySet()) {
            Integer numCitations = entry.getKey();
            Integer numPapers = entry.getValue();
            if (numCitations < maxHIndex) {
                return maxHIndex;
            }
            numPapersWithCitationsGeq += numPapers;
            if (numPapersWithCitationsGeq >= numCitations) {
                return numCitations;
            }
            maxHIndex = Math.max(numPapersWithCitationsGeq, maxHIndex);
        }
        return maxHIndex;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 1}));
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[]{1, 5, 5, 6, 6}));
        System.out.println(hIndex(new int[]{5, 5, 6, 6}));
        System.out.println(hIndex(new int[]{1,2,3,4,5}));
        System.out.println(hIndex(new int[]{0}));
    }
}
