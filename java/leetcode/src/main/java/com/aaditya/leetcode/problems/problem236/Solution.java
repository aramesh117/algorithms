package com.aaditya.leetcode.problems.problem236;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = findPathToNode(root, p, new ArrayList<>());
        List<TreeNode> pathToQ = findPathToNode(root, q, new ArrayList<>());
        // Iterate until we find one that diverges between the two lists.
        int i = 0;
        while (i < pathToQ.size() && i < pathToP.size() && pathToP.get(i) == pathToQ.get(i)) {
            i++;
        }
        return pathToQ.get(i - 1);
    }

    public static List<TreeNode> findPathToNode(TreeNode root, TreeNode dest, List<TreeNode> accum) {
        while (true) {
            List<TreeNode> newList = new ArrayList<>(accum);
            newList.add(root);
            if (Objects.equals(root, dest)) {
                return newList;
            }
            // Dead end
            if (root.right == null && root.left == null) {
                return null;
            }
            // Only left branch available
            if (root.right == null) {
                accum = newList;
                root = root.left;
            } else if (root.left == null) { // Only right branch available
                accum = newList;
                root = root.right;
            } else {
                // Get results of both branches and return the one that is not null if any
                List<TreeNode> leftRes = findPathToNode(root.left, dest, newList);
                List<TreeNode> rightRes = findPathToNode(root.right, dest, newList);
                if (leftRes == null && rightRes == null) {
                    return null;
                } else if (leftRes == null) {
                    return rightRes;
                } else {
                    return leftRes;
                }
            }
        }
    }

//    public static void main(String[] args) {
////        TreeNode t1 = new TreeNode(1, null, null);
////        TreeNode t2 = new TreeNode(2, t1, null);
////        TreeNode t5 = new TreeNode(5, null, null);
////        TreeNode t6 = new TreeNode(6, null, null);
////        TreeNode t4 = new TreeNode(4, t5, t6);
////        TreeNode t3 = new TreeNode(3, t2, t4);
////        System.out.println(lowestCommonAncestor(t3, t3, t3).val);
//    }
}
