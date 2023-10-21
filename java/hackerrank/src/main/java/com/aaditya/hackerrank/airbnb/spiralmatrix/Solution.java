package com.aaditya.hackerrank.airbnb.spiralmatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static List<Integer> getSpiral(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        // Turn right everytime we reach out of bounds or have visited a node already.
        Direction currDir = Direction.E;
        int row = 0;
        int col = 0;
        List<Integer> path = new ArrayList<>();
        path.add(matrix[row][col]);
        visited[row][col] = true;
        while (true) {
            while (canMove(visited, row, col, currDir)) {
                // Next move
                switch (currDir) {
                    case N:
                        row--;
                        break;
                    case S:
                        row++;
                        break;
                    case W:
                        col--;
                        break;
                    case E:
                        col++;
                        break;
                }
                visited[row][col] = true;
                path.add(matrix[row][col]);
            }
            // If cannot move anywhere, then break.
            if (!isValid(visited, row, col - 1) && !isValid(visited, row, col + 1) && !isValid(visited, row + 1, col) && !isValid(visited, row - 1, col)) {
                break;
            } else {
                // Pivot right
                switch (currDir) {
                    case N:
                        currDir = Direction.E;
                        break;
                    case S:
                        currDir = Direction.W;
                        break;
                    case W:
                        currDir = Direction.N;
                        break;
                    case E:
                        currDir = Direction.S;
                        break;
                }
            }
        }
        return path;
    }

    public static boolean isValid(boolean[][] visited, int row, int col) {
        return !(row >= visited.length || row < 0 || col >= visited[0].length || col < 0 || visited[row][col]);
    }

    public static boolean canMove(boolean[][] visited, int row, int col, Direction direction) {
        switch (direction) {
            case N:
                return row - 1 >= 0 && !visited[row - 1][col];
            case S:
                return row + 1 < visited.length && !visited[row + 1][col];
            case W:
                return col - 1 >= 0 && !visited[row][col - 1];
            case E:
                return col + 1 < visited[0].length && !visited[row][col + 1];
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] line = scanner.nextLine().split(",");
            int rows = Integer.parseInt(line[0]);
            int columns = Integer.parseInt(line[1]);

            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                line = scanner.nextLine().split(",");
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
//            System.out.println(Arrays.deepToString(matrix));
            List<Integer> path = getSpiral(matrix);
            System.out.println(path.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
    }


    public enum Direction {
        N, S, W, E
    }
}
