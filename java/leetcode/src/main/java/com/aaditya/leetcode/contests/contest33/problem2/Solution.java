package com.aaditya.leetcode.contests.contest33.problem2;

import java.util.Objects;

public class Solution {

    public static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Point point1 = new Point(p1[0], p1[1]);
        Point point2 = new Point(p2[0], p2[1]);
        Point point3 = new Point(p3[0], p3[1]);
        Point point4 = new Point(p4[0], p4[1]);
        if (Objects.equals(point1, point2) && Objects.equals(point2, point3) && Objects.equals(point3, point4)) {
            return false;
        }

        int onetwo = distance(point1, point2);
        int onethree = distance(point1, point3);
        int onefour = distance(point1, point4);

        if (onetwo == onethree && onefour == 2 * onetwo) {
            int twofour = distance(point2, point4);
            int threefour = distance(point3, point4);
            return twofour == onetwo && threefour == onetwo;
        }

        if (onethree == onefour && onetwo == 2 * onethree) {
            int twothree = distance(point2, point3);
            int twofour = distance(point2, point4);
            return twothree == twofour && twothree == onethree;
        }
        if (onetwo == onefour && onethree == 2 * onetwo) {
            int twothree = distance(point2, point3);
            int threefour = distance(point3, point4);
            return twothree == threefour && twothree == onetwo;
        }
        return false;
    }

    public static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
