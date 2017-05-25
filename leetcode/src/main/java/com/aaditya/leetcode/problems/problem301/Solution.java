package com.aaditya.leetcode.problems.problem301;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        if (isValid(s)) {
            return Collections.singletonList(s);
        }
        int numMinParentheses = s.length();
        Set<String> minimalParentheses = new HashSet<>();
        Set<String> visitedStrings = new HashSet<>();
        Queue<String> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(s);
        // Add all neighbors.
        boolean isFound = false;
        while (!bfsQueue.isEmpty()) {
            String cur = bfsQueue.poll();
            visitedStrings.add(cur);
            if (!isValid(cur)) {
                if (isFound) {
                    // If we found a valid string, we don't add any more neighbors - we just finish up the current
                    // level.
                    continue;
                }
                // Add all neighbors
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        String n = cur.substring(0, i) + cur.substring(i + 1);
                        if (!visitedStrings.contains(n)) {
                            bfsQueue.add(n);
                            visitedStrings.add(n);
                        }
                    }
                }
            } else {
                int numSteps = s.length() - cur.length();
                if (!isFound) {
                    numMinParentheses = numSteps;
                    isFound = true;
                }
                if (numSteps == numMinParentheses) {
                    minimalParentheses.add(cur);
                }
            }
        }
        return new ArrayList<>(minimalParentheses);
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
        removeInvalidParentheses("()(((((((()").forEach(s -> System.out.println('"' + s + '"'));
    }
}
