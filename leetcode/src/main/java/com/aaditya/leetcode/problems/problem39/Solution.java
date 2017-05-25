package com.aaditya.leetcode.problems.problem39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Solution {
    private static final Map<Integer, Set<List<Integer>>> dp = new HashMap<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dp.put(0, new HashSet<List<Integer>>());
        Set<List<Integer>> list = dp.get(target);
        if (list == null) {
            Set<List<Integer>> res = new HashSet<>();
            for (int i : candidates) {
                int newTarget = target - i;
                if (newTarget > 0) {
                    List<List<Integer>> subList = combinationSum(candidates, newTarget);
                    List<List<Integer>> newList = new ArrayList<>(subList);
                    for (List<Integer> l : newList) {
                        List<Integer> temp = new ArrayList<>(l);
                        temp.add(i);
                        Collections.sort(temp);
                        res.add(temp);
                    }
                } else if (newTarget == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    res.add(temp);
                }
            }
            dp.put(target, res);
            return new ArrayList<>(res);
        } else {
            return new ArrayList<>(list);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1}, 1));
    }
}
