package com.aaditya.leetcode.problems.problem77;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    private static List<List<Integer>> combinations = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<>();
        bt(n, k, new ArrayList<>(), 1);
        return combinations;
    }

    private static void bt(int n, int k, ArrayList<Integer> soFar, int currentIndex) {
        if (currentIndex > n) {
            return;
        }
        if (soFar.size() == k) {
            combinations.add(new ArrayList<>(soFar));
            return;
        }
        if (soFar.size() + (n - currentIndex + 1) < k) {
            // Not enough remaining elements to make k-size combination
            return;
        }
        if (soFar.size() + (n - currentIndex + 1) == k) {
            ArrayList<Integer> newCombo = new ArrayList<>(soFar);
            newCombo.addAll(IntStream.rangeClosed(currentIndex, n).boxed().toList());
            combinations.add(newCombo);
            return;
        }
        // Include currentIndex and move to the next
        soFar.add(currentIndex);
        bt(n, k, soFar, currentIndex + 1);
        soFar.removeLast();

        // Do not include currentIndex and move on
        bt(n, k, soFar, currentIndex + 1);

    }

    public static void main(String[] args) {
        System.out.println(combine(5, 2));
    }
}
