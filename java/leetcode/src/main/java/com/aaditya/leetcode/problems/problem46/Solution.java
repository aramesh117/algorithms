package com.aaditya.leetcode.problems.problem46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        return permuteList(numsList);
    }

    private static List<List<Integer>> permuteList(List<Integer> nums) {
        if (nums.isEmpty()) {
            return List.of();
        }
        if (nums.size() == 1) {
            return List.of(nums);
        }
        if (nums.size() == 2) {
            return List.of(List.of(nums.getFirst(), nums.get(1)), List.of(nums.get(1), nums.get(0)));
        }
        List<List<Integer>> n_1 = permuteList(nums.subList(1, nums.size()));
        Integer first = nums.getFirst();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (List<Integer> n_1_element : n_1) {
                ArrayList<Integer> resultElement = new ArrayList<>(n_1_element);
                resultElement.add(i, first);
                result.add(resultElement);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(permuteList(List.of(1, 2, 3, 4, 5, 6)).size());
    }
}