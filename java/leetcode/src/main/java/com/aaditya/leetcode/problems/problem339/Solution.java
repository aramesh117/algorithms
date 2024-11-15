package com.aaditya.leetcode.problems.problem339;

import java.util.ArrayDeque;
import java.util.List;

class Solution {
    record DFSElement(int depth, NestedInteger nestedInteger) {
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            var stack = new ArrayDeque<DFSElement>();
            stack.push(new DFSElement(1, nestedInteger));
            while (!stack.isEmpty()) {
                DFSElement current = stack.pop();
                if (current.nestedInteger.isInteger()) {
                    sum += current.nestedInteger.getInteger() * current.depth;
                } else {
                    for (NestedInteger integer : current.nestedInteger.getList()) {
                        stack.push(new DFSElement(current.depth + 1, integer));
                    }
                }
            }
        }
        return sum;
    }
}