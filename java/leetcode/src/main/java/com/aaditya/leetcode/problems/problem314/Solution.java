package com.aaditya.leetcode.problems.problem314;

import java.util.*;

public class Solution {
    private static NavigableMap<Integer, List<Integer>> order = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        System.out.println(verticalOrder(root));
    }

    public static List<List<Integer>> verticalOrder(TreeNode node) {
        if (node == null) {
            return List.of();
        }
        order = new TreeMap<>();
        traverse(node, 0, 0);
        return order.values().stream().toList();
    }

    record NodeAndDepth(TreeNode node, int column, int depth) {
    }

    public static void traverse(TreeNode node, int rootColumn, int depth) {
        var bfsQueue = new ArrayDeque<NodeAndDepth>();
        bfsQueue.offer(new NodeAndDepth(node, rootColumn, 0));
        while (!bfsQueue.isEmpty()) {
            var curr = bfsQueue.poll();
            order.computeIfAbsent(curr.column, c -> new ArrayList<>()).add(curr.node.val);
            if (curr.node.left != null) {
                bfsQueue.offer(new NodeAndDepth(curr.node.left, curr.column - 1, curr.depth + 1));
            }
            if (curr.node.right != null) {
                bfsQueue.offer(new NodeAndDepth(curr.node.right, curr.column + 1, curr.depth + 1));
            }
        }
    }
}
