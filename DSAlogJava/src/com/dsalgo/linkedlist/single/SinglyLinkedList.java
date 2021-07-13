package com.dsalgo.linkedlist.single;

public class SinglyLinkedList {
    private SLLNode sllNode;

    public static void main(String[] arg) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertEnd(10);
        singlyLinkedList.insertEnd(20);
        singlyLinkedList.traverse();
        //singlyLinkedList.traverseRecursive();
        System.out.println("Insert begin testing");
        singlyLinkedList.insertBegin(30);
        singlyLinkedList.traverse();
        System.out.println("Insert at testing");
        singlyLinkedList.insertAt(45, 1);
        singlyLinkedList.traverse();
        System.out.println("Delete begin testing");
        singlyLinkedList.deleteBegin();
        singlyLinkedList.traverse();
        System.out.println("Delete end testing");
        singlyLinkedList.deleteEnd();
        singlyLinkedList.traverse();
        System.out.println("Search element testing");
        System.out.println("Find: " + singlyLinkedList.find(30));
        System.out.println("Find: " + singlyLinkedList.find(451));
        System.out.println("Find: " + singlyLinkedList.findRecursion(30));
        System.out.println("Find: " + singlyLinkedList.findRecursion(451));
    }

    // Time complexity: O(n) -> where n is the number of existing nodes.
    public void insertEnd(int data) {
        SLLNode newNode = new SLLNode(data);
        if (sllNode != null) {
            SLLNode temp = sllNode;
            while (temp.getNext() != null)
                temp = temp.getNext();
            sllNode.setNext(newNode);
        } else {
            sllNode = newNode;
        }
    }

    // Time complexity: O(1)
    public void insertBegin(int data) {
        SLLNode newNode = new SLLNode(data);
        if (sllNode != null) {
            newNode.setNext(sllNode);
        }
        sllNode = newNode;
    }

    // Time complexity: best case scenario O(1) -> insert at the beginning
    // Time complexity: worst case scenario O(n) -> insert at the end
    public void insertAt(int data, int position) {
        if (position <= 0) {
            System.out.println("Incorrect position: " + position);
        }
        SLLNode newNode = new SLLNode(data);
        // If user inputs position as 1 then we need to make new node as head.
        if (position == 1) {
            newNode.setNext(sllNode);
            sllNode = newNode;
        } else {
            // Traverse linked list upto position - 2 and until list is not empty.
            SLLNode temp = sllNode;
            for (int i = 1; i <= position - 2 && temp != null; i++) {
                temp = temp.getNext();
            }
            // If position is correct, then we link new node.
            if (temp != null) {
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            }
        }
    }

    // Time complexity: O(1) -> deleting from beginning only
    public void deleteBegin() {
        if (sllNode == null) {
            System.out.println("List is empty.");
            return;
        }
        sllNode = sllNode.getNext();
    }

    // Time complexity: O(n) -> need to traverse till the end
    public void deleteEnd() {
        if (sllNode == null) {
            System.out.println("List is empty.");
            return;
        }
        if (sllNode.getNext() == null)
            sllNode = null;

        SLLNode temp = sllNode;
        while (temp.getNext().getNext() != null)
            temp = temp.getNext();
        temp.setNext(null);
    }

    // Time complexity: O(n) -> need to traverse list to find element
    public boolean find(int data) {
        if (data < 0) {
            System.out.println("Invalid data.");
            return false;
        }
        SLLNode temp = sllNode;
        boolean isDataFound = false;
        while (temp != null) {
            if (temp.getData() == data) {
                isDataFound = true;
                break;
            }
            temp = temp.getNext();
        }
        return isDataFound;
    }

    public boolean findRecursion(int data) {
        return findRec(sllNode, data);
    }

    // Time complexity: O(n) -> need to traverse list to find element
    public boolean findRec(SLLNode sllNode, int data) {
        if (sllNode == null) return false;
        if (sllNode.getData() == data) return true;
        return findRec(sllNode.getNext(), data);
    }

    // Time complexity: O(n) -> where n is the number of existing nodes
    public void traverse() {
        SLLNode temp = sllNode;
        while (temp != null) {
            System.out.println("Node : " + temp.getData());
            temp = temp.getNext();
        }
    }

    public void traverseRecursive() {
        this.traverseRec(sllNode);
    }

    // Time complexity: O(n) -> where n is the number of existing nodes
    // Here, iterative solution is better because of space complexity. Each recursive function call is going to take up the space.
    private void traverseRec(SLLNode sllNode) {
        if (sllNode == null)
            return;
        System.out.println("Node Item: " + sllNode.getData());
        traverseRec(sllNode.getNext());
    }
}

class SLLNode {
    private final int data;
    private SLLNode next;

    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public SLLNode getNext() {
        return next;
    }

    public void setNext(SLLNode sllNode) {
        this.next = sllNode;
    }
}