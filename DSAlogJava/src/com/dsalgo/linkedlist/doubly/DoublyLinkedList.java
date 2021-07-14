package com.dsalgo.linkedlist.doubly;

public class DoublyLinkedList {
    private DLLNode dllNode;

    public static void main(String[] arg) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        System.out.println("Insert end test");
        doublyLinkedList.insertEnd(20);
        doublyLinkedList.insertEnd(40);
        doublyLinkedList.traverse();
        System.out.println("Insert begin test");
        doublyLinkedList.insertBegin(33);
        doublyLinkedList.insertBegin(23);
        doublyLinkedList.traverse();
        System.out.println("Delete begin test");
        doublyLinkedList.deleteBegin();
        doublyLinkedList.traverse();
        doublyLinkedList.deleteBegin();
        doublyLinkedList.traverse();
        System.out.println("Delete end test");
        doublyLinkedList.deleteEnd();
        doublyLinkedList.traverse();
        doublyLinkedList.deleteEnd();
        doublyLinkedList.traverse();
        doublyLinkedList.deleteEnd();
        doublyLinkedList.traverse();
    }

    // Time complexity: O(n) -> need to traverse till the end
    public void insertEnd(int data) {
        DLLNode newNode = new DLLNode(data);
        if (dllNode != null) {
            while (dllNode.getNext() != null)
                dllNode = dllNode.getNext();
            newNode.setPrev(dllNode);
            dllNode.setNext(newNode);
        } else {
            dllNode = newNode;
        }
    }

    // Time complexity: O(1) -> insert at the beginning
    public void insertBegin(int data) {
        DLLNode newNode = new DLLNode(data);
        if (dllNode != null) {
            dllNode.setPrev(newNode);
            newNode.setNext(dllNode);
        }
        dllNode = newNode;
    }

    // Time complexity: O(1) -> no need to traverse
    public void deleteBegin() {
        if (dllNode == null) {
            System.out.println("List is empty.");
        } else if (dllNode.getNext() == null) {
            dllNode = null;
        } else {
            DLLNode nextNode = dllNode.getNext();
            nextNode.setPrev(null);
            dllNode = nextNode;
        }
    }

    // Time complexity: O(n) -> need to traverse till the end
    public void deleteEnd() {
        if (dllNode == null) {
            System.out.println("List is empty.");
        } else if (dllNode.getNext() == null) {
            dllNode = null;
        } else {
            DLLNode curr = dllNode;
            while (curr.getNext().getNext() != null)
                curr = curr.getNext();
            curr.setNext(null);
        }
    }

    public void traverse() {
        DLLNode temp = dllNode;
        while (temp != null) {
            System.out.println("Node Data: " + temp.getData());
            temp = temp.getNext();
        }
    }
}

class DLLNode {
    private final int data;
    private DLLNode next;
    private DLLNode prev;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }
}