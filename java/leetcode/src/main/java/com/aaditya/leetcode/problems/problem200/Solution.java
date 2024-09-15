package com.aaditya.leetcode.problems.problem200;

import java.util.ArrayDeque;

class Solution {
    record Location(int x, int y) {
    }

    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private static void exploreIsland(char[][] grid, int i, int j) {
        ArrayDeque<Location> dfsQueue = new ArrayDeque<>();
        dfsQueue.push(new Location(i, j));
        while (!dfsQueue.isEmpty()) {
            var current = dfsQueue.pop();
            i = current.x;
            j = current.y;
            grid[i][j] = '0';
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                dfsQueue.push(new Location(i - 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                dfsQueue.push(new Location(i, j - 1));
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                dfsQueue.push(new Location(i + 1, j));
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                dfsQueue.push(new Location(i, j + 1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0'},
                {'1', '0', '1'}
        }));
    }
}