package com.aaditya.leetcode.problems.problem207;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(4, new int[][]{{1, 3}, {2, 1}, {3, 1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjacency = new HashMap<Integer, List<Integer>>();
        var indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjacency.computeIfAbsent(prerequisite[1], ArrayList::new).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        ArrayDeque<Integer> sources = new ArrayDeque<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                sources.offer(i);
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (!sources.isEmpty()) {
            var source = sources.poll();
            result.add(source);

            for (int node : adjacency.getOrDefault(source, new ArrayList<>())) {
                indegrees[node]--;
                if (indegrees[node] == 0) {
                    sources.offer(node);
                }
            }
        }
        System.out.println(result);

        return result.size() == numCourses;
    }

}
