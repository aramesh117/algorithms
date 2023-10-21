package com.aaditya.leetcode.problems.problem23;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                if (o1.val > o2.val) {
                    return 1;
                }
                return 0;
            }
        });
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        if (queue.size() < 1) {
            return null;
        }
        ListNode beginning = queue.poll();
        if (beginning.next != null) {
            queue.add(beginning.next);
        }
        ListNode previous = beginning;
        while (queue.size() > 0) {
            ListNode next = queue.poll();
            previous.next = next;
            if (next.next != null) {
                queue.add(next.next);
            }
            previous = next;
        }
        return beginning;
    }

    public static void getString(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode getLinkedList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode prev = head;
        for (int i = 1; i < values.length; i++) {
            prev.next = new ListNode(values[i]);
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        getString(mergeKLists(new ListNode[]{null}));
    }
}
