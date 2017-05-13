package com.aaditya.leetcode.problem301;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        if (s.isEmpty() || isValid(s)) {
            return Collections.singletonList(s);
        }
        int numMinParentheses = s.length();
        Set<String> minimalParentheses = new HashSet<>();
        Set<String> visitedStrings = new HashSet<>();
        Queue<String> bfsQueue = new ArrayDeque<>(getAllNeighbors(s, visitedStrings));
        // Add all neighbors.
        while (!bfsQueue.isEmpty()) {
            String cur = bfsQueue.poll();
            visitedStrings.add(cur);
            if (!isValid(cur)) {
                // Add all neighbors to the
                for (String neighbor : getAllNeighbors(cur, visitedStrings)) {
                    if (!visitedStrings.contains(neighbor)) {
                        bfsQueue.add(neighbor);
                    }
                }
            } else {
                int numSteps = s.length() - cur.length();
                if (numSteps < numMinParentheses) {
                    minimalParentheses.clear();
                    numMinParentheses = numSteps;
                    minimalParentheses.add(cur);
                } else if (numSteps == numMinParentheses) {
                    minimalParentheses.add(cur);
                }
            }
        }
        return new ArrayList<>(minimalParentheses);
    }

    public static Set<String> getAllNeighbors(String s, Set<String> visitedNeighbors) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String n = s.substring(0, i) + s.substring(i + 1);
                if (!visitedNeighbors.contains(n)) {
                    set.add(n);
                }
            }
        }
        return set;
    }

    public static boolean isValid(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                i++;
            }
            if (s.charAt(j) == ')') {
                i--;
            }
            if (i < 0) {
                return false;
            }
        }
        return i <= 0;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("n"));
    }
}
