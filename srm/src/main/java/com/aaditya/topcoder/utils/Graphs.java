package com.aaditya.topcoder.utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Utility methods for performing functions on graphs.
 */
public class Graphs {
    /**
     * If graph[i][j] is nonzero, there exists an edge with weight graph[i][j]. Directed graphs are accepted.
     *
     * @param graph A square adjacency matrix.
     *
     * @return The number of connected components.
     */
    public static int numConnectedComponents(int[][] graph) {
        int n = graph.length;
        for (int[] row : graph) {
            assert (row.length == n);
        }
        int numConnectedComponents = 0;
        boolean[] visited = new boolean[n];
        while (hasUnvisitedNode(visited)) {
            int startNode = findFirstUnvisitedNode(visited);
            System.out.printf("Starting with node %d.\n", startNode);
            visited = bfs(graph, visited, startNode);
            numConnectedComponents++;
        }
        return numConnectedComponents;
    }

    public static boolean hasUnvisitedNode(boolean[] visited) {
        boolean hasUnvisited = true;
        for (boolean node : visited) {
            hasUnvisited = hasUnvisited && node;
        }
        return !hasUnvisited;
    }

    public static int findFirstUnvisitedNode(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Assumes that graph[i][i] == 0 so no self loops.
     */
    public static boolean[] bfs(int[][] graph, boolean[] visited, int startNode) {
        int n = graph.length;
        boolean[] visitedTemp = Arrays.copyOf(visited, n);
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        bfsQueue.push(startNode);
        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            System.out.printf("Visiting node %d.\n", current);
            visitedTemp[current] = true;
            // Get non-visited neighbors of current.
            for (int i = 0; i < n; i++) {
                if ((graph[current][i] > 0) && !visitedTemp[i]) {
                    bfsQueue.add(i);
                }
            }
        }
        return visitedTemp;
    }

    public static boolean[] dfs(int[][] graph, boolean[] visited, int startNode) {
        int n = graph.length;
        boolean[] visitedTemp = Arrays.copyOf(visited, n);
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        bfsQueue.push(startNode);
        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.pop();
            System.out.printf("Visiting node %d.\n", current);
            visitedTemp[current] = true;
            // Get non-visited neighbors of current.
            for (int i = 0; i < n; i++) {
                if ((graph[current][i] > 0) && !visitedTemp[i]) {
                    bfsQueue.push(i);
                }
            }
        }
        return visitedTemp;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                new int[]{0, 1, 0, 0, 1},
                new int[]{1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 1},
                new int[]{1, 0, 0, 1, 0}
        };
        System.out.println(numConnectedComponents(graph));
    }
}
