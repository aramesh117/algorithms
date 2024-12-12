package com.aaditya.leetcode.problems.problem973;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][]{{1, 2}, {1, 1}}, 1)));
    }

    public int[][] kClosest(int[][] points, int k) {
        var pointQueue = new PriorityQueue<>(Comparator.comparing((Point point1) -> -point1.distance()));
        for (int[] point : points) {
            pointQueue.offer(new Point(point[0], point[1]));
            if (pointQueue.size() > k) {
                pointQueue.poll();
            }
        }


        var result = new ArrayList<Point>();
        while (!pointQueue.isEmpty()) {
            result.add(pointQueue.poll());
        }
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = new int[]{result.get(i).x, result.get(i).y};
        }
        return finalResult;
    }

    record Point(int x, int y) {

        int distance() {
            return x * x + y * y;
        }

    }
}