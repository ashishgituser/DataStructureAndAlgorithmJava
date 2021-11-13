package com.dsalgo.linearsearch;

public class LinearSearchLinkedList {
    Node head;

    public static void main(String[] arg) {
        LinearSearchLinkedList lsll = new LinearSearchLinkedList();
        lsll.insertAtBegin(20);
        lsll.insertAtBegin(30);
        lsll.insertAtBegin(44);

        System.out.println(lsll.linearSearchNonRecursive(30));
        System.out.println(lsll.linearSearchRecursive(lsll.head, 20));
    }

    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        if (head != null)
            newNode.next = head;
        head = newNode;
    }

    public int linearSearchNonRecursive(int data) {
        int pos = -1;
        Node temp = head;
        while (temp != null) {
            pos++;
            if (temp.data == data) break;
            temp = temp.next;
        }
        return pos;
    }

    public int linearSearchRecursive(Node head, int data) {
        if (head == null) return -1;
        if (head.data == data) return 0;

        int pos = linearSearchRecursive(head.next, data);

        if (pos == -1) return -1;
        else return pos + 1;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}