package com.aaditya.leetcode.problems.problem130;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    record Location(int x, int y) {
    }

    public static void solve(char[][] board) {
        // Fill in all non-surrounded regions with a 'Z' and then fill in everything else, and then revert the Zs back to 0s.

        for (int j = 0; j < board[0].length; j++) {
            explore(board, 0, j);
        }
        for (int j = 0; j < board[0].length; j++) {
            explore(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            explore(board, i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            explore(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void explore(char[][] board, int x, int y) {
        if (!(board[x][y] == 'O')) {
            return;
        }
        ArrayDeque<Location> dfsStack = new ArrayDeque<>();
        dfsStack.push(new Location(x, y));
        while (!dfsStack.isEmpty()) {
            Location current = dfsStack.pop();
            x = current.x;
            y = current.y;
            board[x][y] = 'Z';
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                dfsStack.push(new Location(x - 1, y));
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                dfsStack.push(new Location(x, y - 1));
            }
            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                dfsStack.push(new Location(x + 1, y));
            }
            if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
                dfsStack.push(new Location(x, y + 1));
            }
        }
    }

    public static void main(String[] args) {
        run(new char[][]{
                {'O'}
        });

        run(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }

    private static void run(char[][] board) {
        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }
}