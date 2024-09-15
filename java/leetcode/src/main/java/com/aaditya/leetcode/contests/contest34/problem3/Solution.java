package com.aaditya.leetcode.contests.contest34.problem3;

import java.util.ArrayList;

class Solution {
    public static int maxOperations(String s) {
        if (s.length() < 2) {
            return 0;
        }
        var islands = new ArrayList<Integer>();
        char[] sArray = s.toCharArray();
        int currentRun = sArray[0] == '1' ? 1 : 0;
        for (int i = 0; i < sArray.length - 1; i++) {
            if (sArray[i + 1] == '1') {
                currentRun++;
                if (i + 1 == sArray.length - 1) {
                    islands.add(currentRun);
                }
            } else {
                if (currentRun > 0) {
                    islands.add(currentRun);
                }
                if (i + 1 == sArray.length - 1) {
                    islands.add(0);
                }
                currentRun = 0;
            }
        }
        System.out.println(islands);
        int numOperations = 0;
        int cumulative = 0;
        for (int i = 0; i < islands.size() - 1; i++) {
            cumulative += islands.get(i);
            numOperations += cumulative;
        }
        return numOperations;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations("01"));
        System.out.println(maxOperations("010000001"));
        System.out.println(maxOperations("1001101"));
        System.out.println(maxOperations("00111"));
        System.out.println(maxOperations("01010101"));
        System.out.println(maxOperations("011111111110101"));
    }
}

// 10001100101: [1,2,1,1] => [3,1,1] => [2,2,1] => [1,3,1] => [4,1] => [3,2] => [2,3] => [1,4] => [5] ====>
// 01010101: [1,1,1,1] => [2,1,1] => [1,2,1], [3,1] => [2,2],[1,3],[4]
