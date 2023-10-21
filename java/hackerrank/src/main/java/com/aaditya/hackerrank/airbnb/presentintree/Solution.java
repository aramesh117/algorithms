package com.aaditya.hackerrank.airbnb.presentintree;

public class Solution {
    static int isPresent(Node root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.data == val) {
            return 1;
        } else if (val > root.data) {
            if (root.right == null) {
                return 0;
            } else {
                return isPresent(root.right, val);
            }
        } else {
            if (root.left == null) {
                return 0;
            } else {
                return isPresent(root.left, val);
            }
        }
    }

    public static class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }
}

