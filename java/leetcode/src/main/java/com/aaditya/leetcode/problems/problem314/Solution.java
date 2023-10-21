package com.aaditya.leetcode.problems.problem314;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        System.out.println(verticalOrder(root));
    }

    public static List<List<Integer>> verticalOrder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        Map<TreeNode, Integer> columnMap = new LinkedHashMap<>();
        columnMap.put(node, 0);
        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(node);
        while (!bfsQueue.isEmpty()) {
            TreeNode cur = bfsQueue.poll();
            int currentCol = columnMap.get(cur);
            if (cur.left != null) {
                columnMap.put(cur.left, currentCol - 1);
                bfsQueue.add(cur.left);
            }
            if (cur.right != null) {
                columnMap.put(cur.right, currentCol + 1);
                bfsQueue.add(cur.right);
            }
        }
        Map<Integer, List<Integer>> res = new TreeMap<>();
        for (Map.Entry<TreeNode, Integer> entry : columnMap.entrySet()) {
            res.compute(entry.getValue(), (integer, integers) -> {
                if (integers == null) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(entry.getKey().val);
                    return newList;
                } else {
                    integers.add(entry.getKey().val);
                    return integers;
                }
            });
        }
        List<List<Integer>> finalRes = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : res.entrySet()) {
            finalRes.add(entry.getValue());
        }
        return finalRes;
    }
}
