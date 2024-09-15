package com.aaditya.leetcode.problems.problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Solution {
    private static List<List<Integer>> combinations = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates, target, new ArrayList<>(), 0);
        return combinations;
    }

    private static void bt(int[] candidates, int target, ArrayList<Integer> soFar, int soFarSum) {
        if (soFarSum == target) {
            combinations.add(new ArrayList<>(soFar));
        } else if (soFarSum < target) {
            for (int candidate : candidates) {
                if (soFar.isEmpty() || candidate >= soFar.getLast()) {
                    soFar.add(candidate);
                    bt(candidates, target, soFar, soFarSum + candidate);
                    soFar.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1}, 1));
        System.out.println(combinationSum(new int[]{1, 2, 3, 4, 5, 6}, 6));
        System.out.println(combinationSum(new int[]{2,3,5 }, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
    }
}
