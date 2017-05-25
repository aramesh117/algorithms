package com.aaditya.leetcode.problems.problem388;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern NEW_LINE = Pattern.compile("\\n");
    private static final Pattern SPACES = Pattern.compile("    ");

    public static boolean isFile(String name) {
        return name.contains(".");
    }

    public static int lengthLongestPath(String input) {
        String[] lines = NEW_LINE.split(input);
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            lines[i] = SPACES.matcher(line).replaceAll("\t");
            System.out.println(lines[i]);
        }
        // Level zero for the root node.
        List<Node> rootNodes = new ArrayList<>();
        Node rootNode = new Node(lines[0]);
        rootNodes.add(rootNode);
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(rootNode);
        for (int i = 1; i < lines.length; i++) {
            int currLevel = 0;
            while (lines[i].charAt(currLevel) == '\t') {
                currLevel++;
            }
            // If the number of tabs exceeds the number of elements in the stack, we are one level deeper.
            if (currLevel > stack.size() - 1) {
                Node newNode = new Node(lines[i].substring(currLevel));
                Node parent = stack.peek();
                parent.addChild(newNode);
                stack.push(newNode);
            } else if (currLevel == stack.size() - 1) {
                // Discard the previous peer since we don't need it.
                stack.pop();
                Node newNode = new Node(lines[i].substring(currLevel));
                Node parent = stack.peek();
                if (parent != null) {
                    // As long as we have a single root node, we will always have a parent node.
                    parent.addChild(newNode);
                } else {
                    // If we don't, then we have multiple root nodes, in which case, we don't add a child and add the
                    // node to the list of root nodes.
                    rootNodes.add(newNode);
                }
                stack.push(newNode);
            } else {
                while (stack.size() - 1 > currLevel) {
                    stack.pop();
                }
                Node newNode = new Node(lines[i].substring(currLevel));
                Node parent = stack.peek();
                parent.addChild(newNode);
                stack.push(newNode);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Node root: rootNodes) {
            max = Math.max(max, root.findLongestPath());
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(lengthLongestPath("rzzmf\nv\n\tix\n\t\tiklav\n\t\t\ttqse\n\t\t\t\ttppzf\n\t\t\t\t\tzav\n\t\t\t\t\t\tkktei\n\t\t\t\t\t\t\thmav\n\t\t\t\t\t\t\t\tbzvwf.txt"));
        System.out.println(lengthLongestPath("a\n\tb\n\t\tc\n\t\t\tfile.ext"));
    }

    public static class Node {
        private final List<Node> mChildren = new ArrayList<>();
        private final String mName;
        private final boolean mIsFile;

        public Node(String name) {
            mName = name;
            mIsFile = Solution.isFile(name);
        }

        public void addChild(Node node) {
            mChildren.add(node);
        }

        public int findLongestPath() {
            if (mIsFile) {
                return mName.length();
            } else {
                int maxFileLength = 0;
                for (Node child : mChildren) {
                    int childPathLength = child.findLongestPath();
                    if (childPathLength != 0) {
                        // If the child has no files in any of its subfolders.
                        maxFileLength = Math.max(maxFileLength, mName.length() + 1 + childPathLength);
                    }
                }
                return maxFileLength;
            }
        }

        public boolean isFile() {
            return mIsFile;
        }

        public String getName() {
            return mName;
        }
    }
}
