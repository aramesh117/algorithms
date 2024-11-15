package com.aaditya.leetcode.problems.problem426;

/*
// Definition for a Node.
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        serializeNode(root);
        Node firstNode = leftMostNode(root);
        Node lastNode = rightMostNode(root);
        firstNode.left = lastNode;
        lastNode.right = firstNode;
        return firstNode;
    }

    private void serializeNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            serializeNode(root.left);
        }
        if (root.right != null) {
            serializeNode(root.right);
        }
        Node predecessor = rightMostNode(root.left);
        Node successor = leftMostNode(root.right);
        root.left = predecessor;
        if (predecessor != null) {
            predecessor.right = root;
        }
        root.right = successor;
        if (successor != null) {
            successor.left = root;
        }
    }

    private Node leftMostNode(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node rightMostNode(Node root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
        Node node = new Solution().treeToDoublyList(root);
//        Node rightDir = node;
//        while (rightDir != null) {
//            System.out.println(rightDir.val);
//            rightDir = rightDir.right;
//        }
        Node leftDir = node;
        while (leftDir != null) {
            System.out.println(leftDir.val);
            leftDir = leftDir.left;
        }
    }
}