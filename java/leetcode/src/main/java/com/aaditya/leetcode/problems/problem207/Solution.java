package com.aaditya.leetcode.problems.problem207;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjacency = new HashMap<Integer, HashSet<Integer>>(numCourses);
        for (int[] prerequisite : prerequisites) {
            int destination = prerequisite[0];
            adjacency.computeIfAbsent(destination, k -> new HashSet<>()).add(prerequisite[1]);
        }
        HashSet<Integer> completedCourses = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            for (int classNum = 0; classNum < numCourses; classNum++) {
                HashSet<Integer> prereqForClass = adjacency.computeIfAbsent(classNum, k -> new HashSet<>());
                if (prereqForClass.isEmpty()) {
                    completedCourses.add(classNum);
                } else {
                    prereqForClass.removeAll(completedCourses);
                    if (prereqForClass.isEmpty()) {
                        completedCourses.add(classNum);
                    }
                }
            }
        }
        return completedCourses.size() == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(5, new int[][]{{1, 3}, {2, 1}, {3, 1}}));
    }
}