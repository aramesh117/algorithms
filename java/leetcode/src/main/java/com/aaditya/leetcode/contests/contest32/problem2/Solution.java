package com.aaditya.leetcode.contests.contest32.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Integer> killProcess(List<Integer> pids, List<Integer> parentId, int kill) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode init = new TreeNode(0);
        map.put(0, init);
        for (int pid : pids) {
            TreeNode node = new TreeNode(pid);
            map.put(pid, node);
        }
        for (int i = 0; i < pids.size(); i++) {
            int pid = pids.get(i);
            TreeNode node = map.get(pid);
            TreeNode parentNode = map.get(parentId.get(i));
            parentNode.addChild(node);
        }

        TreeNode killNode = map.get(kill);
        List<Integer> children = killNode.getAllChildrenPids();
        children.add(kill);
        return children;
    }

    public static void main(String[] args) {
        System.out.println(killProcess(Arrays.asList(1, 2, 3, 4), Arrays.asList(0, 1, 1, 3), 3));
    }

    private static class TreeNode {
        private final Map<Integer, TreeNode> children;
        private final int pid;

        public TreeNode(int pid) {
            this.children = new HashMap<>();
            this.pid = pid;
        }

        public void addChild(TreeNode child) {
            children.put(child.pid, child);
        }

        public int getPid() {
            return pid;
        }

        public List<Integer> getAllChildrenPids() {
            List<Integer> list = new ArrayList<>(children.keySet());
            for (TreeNode node : children.values()) {
                list.addAll(node.getAllChildrenPids());
            }
            return list;
        }
    }
}
