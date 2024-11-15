package com.aaditya.leetcode.problems.problem71;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> pathStack = new ArrayDeque<>();
        for (String pe : Arrays.stream(path.split("/")).filter(e -> !e.isBlank()).toList()) {
            if (pe.equals(".")) {
                // Ignore
            } else if (pe.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(pe);
            }
        }
        return "/" + String.join("/", pathStack.reversed());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/hello/abcd/../.../xyz"));
        System.out.println(new Solution().simplifyPath("/"));
        System.out.println(new Solution().simplifyPath("/./"));
        System.out.println(new Solution().simplifyPath("/./."));
        System.out.println(new Solution().simplifyPath("///////x/.."));
        System.out.println(new Solution().simplifyPath("/a/../b"));
    }
}