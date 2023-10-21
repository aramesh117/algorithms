package com.aaditya.leetcode.problems.problem253;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int minMeetingRooms(Interval[] intervals) {
        List<Event> eventList = new ArrayList<>();
        for (Interval i : intervals) {
            eventList.add(new Start(i.start));
            eventList.add(new End(i.end));
        }

        eventList.sort(Comparator.comparingInt(Event::time));
        int maxConcurrent = 0;
        int concurrent = 0;
        for (Event event : eventList) {
            if (event instanceof Start) {
                concurrent++;
            } else {
                concurrent--;
            }
            maxConcurrent = Math.max(concurrent, maxConcurrent);
        }
        return maxConcurrent;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(13, 15));
        intervals.add(new Interval(1, 13));
        Interval[] arr = intervals.toArray(new Interval[0]);
        System.out.println(minMeetingRooms(arr));
    }

    public interface Event {
        int time();
    }

    public static class Start implements Event {
        private final int time;

        public Start(int time) {
            this.time = time;
        }

        public int time() {
            return time;
        }
    }

    public static class End implements Event {
        public final int time;

        public End(int time) {
            this.time = time;
        }

        @Override
        public int time() {
            return time;
        }
    }
}
