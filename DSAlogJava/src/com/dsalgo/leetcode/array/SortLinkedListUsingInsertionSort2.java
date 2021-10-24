package com.dsalgo.leetcode.array;

public class SortLinkedListUsingInsertionSort2 {
    private Node head;
    private Node sortedList;

    public static void main(String[] arg) {
        SortLinkedListUsingInsertionSort2 sll = new SortLinkedListUsingInsertionSort2();
        sll.insert(1);
        sll.insert(6);
        sll.insert(4);
        sll.insert(6);
        sll.insert(2);
        sll.insert(6);
        sll.insert(0);
        sll.insert(6);
        sll.insert(-1);
        sll.insert(-6);

        sll.traverse();
        sll.sort();
        sll.traverse();
    }

    public void sort() {
        if (head != null && head.getNext() != null) {
            Node current = head;
            sortedList = null;
            while (current != null) {
                Node next = current.getNext();
                updateSorted(current);
                current = next;
            }
            head = sortedList;
        }
    }

    private void updateSorted(Node newNode) {
        if (sortedList == null || sortedList.getValue() >= newNode.getValue()) {
            newNode.setNext(sortedList);
            sortedList = newNode;
        } else {
            Node currentNode = sortedList;
            while (currentNode.getNext() != null && currentNode.getNext().getValue() < newNode.getValue()) {
                currentNode = currentNode.getNext();
            }

            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void traverse() {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.getValue() + ",");
            temp = temp.getNext();
        }
        System.out.print("]");
    }
}

class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNode) {
        this.next = newNode;
    }
}