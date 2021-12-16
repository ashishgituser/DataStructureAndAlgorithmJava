package com.dsalgo.revisedsconcepts.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] arg) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(2);
        doublyLinkedList.add(4);
        doublyLinkedList.add(1);
        doublyLinkedList.addFirst(33);

        for (Integer integer : doublyLinkedList) {
            System.out.println(integer);
        }
    }

    static class Node<T> {
        private final T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        };
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.prev = new Node<>(element, null, head);
            head = head.prev;
        }
        size = size + 1;
    }

    private void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }
        size = size + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> traversal = head;
            @Override
            public boolean hasNext() {
                return traversal != null;
            }

            @Override
            public T next() {
                T data = traversal.data;
                traversal = traversal.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
