package com.dsalgo.leetcode.linkedlist;

import java.util.Stack;

public class MergeTwoSortedList {

    public static void main(String[] arg) {
        MergeTwoSortedList m = new MergeTwoSortedList();

        ListNode l1 = new ListNode(1);
        m.add(l1, 2);
        m.add(l1, 4);

        ListNode l2 = new ListNode(1);
        m.add(l2, 3);
        m.add(l2, 4);

        m.traverse(m.mergeTwoSortedList(l1, l2));
    }

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        Stack<ListNode> stack = new Stack<>();
        ListNode result = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                stack.push(l1);
                l1 = l1.next;
            } else {
                stack.push(l2);
                l2 = l2.next;
            }
        }
        addLeftOver(l1, stack);
        addLeftOver(l2, stack);

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = result;
            result = node;
        }

        return result;
    }

    public void addLeftOver(ListNode node, Stack<ListNode> stack) {
        if (node != null) {
            while (node != null) {
                stack.push(node);
                node = node.next;
            }
        }
    }

    public void add(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head != null) {
            ListNode trav = head;
            while (trav.next != null) trav = trav.next;
            trav.next = newNode;
        }
    }

    public void traverse(ListNode head) {
        ListNode trav = head;
        while (trav != null) {
            System.out.print(trav.val + ",");
            trav = trav.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
