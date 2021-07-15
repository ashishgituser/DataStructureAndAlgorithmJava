package com.dsalgo.linkedlist.circular;

public class SinglyCircularLinkedList {
    private CLLNode head;

    public static void main(String[] arg) {
        SinglyCircularLinkedList singlyCircularLinkedList = new SinglyCircularLinkedList();
        singlyCircularLinkedList.insertEnd(new CLLNode(20));
        singlyCircularLinkedList.insertEnd(new CLLNode(43));
        singlyCircularLinkedList.insertEnd(new CLLNode(12));
        singlyCircularLinkedList.traverse();
        System.out.println("Insert begin test");
        singlyCircularLinkedList.insertBegin(new CLLNode(47));
        singlyCircularLinkedList.insertBegin(new CLLNode(34));
        singlyCircularLinkedList.traverse();
        System.out.println("Delete begin test");
        singlyCircularLinkedList.deleteBegin();
        singlyCircularLinkedList.traverse();
        System.out.println("Delete end test");
        singlyCircularLinkedList.deleteEnd();
        singlyCircularLinkedList.traverse();
        System.out.println("Delete kth test");
        singlyCircularLinkedList.deleteKthItem(1);
        singlyCircularLinkedList.traverse();
    }

    // Time complexity: O(n) -> need traversing
    public void insertEnd(CLLNode newNode) {
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            CLLNode curr = head;
            while (curr.getNext() != head)
                curr = curr.getNext();
            newNode.setNext(head);
            curr.setNext(newNode);
        }
    }

    // Time complexity: O(n) -> need to point last node next to new head
    public void insertBegin(CLLNode newNode) {
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            CLLNode lastNode = head;
            while (lastNode.getNext() != head)
                lastNode = lastNode.getNext();
            newNode.setNext(head);
            lastNode.setNext(newNode);
            head = newNode;
        }
    }

    // Time complexity: O(n) -> traverse to update last node head
    public void deleteBegin() {
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            if (head.getNext() == head) {
                head = null;
            } else {
                CLLNode nextNode = head.getNext();
                CLLNode lastNode = head;
                while (lastNode.getNext() != head)
                    lastNode = lastNode.getNext();
                head = nextNode;
                lastNode.setNext(head);
            }
        }
    }

    // Time complexity: O(n) -> need to traverse till end to update head
    public void deleteEnd() {
        if (head == null) {
            System.out.println("Empty list.");
        } else if (head.getNext() == head) {
            head = null;
        } else {
            CLLNode temp = head;
            while (temp.getNext().getNext() != head)
                temp = temp.getNext();
            temp.setNext(head);
        }
    }

    public void deleteKthItem(int position) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            this.deleteBegin();
            return;
        }
        int tempIndex = 0;
        CLLNode curr = head;
        while (tempIndex != position - 2) {
            curr = curr.getNext();
            tempIndex++;
        }
        CLLNode currNext = curr.getNext();
        curr.setNext(currNext.getNext());
    }

    // Time complexity: O(n) -> need traversing till nth element
    public void traverse() {
        if (head != null) {
            System.out.println("Element: " + head.getData());
            for (CLLNode node = head.getNext(); node != head; node = node.getNext()) {
                System.out.println("Element: " + node.getData());
            }
        } else {
            System.out.println("List is empty.");
        }
    }
}

class CLLNode {
    private final int data;
    private CLLNode next;

    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }
}