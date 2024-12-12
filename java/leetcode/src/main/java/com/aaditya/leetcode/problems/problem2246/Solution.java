package com.aaditya.leetcode.problems.problem2246;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
    }

    public int longestPath(int[] parent, String s) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int parentOfI = parent[i];
            char currentCharacter = s.charAt(i);
            TreeNode currentNode = map.computeIfAbsent(i, v -> {
                var node = new TreeNode();
                node.val = v;
                return node;
            });
            currentNode.character = currentCharacter;
            if (parentOfI == -1)
                continue;
            TreeNode parentNode = map.computeIfAbsent(parentOfI, v -> {
                var node = new TreeNode();
                node.val = v;
                return node;
            });
            parentNode.character = s.charAt(parentOfI);
            if (parentNode.right == null) {
                parentNode.right = currentNode;
            } else if (parentNode.left == null) {
                parentNode.left = currentNode;
            }
        }
        TreeNode root = map.get(0);
        PathOutput pathOutput = longestPath(root);
        return Math.max(pathOutput.longestPath, pathOutput.partialFromRoot);
    }

    private PathOutput longestPath(TreeNode root) {
        // Three cases:
        // Longest path in left
        // Longest path in right
        // Longest path including current on left + longest path on right
        if (root == null) {
            return new PathOutput(0, 0);
        }
        var leftOutput = longestPath(root.left);
        var rightOutput = longestPath(root.right);
        int leftPartial;
        if (root.left != null && root.left.character != root.character) {
            leftPartial = 1 + longestPartialPath(root.left, root.character);
        } else {
            leftPartial = 0;
        }
        int rightPartial;
        if (root.right != null && root.right.character != root.character) {
            rightPartial = 1 + longestPartialPath(root.right, root.character);
        } else {
            rightPartial = 0;
        }
        return new PathOutput(Math.max(leftOutput.longestPath, rightOutput.longestPath), leftPartial + rightPartial);
    }

    private int longestPartialPath(TreeNode root, char parentCharacter) {
        if (root == null || root.character == parentCharacter) {
            return 0;
        }
        int left = 0;
        if (root.left != null && root.left.character != root.character) {
            left = longestPartialPath(root.left, root.left.character);
        }
        int right = 0;
        if (root.right != null && root.right.character != root.character) {
            right = longestPartialPath(root.right, root.right.character);
        }
        return 1 + Math.max(left, right);
    }

    record PathOutput(int longestPath, int partialFromRoot) {
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        char character;
    }
}