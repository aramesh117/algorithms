package com.aaditya.leetcode.problems.problem621;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        System.out.println(Arrays.toString(freq));
        int maxFreq = freq[25] - 1;
        int idleTasks = maxFreq * n;
        for (int i = freq.length - 2; i >= 0; i--) {
            idleTasks -= Math.min(maxFreq, freq[i]);
        }
        if (idleTasks > 0) {
            return tasks.length + idleTasks;
        } else {
            return tasks.length;
        }
    }
    // ABCDABCD
}
