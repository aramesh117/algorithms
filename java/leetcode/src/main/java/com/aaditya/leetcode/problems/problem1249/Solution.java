package com.aaditya.leetcode.problems.problem1249;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> charsToRemove = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    charsToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        charsToRemove.addAll(stack);
        // Build final string
        var builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!charsToRemove.contains(i)) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("((())))"));
    }
}