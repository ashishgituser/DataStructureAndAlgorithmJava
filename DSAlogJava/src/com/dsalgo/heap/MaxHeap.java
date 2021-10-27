package com.dsalgo.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] heap;
    int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(3);

        maxHeap.insertWithoutHeapify(4);
        maxHeap.insertWithoutHeapify(3);
        maxHeap.insertWithoutHeapify(2);
        maxHeap.insertWithoutHeapify(1);
        maxHeap.insertWithoutHeapify(8);
        maxHeap.insertWithoutHeapify(9);

        maxHeap.printHeap();
        maxHeap.heapify();
        maxHeap.printHeap();
    }

    public void insertWithoutHeapify(int element) {
        if (isFull())
            resizeHeap();
        heap[size] = element;
        size++;
    }

    public void insert(int element) {
        if (isFull())
            resizeHeap();
        heap[size] = element;
        shiftUpRecursion(size);
        size++;
    }

    public void maxHeapify(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        if (isValidIndex(parentIndex)) {
            shiftDown(parentIndex);
            maxHeapify(parentIndex - 1);
        }
    }

    public void shiftUpRecursion(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        if (isValidIndex(parentIndex)) {
            if (heap[childIndex] > heap[parentIndex]) {
                swap(childIndex, parentIndex);
            }
            shiftUpRecursion(parentIndex);
        }
    }

    public void shiftUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        while (isValidIndex(parentIndex) && heap[childIndex] > heap[parentIndex]) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    public void swap(int indexA, int indexB) {
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }

    public void heapify() {
        int startIndex = getParentIndex(size - 1);
        System.out.println(size - 1);
        System.out.println(startIndex);
        if (isValidIndex(startIndex)) {
            for (int i = startIndex; i >= 0; i--)
                shiftDown(i);
        }
    }

    public void delete() {
        swap(0, size - 1);
        heap[size - 1] = 0;
        size = size - 1;
        shiftDownRecursive(0);
    }

    public void shiftDown(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        boolean isLeftChildIndexValid = isValidIndex(leftChildIndex);

        while (isLeftChildIndexValid) {
            int maxElementIndex = leftChildIndex;
            int rightChildIndex = getRightChildIndex(parentIndex);
            boolean isRightChildIndexValid = isValidIndex(rightChildIndex);

            if (isRightChildIndexValid && heap[rightChildIndex] > heap[leftChildIndex]) {
                maxElementIndex = rightChildIndex;
            }

            if (heap[maxElementIndex] > heap[parentIndex]) {
                swap(maxElementIndex, parentIndex);
                parentIndex = maxElementIndex;
                leftChildIndex = getLeftChildIndex(parentIndex);
                isLeftChildIndexValid = isValidIndex(leftChildIndex);
            } else {
                break;
            }
        }
    }

    public void shiftDownRecursive(int parentIndex) {
        int maxElementIndex = -1;
        int leftChildIndex = getLeftChildIndex(parentIndex);

        if (isValidIndex(leftChildIndex)) {
            maxElementIndex = leftChildIndex;
            int rightChildIndex = getRightChildIndex(parentIndex);

            if (isValidIndex(rightChildIndex) && heap[rightChildIndex] > heap[leftChildIndex])
                maxElementIndex = rightChildIndex;

            if (heap[maxElementIndex] > heap[parentIndex]) {
                swap(maxElementIndex, parentIndex);
                shiftDownRecursive(maxElementIndex);
            }
        }
    }

    public void resizeHeap() {
        int[] newHeap = new int[size * 2];
        for (int i = 0; i < heap.length; i++)
            newHeap[i] = heap[i];
        heap = newHeap;
    }

    public int getParentIndex(int childIndex) {
        return childIndex != 0 ? (childIndex - 1) / 2 : -1;
    }

    public int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }
}
