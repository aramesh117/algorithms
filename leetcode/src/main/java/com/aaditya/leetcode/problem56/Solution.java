package com.aaditya.leetcode.problem56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        Comparator<Interval> comparator = Comparator.comparingInt(o -> o.start);
        intervals.sort(comparator);
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (i.start > end) {
                res.add(new Interval(start, end));
                start = i.start;
                end = Math.max(end, i.end);
            } else {
                end = Math.max(i.end, end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

//    public static void main(String[] args) {
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 1));
//        intervals.add(new Interval(0, 0));
//        intervals.add(new Interval(2, 2));
//        System.out.println(merge(intervals));
//    }
}
