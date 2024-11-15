package com.aaditya.leetcode.problems.problem36;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> columnSets = new HashMap<>(9);
        Map<Integer, Set<Character>> rowSets = new HashMap<>(9);
        Map<Integer, Set<Character>> squareSets = new HashMap<>(9);

        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    boolean added = columnSets.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j]);
                    if (!added) {
                        return false;
                    }
                    added = rowSets.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j]);
                    if (!added) {
                        return false;
                    }
                    int I = i / 3;
                    int J = j / 3;
                    added = squareSets.computeIfAbsent(3 * I + J, k -> new HashSet<>()).add(board[i][j]);
                    if (!added) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}