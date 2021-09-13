package com.dsalgo.queue;

import java.util.Arrays;

public class QueueArrayImplementation {
    private final int[] elements;
    private final int capacity;
    private int size, front, rear;

    public QueueArrayImplementation(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public static void main(String[] arg) {
        try {
            QueueArrayImplementation queueArrayImplementation = new QueueArrayImplementation(2);
            queueArrayImplementation.enQueue(20);
            queueArrayImplementation.enQueue(30);
            queueArrayImplementation.traverse();
            System.out.println(queueArrayImplementation.deQueue());
            queueArrayImplementation.traverse();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void enQueue(int element) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full.");
        } else {
            size++;
            elements[rear] = element;
            rear = (rear + 1) % capacity;
        }
    }

    public int deQueue() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        } else {
            int data = elements[front];
            elements[front] = Integer.MIN_VALUE;
            front = (front + 1) % capacity;
            size--;
            return data;
        }
    }

    public void traverse() {
        Arrays.stream(elements).forEach(System.out::println);
    }
}
