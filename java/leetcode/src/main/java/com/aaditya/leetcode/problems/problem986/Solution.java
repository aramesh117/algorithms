package com.aaditya.leetcode.problems.problem986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


class Solution {
    enum EventType {
        START(0), END(1);

        private final int i;

        EventType(int i) {
            this.i = i;
        }
    }

    record Event(int pos, EventType type) {
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<Event> events = new ArrayList<>();
        for (int[] event : firstList) {
            events.add(new Event(event[0], EventType.START));
            events.add(new Event(event[1], EventType.END));
        }
        for (int[] event : secondList) {
            events.add(new Event(event[0], EventType.START));
            events.add(new Event(event[1], EventType.END));
        }
        events.sort(Comparator.comparingInt((Event value) -> value.pos).thenComparingInt(value -> value.type.i));
        if (events.isEmpty()) {
            return new int[][]{};
        }
        ArrayList<int[]> merged = new ArrayList<>();
        int depth = 0;
        int currentIntervalStart = 0;
        for (Event event : events) {
            if (event.type == EventType.START) {
                depth++;
                if (depth == 2) {
                    currentIntervalStart = event.pos;
                }
            } else {
                depth--;
                if (depth == 1) {
                    merged.add(new int[]{currentIntervalStart, event.pos});
                }
            }
        }
        int[][] ints = new int[merged.size()][2];
        return merged.toArray(ints);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().intervalIntersection(new int[][]{{0, 2}, {5, 10}}, new int[][]{{1, 2}, {6, 9}})));
        System.out.println(Arrays.deepToString(new Solution().intervalIntersection(new int[][]{{0, 1}}, new int[][]{{0, 0}, {1, 5}})));
    }
}