package com.aaditya.leetcode.problems.problem437;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        System.out.println(new Solution().pathSum(root, 1));
        System.out.println(new Solution().pathSum(root, 2));
        System.out.println(new Solution().pathSum(root, 4));
        System.out.println(new Solution().pathSum(root, 6));

    }

    public int pathSum(TreeNode root, int targetSum) {
        return pathSumCumulative(root, targetSum, List.of(), 0);
    }

    private int pathSumCumulative(TreeNode root, int targetSum, List<TreeNode> path, long cumulativeSum) {
        if (root == null) {
            return 0;
        }

        ArrayList<TreeNode> newPath = new ArrayList<>(path);
        newPath.add(root);

        int numPaths = 0;
        long tmp = targetSum;
        for (int i = newPath.size() - 1; i >= 0; i--) {
            tmp -= newPath.get(i).val;
            if (tmp == 0) {
                numPaths++;
            }
        }

        return numPaths + pathSumCumulative(root.left, targetSum, newPath, cumulativeSum + root.val) + pathSumCumulative(root.right, targetSum, newPath, cumulativeSum + root.val);
    }

}