package com.aaditya.leetcode.problems.problem207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Solution().canFinish(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(new Solution().canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjList = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] inDegrees = new int[numCourses];
        for (var entry : adjList.entrySet()) {
            for (var after : entry.getValue()) {
                ++inDegrees[after];
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        ArrayList<Object> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var source = queue.poll();
            result.add(source);
            var next = adjList.get(source);
            for (Integer neighbor : next) {
                int newDegree = --inDegrees[neighbor];
                if (newDegree == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result.size() == numCourses;
    }
}