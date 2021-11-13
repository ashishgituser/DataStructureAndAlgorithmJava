package com.dsalgo.leetcode.array;

/*
Improved version ->

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sb1.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                sb2.append(l2.val);
                l2 = l2.next;
            }
        }

        BigInteger sum = new BigInteger(sb1.reverse().toString()).add(new BigInteger(sb2.reverse().toString()));
        String s = new StringBuilder(sum.toString()).reverse().toString();

        char[] chars = s.toCharArray();
        ListNode root = new ListNode(chars[0] - '0');
        ListNode prev = root;
        for (int i = 1; i < chars.length; i++) {
            ListNode ln = new ListNode(chars[i] - '0');
            prev.next = ln;
            prev = ln;
        }

        return root;
    }

Improvement points
------------------------

1. Think before code.
2. Think before code.
3. Write down the ways to solve a problem. (In this case, BigInteger, Utilize StringBuilder).
 */

public class AddTwoNumberLinkedList {

    ListNode l1;
    ListNode l2;

    public static void main(String[] arg) {
        AddTwoNumberLinkedList ad = new AddTwoNumberLinkedList();

        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);
        ad.l1 = ad.insert(ad.l1, 9);

        ad.l2 = ad.insert(ad.l2, 9);
        ad.l2 = ad.insert(ad.l2, 9);
        ad.l2 = ad.insert(ad.l2, 9);
        ad.l2 = ad.insert(ad.l2, 9);

        ListNode result = addTwoNumbers(ad.l1, ad.l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int sum = 0, remainder = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + remainder;
            } else if (l1 != null) {
                sum = l1.val + remainder;
            } else if (l2 != null) {
                sum = l2.val + remainder;
            }

            remainder = 0;
            if (sum >= 10) {
                remainder = (sum / 10);
                sum = sum % 10;
            }

            result = addNode(result, sum);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (remainder != 0) result = addNode(result, remainder);

        return result;
    }

    public static ListNode addNode(ListNode node, int val) {
        ListNode newNode = new ListNode(val);
        if (node != null) {
            ListNode temp = node;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        } else {
            node = newNode;
        }
        return node;
    }

    public ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head != null) newNode.next = head;
        head = newNode;
        return head;
    }
}

class ListNode {
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

    ListNode listNode(ListNode listNode) {
        this.next = listNode;
        return this;
    }
}