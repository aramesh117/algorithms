package com.aaditya.leetcode.problems.problem1650;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val, Node left, Node right, Node parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
};