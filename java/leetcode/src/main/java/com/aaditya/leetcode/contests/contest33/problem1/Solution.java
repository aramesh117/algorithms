package com.aaditya.leetcode.contests.contest33.problem1;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Solution {
    public static int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        NavigableMap<Integer, Integer> frequencies = new TreeMap<>();
        for (int num : nums) {
            if (!frequencies.containsKey(num)) {
                frequencies.put(num, 1);
            } else {
                frequencies.put(num, frequencies.get(num) + 1);
            }
        }
        if (frequencies.size() == 1) {
            return 0;
        }
        int maxAdjacentPair = 0;
        Iterator<Integer> iterator = frequencies.navigableKeySet().iterator();
        int firstInt = iterator.next();
        int maxFirst = firstInt;
        for (int i = 0; i < frequencies.size() - 1; i++) {
            int secondInt = iterator.next();
            if (secondInt - firstInt > 1) {
                firstInt = secondInt;
                continue;
            }
            int total = frequencies.get(firstInt) + frequencies.get(secondInt);
            if (maxAdjacentPair < total) {
                maxAdjacentPair = total;
                maxFirst = firstInt;
            }
            firstInt = secondInt;
        }

        // None of the adjacent pairs have difference of 1.
        if (maxAdjacentPair > 0) {
            // Find the two integers, and gather all integers that are equal to either.
            int optFirst = maxFirst;
            int optSecond = frequencies.higherKey(optFirst);
            int sum = 0;
            for (int num : nums) {
                if (num == optFirst || num == optSecond) {
                    sum++;
                }
            }
            return sum;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 5, 7}));
    }
}
