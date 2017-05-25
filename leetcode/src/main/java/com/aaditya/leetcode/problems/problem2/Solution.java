package com.aaditya.leetcode.problems.problem2;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode number1Node = l1;
        ListNode number2Node = l2;
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        int carryOver = 0;
        while (number1Node != null && number2Node != null) {
            int sum = number1Node.val + number2Node.val + carryOver;
            tempResult.val = sum % 10;
            tempResult.next = new ListNode(0);
            tempResult = tempResult.next;
            carryOver = sum / 10;
            number1Node = number1Node.next;
            number2Node = number2Node.next;
        }
        while (number1Node != null) {
            int sum = number1Node.val + carryOver;
            tempResult.val = sum % 10;
            tempResult.next = new ListNode(0);
            tempResult = tempResult.next;
            carryOver = sum / 10;
            number1Node = number1Node.next;
        }
        while (number2Node != null) {
            int sum = number2Node.val + carryOver;
            tempResult.val = sum % 10;
            tempResult.next = new ListNode(0);
            tempResult = tempResult.next;
            carryOver = sum / 10;
            number2Node = number2Node.next;
        }
        while (carryOver > 0) {
            tempResult.val = carryOver % 10;
            tempResult.next = new ListNode(0);
            tempResult = tempResult.next;
            carryOver /= 10;
        }
        // Remove any padded zeros at the end of the list.
        ListNode prev = result;
        ListNode curr = result.next;
        while (curr != null && curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && curr.val == 0) {
            prev.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(1);

        ListNode num2 = new ListNode(9);
        num2.next = new ListNode(9);
        num2.next.next = new ListNode(9);
        ListNode res = addTwoNumbers(num2, num1);

        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
//        System.out.println(res.next.next.next.next);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

