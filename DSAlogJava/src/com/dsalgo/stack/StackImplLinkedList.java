package com.dsalgo.stack;

public class StackImplLinkedList {
    private SLLNode stackHead;

    public static void main(String[] arg) {
        StackImplLinkedList stackImplLinkedList = new StackImplLinkedList();
        stackImplLinkedList.push(new SLLNode(10));
        stackImplLinkedList.push(new SLLNode(20));
        stackImplLinkedList.traverse();
        System.out.println();
        System.out.println("Item poped: " + stackImplLinkedList.pop());
        stackImplLinkedList.traverse();
        System.out.println();
        System.out.println("Peek: " + stackImplLinkedList.peek());
        System.out.println("is stack empty: " + stackImplLinkedList.isEmpty());
        System.out.println("Item poped: " + stackImplLinkedList.pop());
        System.out.println("is stack empty: " + stackImplLinkedList.isEmpty());
    }

    public void push(SLLNode newNode) {
        if (stackHead != null) {
            newNode.setNext(stackHead);
        }
        stackHead = newNode;
    }

    public int pop() {
        if (stackHead != null) {
            SLLNode nodeToDelete = stackHead;
            stackHead = stackHead.getNext();
            return nodeToDelete.getData();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public int peek() {
        if (stackHead != null) {
            return stackHead.getData();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return stackHead == null;
    }

    public void traverse() {
        SLLNode temp = stackHead;
        System.out.println("Stack Elements");
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }
}

class SLLNode {
    private final int data;
    private SLLNode next;

    public SLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public SLLNode getNext() {
        return next;
    }

    public void setNext(SLLNode next) {
        this.next = next;
    }
}