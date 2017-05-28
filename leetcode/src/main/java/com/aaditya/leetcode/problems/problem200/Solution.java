package com.aaditya.leetcode.problems.problem200;

public class Solution {
    public static void main(String[] args) {
        char[][] grid = {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        };
        System.out.println(numIslands(grid));
    }

    public static void explore(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        // Up
        explore(grid, x - 1, y);
        // Left
        explore(grid, x, y - 1);
        // Down
        explore(grid, x + 1, y);
        // Right
        explore(grid, x, y + 1);
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }
}
