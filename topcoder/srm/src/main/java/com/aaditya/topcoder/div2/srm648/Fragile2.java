package com.aaditya.topcoder.div2.srm648;

import java.util.ArrayDeque;
import java.util.Deque;

//500
// Algorithm:
// Brute force find all pairs of nodes, find the number of connected components in the graph after they are removed,
// and increment a counter if the number of connected components increases. Since the maximum input that they will give
// is quite small, this solution works but is quite stupid.
public class Fragile2 {
    public static int countPairs(String[] graph) {
        int numPairs = 0;
        int N = graph.length;
        int numCC = getNumConnectedComponents(graph);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String[] newGraph = getGraphAfterRemoval(graph, i, j);
                int newNumCC = getNumConnectedComponents(newGraph);
                if (newNumCC > numCC) {
                    numPairs++;
                }
            }
        }
        return numPairs;
    }

    public static String[] getGraphAfterRemoval(String[] graph, int i, int j) {
        String[] newGraph = new String[graph.length - 2];
        int index = 0;
        for (int k = 0; k < graph.length; k++) {
            if (k == i || k == j) {
                continue;
            }
            newGraph[index] = graph[k].substring(0, i) + graph[k].substring(i + 1, j) + graph[k].substring(j + 1);
            index++;
        }
        return newGraph;
    }

    public static int getNumConnectedComponents(String[] graph) {
        boolean[] visited = new boolean[graph.length];
        int numConnected = 0;
        while (!allVisited(visited)) {
            int firstUnvisited = getFirstUnvisited(visited);
            doBfs(graph, visited, firstUnvisited);
            numConnected++;
        }
        return numConnected;
    }

    public static boolean allVisited(boolean[] visited) {
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    public static int getFirstUnvisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return i;
        }
        return -1;
    }

    public static void doBfs(String[] graph, boolean[] visited, int start) {
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(start);
        while (!bfsQueue.isEmpty()) {
            int curr = bfsQueue.poll();
            String neighbors = graph[curr];
            for (int i = 0; i < neighbors.length(); i++) {
                if (neighbors.charAt(i) == 'Y' && !visited[i]) {
                    bfsQueue.push(i);
                }
            }
            visited[curr] = true;
        }
    }
}
