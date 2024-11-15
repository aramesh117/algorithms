package com.aaditya.leetcode.problems.problem1091;

import java.util.ArrayDeque;
import java.util.List;

class Solution2 {

    record NodeAndDepth(int x, int y, int depth) {
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        var bfs = new ArrayDeque<NodeAndDepth>();
        bfs.offer(new NodeAndDepth(0, 0, 1));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while (!bfs.isEmpty()) {
            NodeAndDepth current = bfs.poll();
            if (current.x == grid.length - 1 && current.y == grid[0].length - 1) {
                return current.depth;
            }

            List<Integer> offsets = List.of(-1, 0, 1);
            for (Integer xOffset : offsets) {
                for (Integer yOffset : offsets) {
                    if (xOffset == 0 && yOffset == 0) {
                        continue;
                    }
                    int X = current.x + xOffset;
                    int Y = current.y + yOffset;
                    if (X >= 0 && X < grid.length && Y >= 0 && Y < grid[0].length && grid[X][Y] == 0 && !visited[X][Y]) {
                        visited[X][Y] = true;
                        bfs.offer(new NodeAndDepth(X, Y, current.depth + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        }));
    }
}
