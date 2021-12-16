package com.dsalgo.revisedsconcepts.linkedlist;

public class QueueUsingSLinkedList {

    Node head;
    Node tail;

    public static void main(String[] arg) {
        QueueUsingSLinkedList q = new QueueUsingSLinkedList();
        q.enQueue(1);
        q.enQueue(4);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }

    public void enQueue(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int deQueue() {
        if (head != null) {
            Node node = head;
            head = head.next;
            return node.val;
        }
        return -1;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
