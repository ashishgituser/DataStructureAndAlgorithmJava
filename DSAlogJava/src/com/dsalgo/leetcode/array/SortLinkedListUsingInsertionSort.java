//package com.dsalgo.leetcode.array;
//
//public class SortLinkedListUsingInsertionSort {
//
//    public static void main(String[] arg) {
//        SortLinkedListUsingInsertionSort sll = new SortLinkedListUsingInsertionSort();
//        sll.insert(1);
//        sll.insert(6);
//        sll.insert(4);
//        sll.insert(6);
//        sll.insert(2);
//        sll.insert(6);
//        sll.insert(0);
//        sll.insert(6);
//        sll.insert(-1);
//        sll.insert(-6);
//
//        sll.traverse();
//        sll.insertionSortList(sll.head);
//        sll.traverse();
//    }
//
//    public ListNode insertionSortList(ListNode head) {
//        if (head != null && head.next != null) {
//            ListNode current = head.next;
//            while (current != null) {
//                ListNode temp = head;
//                boolean flag = false;
//
//                while (temp != current) {
//                    if (temp.val > current.val) {
//                        flag = true;
//                        break;
//                    }
//                    temp = temp.next;
//                }
//
//                if (flag) {
//                    updateList(head, current, temp);
//                }
//                current = current.next;
//            }
//        }
//        return head;
//    }
//
//    public void updateList(ListNode head, ListNode current, ListNode sortedPosition) {
//        ListNode temp = head;
//
//        if (temp != sortedPosition) {
//            while (temp.next != sortedPosition) {
//                temp = temp.next;
//            }
//        }
//
//        ListNode newNode = new ListNode(current.val);
//        if (temp == head) {
//            newNode.next = head;
//            head = newNode;
//        } else {
//            temp.next = newNode;
//            newNode.next = sortedPosition;
//        }
//
//        deletedNodeFromList(head, current);
//    }
//
//    public void deletedNodeFromList(ListNode head, ListNode nodeToDelete) {
//        ListNode temp = head;
//        while (temp.next != nodeToDelete) {
//            temp = temp.next;
//        }
//
//        ListNode nextNodeFromDeletedNode = nodeToDelete.next;
//        temp.next = nextNodeFromDeletedNode;
//    }
//
//    public void insert(int value) {
//        Node newNode = new Node(value);
//
//        if (head != null) {
//            newNode.setNext(head);
//        }
//        head = newNode;
//    }
//
//    public void traverse() {
//        Node temp = head;
//        System.out.print("[");
//        while (temp != null) {
//            System.out.print(temp.getValue() + ",");
//            temp = temp.getNext();
//        }
//        System.out.print("]");
//    }
//}
//
//class ListNode {
//    int val;
//    Node next;
//
//    public ListNode(int value) {
//        this.val = value;
//    }
//}