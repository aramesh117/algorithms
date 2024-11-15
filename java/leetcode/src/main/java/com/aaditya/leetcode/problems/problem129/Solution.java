package com.aaditya.leetcode.problems.problem129;

import java.util.Objects;

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }

    private int dfs(TreeNode root, String prefix) {
        if (root.right == null && root.left == null) {
            return Integer.parseInt(prefix + root.val);
        } else if (root.right != null && root.left != null) {
            return dfs(root.left, prefix + root.val) + dfs(root.right, prefix + root.val);
        } else return dfs(Objects.requireNonNullElseGet(root.right, () -> root.left), prefix + root.val);
    }
}