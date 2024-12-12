package com.aaditya.leetcode.problems.problem449;

public class Codec {

    public static int getEndOfGroup(String data, int start) {
        int stackDepth = 0;
        int i = start;
        while (i < data.length()) {
            if (data.charAt(i) == '[') {
                stackDepth++;
            }
            if (data.charAt(i) == ']') {
                stackDepth--;
            }
            if (stackDepth == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(Codec.getEndOfGroup("[[]][[]]", 0));
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println(serialized);
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println(codec.serialize(deserialized));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return String.format("%s[%s][%s]", root.val, serialize(root.left), serialize(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        int i = 0;
        while (Character.isDigit(data.charAt(i))) {
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, i)));
        int leftStart = i;
        int leftEnd = getEndOfGroup(data, leftStart);
        int rightStart = leftEnd + 1;
        int rightEnd = getEndOfGroup(data, rightStart);
        root.left = deserialize(data.substring(leftStart + 1, leftEnd));
        root.right = deserialize(data.substring(rightStart + 1, rightEnd));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;