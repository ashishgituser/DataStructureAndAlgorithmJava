package com.dsalgo.linkedlist.doublycircular;

public class DoublyCircularLinkedList {
    private DCLLNode head;

    public static void main(String[] arg) {
        DoublyCircularLinkedList doublyCircularLinkedList = new DoublyCircularLinkedList();
        System.out.println("Insert end test");
        doublyCircularLinkedList.insertEnd(new DCLLNode(20));
        doublyCircularLinkedList.insertEnd(new DCLLNode(23));
        doublyCircularLinkedList.traverse();
        System.out.println("Insert begin test");
        doublyCircularLinkedList.insertBegin(new DCLLNode(33));
        doublyCircularLinkedList.traverse();
    }

    // Time complexity: O(n) -> Find the last node to insert new node.
    public void insertEnd(DCLLNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            DCLLNode lastName = head;
            while (lastName.getNext() != head)
                lastName = lastName.getNext();
            lastName.setNext(newNode);
            newNode.setPrev(lastName);
        }
        newNode.setNext(head);
        head.setPrev(newNode);
    }

    // Time complexity: O(n) -> need to update last node
    public void insertBegin(DCLLNode newNode) {
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
            head.setPrev(newNode);
        } else {
            DCLLNode lastNode = head;
            while (lastNode.getNext() != head)
                lastNode = lastNode.getNext();
            newNode.setNext(head);
            head.setPrev(newNode);
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            head = newNode;
        }
    }

    public void traverse() {
        if (head != null) {
            System.out.println("Element: " + head.getData());
            if (head.getNext() != head) {
                for (DCLLNode node = head.getNext(); node != head; node = node.getNext())
                    System.out.println("Element: " + node.getData());
            }
        } else {
            System.out.println("Empty list.");
        }
    }
}

class DCLLNode {
    private final int data;
    private DCLLNode next;
    private DCLLNode prev;

    public DCLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DCLLNode getNext() {
        return next;
    }

    public void setNext(DCLLNode next) {
        this.next = next;
    }

    public DCLLNode getPrev() {
        return prev;
    }

    public void setPrev(DCLLNode prev) {
        this.prev = prev;
    }
}