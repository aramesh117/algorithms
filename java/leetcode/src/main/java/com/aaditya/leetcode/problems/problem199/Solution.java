package com.aaditya.leetcode.problems.problem199;

import java.util.ArrayDeque;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

class Solution {
    record NodeAndDepth(TreeNode node, int depth) {
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        NavigableMap<Integer, Integer> depthToNode = new TreeMap<>();
        depthToNode.put(0, root.val);
        ArrayDeque<NodeAndDepth> bfs = new ArrayDeque<>();
        bfs.offer(new NodeAndDepth(root, 0));
        while (!bfs.isEmpty()) {
            NodeAndDepth curr = bfs.poll();
            // Overwrite with the latest since the bfs should add nodes to the queue left to right
            depthToNode.put(curr.depth, curr.node.val);
            if (curr.node.left != null) {
                bfs.offer(new NodeAndDepth(curr.node.left, curr.depth + 1));
            }
            if (curr.node.right != null) {
                bfs.offer(new NodeAndDepth(curr.node.right, curr.depth + 1));
            }
        }
        return depthToNode.values().stream().toList();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        System.out.println(new Solution().rightSideView(root));

        TreeNode root1 = new TreeNode(0);
        System.out.println(new Solution().rightSideView(root1));

    }
}