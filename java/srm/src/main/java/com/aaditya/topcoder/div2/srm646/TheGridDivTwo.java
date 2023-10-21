package com.aaditya.topcoder.div2.srm646;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//500
public class TheGridDivTwo {

    public static void doBfsWithLimitK(int xStart, int yStart, Set<Point> visited, Set<Point> blocked, int k) {
        Point start = new Point(xStart, yStart, 0);
        Deque<Point> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(start);
        visited.add(start);
        while (!bfsQueue.isEmpty()) {
            Point curr = bfsQueue.poll();
            if (curr.time > k) {
                break;
            }
            if (curr.time < k) {
                Point[] neighbors = {
                    new Point(curr.x - 1, curr.y, curr.time + 1),
                    new Point(curr.x, curr.y - 1, curr.time + 1),
                    new Point(curr.x, curr.y + 1, curr.time + 1),
                    new Point(curr.x + 1, curr.y, curr.time + 1)
                };
                for (Point neighbor : neighbors) {
                    if (!visited.contains(neighbor) && !blocked.contains(neighbor)) {
                        bfsQueue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static int find(int[] x, int[] y, int k) {
        Set<Point> blocked = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            blocked.add(new Point(x[i], y[i], 0));
        }
        Set<Point> visited = new HashSet<>();
        doBfsWithLimitK(0, 0, visited, blocked, k);

        int maxX = Integer.MIN_VALUE;
        for (Point visitedPoint : visited) {
            maxX = Math.max(maxX, visitedPoint.x);
        }
        return maxX;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{},
            new int[]{},
            1000));
    }

    public static class Point {
        public final int x;
        public final int y;
        public final int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean equals(Object other) {
            return other instanceof Point && ((Point) other).x == this.x && ((Point) other).y == this.y;
        }

        public int hashCode() {
            return 191 * x + 193 * y;
        }

        public String toString() {
            return "(" + x + "," + y + "," + time + ")";
        }
    }
}
