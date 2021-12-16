package com.dsalgo.revisedsconcepts.linkedlist;

import java.util.*;

public class MinBinaryHeapUsingArrayList {

    List<Integer> heap = new ArrayList<>();
    Map<Integer, Set<Integer>> nodeIndexMap = new HashMap<>();

    public static void main(String[] arg) {
        MinBinaryHeapUsingArrayList bn = new MinBinaryHeapUsingArrayList();
        bn.insert(2);
        bn.insert(4);
        bn.insert(1);
        bn.insert(7);

        bn.heap.forEach(element -> {
            System.out.print(element + ",");
        });

        bn.shiftDown(0);
        System.out.println();
        bn.heap.forEach(element -> {
            System.out.print(element + ",");
        });
    }

    public void insert(int element) {
        heap.add(element);
        //shiftUp(heap.size() - 1);
    }

    public void delete(int element) {
        int index = heap.indexOf(element);
        swap(index, heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(0);
    }

    public void shiftUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);

        while (isValidIndex(parentIndex) && heap.get(parentIndex) > heap.get(childIndex)) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    public void shiftDown(int parent) {
        int leftChildIndex = getLeftIndex(parent);
        boolean isLeftChildValid = isValidIndex(leftChildIndex);

        while (isLeftChildValid) {
            int smallElementIndex = leftChildIndex;
            int rightChildIndex = getRightIndex(parent);

            if (isValidIndex(rightChildIndex) && heap.get(rightChildIndex) < heap.get(smallElementIndex)) {
                smallElementIndex = rightChildIndex;
            }

            if (heap.get(parent) > heap.get(smallElementIndex)) {
                swap(parent, smallElementIndex);
                parent = smallElementIndex;
                leftChildIndex = getLeftIndex(parent);
                isLeftChildValid = isValidIndex(leftChildIndex);
            } else {
                break;
            }
        }
    }

    public void swap(int parentIndex, int childIndex) {
        int temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(childIndex));
        heap.set(childIndex, temp);
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public int getRightIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < heap.size();
    }
}
