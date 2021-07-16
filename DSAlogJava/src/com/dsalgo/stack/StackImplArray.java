package com.dsalgo.stack;

public class StackImplArray {
    private final int[] stack;
    private final int capacity;
    private int top = -1;

    public StackImplArray(int size) {
        this.capacity = size;
        this.stack = new int[this.capacity];
    }

    public static void main(String[] arg) {
        StackImplArray stack = new StackImplArray(10);
        stack.push(1);
        stack.push(20);
        stack.push(-1);
        System.out.println("Item deleted from stack: " + stack.pop());
        System.out.println("Item on the top: " + stack.peek());
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Can not add item: " + data);
        } else {
            stack[++top] = data;
            System.out.println("Item added: " + data);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top];
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == capacity - 1;
    }
}
