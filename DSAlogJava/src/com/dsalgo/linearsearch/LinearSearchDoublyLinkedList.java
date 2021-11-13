package com.dsalgo.linearsearch;

public class LinearSearchDoublyLinkedList {
    DLLNode head;

    public static void main(String[] arg) {
        LinearSearchDoublyLinkedList ld = new LinearSearchDoublyLinkedList();

        ld.insertAtBegin(20);
        ld.insertAtBegin(44);
        ld.insertAtBegin(22);
        ld.insertAtBegin(22);
        ld.insertAtBegin(22);

        System.out.println(ld.linearSearchFromEnd(ld.head, 33));
    }

    public void insertAtBegin(int data) {
        DLLNode newNode = new DLLNode(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public int linearSearchFromEnd(DLLNode head, int data) {
        if (head == null) return -1;

        DLLNode tempNode = head;
        int pos = totalNodes(tempNode);

        while (tempNode.prev != null) {
            if (tempNode.data == data) return pos;
            tempNode = tempNode.prev;
            pos--;
        }
        return -1;
    }

    public int totalNodes(DLLNode temp) {
        int n = -1;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        return n;
    }
}

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int data) {
        this.data = data;
    }
}
