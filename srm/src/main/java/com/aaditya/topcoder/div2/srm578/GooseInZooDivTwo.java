package com.aaditya.topcoder.div2.srm578;

public class GooseInZooDivTwo {
    public static int MOD = 1000000007;

    public static int count(String[] field, int dist) {
        // Each connected component is called a group. If the group has at least one goose, the entire group must be full of goose.
        // Otherwise, it's full of ducks.
        // Therefore, the total number of sets of geese is 2^{num groups} % MOD.
        // First find the number of groups using bfs.
        boolean[][] visited = new boolean[field.length][field[0].length()];
        int numConnectedComponents = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length(); j++) {
                if (field[i].charAt(j) == 'v' && !visited[i][j]) {
                    numConnectedComponents++;
                    explore(visited, i, j, field, dist);
                }
            }
        }
        if (numConnectedComponents > 0) {
            return (twoPowerMod(numConnectedComponents) - 1 + MOD) % MOD;
        } else {
            return 0;
        }
    }

    public static int twoPowerMod(int n) {
        assert n >= 1;
        int cum = 1;
        for (int i = 0; i < n; i++) {
            long temp = (long) cum << 1;
            cum = (int) (temp % MOD);
        }
        return cum;
    }

    public static void explore(boolean[][] visited, int x, int y, String[] field, int dist) {
        int maxX = field.length;
        int maxY = field[0].length();
        visited[x][y] = true;
        for (int X = x - dist; X <= x + dist; X++) {
            for (int Y = y - dist; Y <= y + dist; Y++) {
                if (X >= 0 && X < maxX &&
                        Y >= 0 && Y < maxY &&
                        field[X].charAt(Y) == 'v' &&
                        abs(x - X) + abs(y - Y) <= dist
                        && !visited[X][Y]) {
                    explore(visited, X, Y, field, dist);
                }
            }
        }
    }

    public static int abs(int x) {
        return x < 0 ? -x : x;
    }
}
