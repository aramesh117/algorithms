package com.aaditya.hackerrank.coinbase.elementpresentintree;

public class Solution {
    static int isPresent(Node root, int value) {
        if (root.value == value) {
            return 1;
        }

        if (root.value > value) {
            if (root.right != null) {
                return isPresent(root.right, value);
            } else {
                return 0;
            }
        } else {
            if (root.left != null) {
                return isPresent(root.left, value);
            } else {
                return 0;
            }
        }
    }
    public static void main(String args[]) throws Exception {
    }

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            value = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
