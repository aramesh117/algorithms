package com.aaditya.leetcode.problems.problem56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        var events = new ArrayList<Event>();
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], Type.START));
            events.add(new Event(interval[1], Type.END));
        }
        events.sort(Comparator.comparingInt((Event value) -> value.pos).thenComparing(event -> event.type));
        var result = new ArrayList<List<Integer>>();
        int intervalNesting = 0;
        int currentIntervalStartPos = -1;
        for (Event event : events) {
            if (event.type == Type.START) {
                if (intervalNesting == 0) {
                    currentIntervalStartPos = event.pos;
                }
                intervalNesting++;
            } else {
                intervalNesting--;
                if (intervalNesting == 0) {
                    result.add(List.of(currentIntervalStartPos, event.pos));
                }
            }
        }
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = new int[]{result.get(i).getFirst(), result.get(i).get(1)};
        }
        return finalResult;
    }

    enum Type {
        START,
        END
    }

    record Event(int pos, Type type) {
    }

}
