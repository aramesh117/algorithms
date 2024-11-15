package com.aaditya.leetcode.problems.problem1650;

import java.util.HashSet;

class Solution {
    public static Node lowestCommonAncestor(Node p, Node q) {
        // Create lineage path for p, and add to set.
        var pLineage = new HashSet<Integer>();
        while (p != null) {
            pLineage.add(p.val);
            p = p.parent;
        }

        // Then while creating lineage path for q, check, including itself, whether it's in the set, and if so, then it's the LCA
        while (q != null) {
            boolean added = pLineage.add(q.val);
            if (!added) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}