package com.dsalgo.queue;

public class QueueLinkedListImplementation {
    private QueueNode front;
    private QueueNode rear;

    public static void main(String[] arg) {
        QueueLinkedListImplementation queueLinkedListImplementation = new QueueLinkedListImplementation();
        queueLinkedListImplementation.enQueue(20);
        queueLinkedListImplementation.enQueue(33);
        System.out.println(queueLinkedListImplementation.deQueue());
    }

    public void enQueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            rear = front = newNode;
        }
        rear.setNext(newNode);
        rear = newNode;
    }

    public int deQueue() {
        if (front == null) {
            return Integer.MIN_VALUE;
        }
        int data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }
}

class QueueNode {
    private final int data;
    private QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public QueueNode getNext() {
        return this.next;
    }

    public void setNext(QueueNode queueNode) {
        this.next = queueNode;
    }
}