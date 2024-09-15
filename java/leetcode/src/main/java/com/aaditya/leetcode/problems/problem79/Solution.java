package com.aaditya.leetcode.problems.problem79;

class Solution {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (n == 0 || word.isEmpty()) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, int i, int j, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[i][j] = true;
        return bt(board, i, j, word, visited);
    }

    private static boolean bt(char[][] board, int i, int j, String remainingWord, boolean[][] visited) {
        if (remainingWord.equals(board[i][j] + "")) {
            return true;
        }
        if (remainingWord.charAt(0) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = false;
        if (i - 1 >= 0 && !visited[i - 1][j] && board[i - 1][j] == remainingWord.charAt(1)) {
            found |= bt(board, i - 1, j, remainingWord.substring(1), visited);
        }
        if (i + 1 < board.length && !visited[i + 1][j] && board[i + 1][j] == remainingWord.charAt(1)) {
            found |= bt(board, i + 1, j, remainingWord.substring(1), visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && board[i][j - 1] == remainingWord.charAt(1)) {
            found |= bt(board, i, j - 1, remainingWord.substring(1), visited);
        }
        if (j + 1 < board[0].length && !visited[i][j + 1] && board[i][j + 1] == remainingWord.charAt(1)) {
            found |= bt(board, i, j + 1, remainingWord.substring(1), visited);
        }
        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCEFSADEESE"));
        System.out.println(exist(new char[][]{
                {'A', 'A'}
        }, "AAA"));
    }
}