package com.dsalgo.heap;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;

    // Initialize heap with maximum possible elements.
    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public static void main(String[] arg) {
        MinHeap minHeap = new MinHeap(3);
        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(18);
        minHeap.insert(3);

        minHeap.printHeap();

        minHeap.delete();

        minHeap.printHeap();

        minHeap.normalInsert(111);
        minHeap.normalInsert(1);
        minHeap.normalInsert(22);

        minHeap.printHeap();

        minHeap.heapify();

        minHeap.printHeap();
    }

    public void heapify() {
        int startIndex = getParentIndex(size - 1);
        if (isValidIndex(startIndex)) {
            for (int i = startIndex; i >= 0; i--) {
                shiftDown(i);
            }
        }
    }

    public void normalInsert(int element) {
        if (isFull()) {
            resizeHeap();
        }
        heap[size] = element;
        size++;
    }

    public void insert(int element) {
        if (isFull()) {
            resizeHeap();
        }
        heap[size] = element;
        shiftUp(size);
        size++;
    }

    private void shiftUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);

        while (isValidIndex(parentIndex) && heap[parentIndex] > heap[childIndex]) {
            swapValues(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    private void delete() {
        swapValues(0, size - 1);
        heap[size - 1] = 0;
        size = size - 1;
        shiftDown(0);
    }

    private void shiftDown(int parentIndex) {
        int leftChildIndex = leftChildIndex(parentIndex);
        boolean isLeftChildIndexValid = isValidIndex(leftChildIndex);

        while (isLeftChildIndexValid) {
            int smallElementIndex = leftChildIndex;
            int rightChildIndex = rightChildIndex(parentIndex);
            boolean isRightChildIndexValid = isValidIndex(rightChildIndex);

            if (isRightChildIndexValid && heap[rightChildIndex] < heap[leftChildIndex]) {
                smallElementIndex = rightChildIndex;
            }

            if (heap[smallElementIndex] < heap[parentIndex]) {
                swapValues(smallElementIndex, parentIndex);
                parentIndex = smallElementIndex;
                leftChildIndex = leftChildIndex(parentIndex);
                isLeftChildIndexValid = isValidIndex(leftChildIndex);
            } else {
                break;
            }
        }
    }

    private void swapValues(int indexA, int indexB) {
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private void resizeHeap() {
        int[] newHeap = new int[size * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }
}
