package com.dsalgo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] arg) {
        BinaryTree bt = new BinaryTree();
        BTNode root = new BTNode(5);

        bt.leverOrderInsert(root, 1);
        bt.leverOrderInsert(root, 3);
        bt.leverOrderInsert(root, 6);

        bt.leverOrderTraversal(root);

        System.out.println("\nPre order traversal: ");
        bt.recursivePreOrderTraversal(root);

        System.out.println("\nIn order traversal: ");
        bt.recursiveInOrderTraversal(root);

        System.out.println("\nPost order traversal: ");
        bt.recursivePostOrderTraversal(root);

        System.out.println("\nIterative pre order traversal: ");
        bt.iterativePreOrderTraversal(root);

        System.out.print("\nIterative In order traversal: ");
        bt.iterativeInOrderTraversal(root);

        System.out.print("\nIterative Post order traversal: ");
        bt.iterativePostOrderTraversal(root);
    }

    public void leverOrderInsert(BTNode root, int value) {
        BTNode newNode = new BTNode(value);
        if (root == null) {
            root = newNode;
        } else {

            Queue<BTNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                BTNode visitedNode = queue.poll();

                if (visitedNode.left != null) {
                    queue.offer(visitedNode.left);
                } else {
                    visitedNode.left = newNode;
                    break;
                }

                if (visitedNode.right != null) {
                    queue.offer(visitedNode.right);
                } else {
                    visitedNode.right = newNode;
                    break;
                }
            }
        }
    }

    private void recursivePreOrderTraversal(BTNode root) {
        if (root == null) return;
        System.out.print(root.value + ",");
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    private void iterativePreOrderTraversal(BTNode root) {
        if (root != null) {
            Stack<BTNode> callStack = new Stack<>();
            callStack.push(root);

            while (!callStack.isEmpty()) {
                BTNode node = callStack.pop();
                System.out.print(node.value + ",");
                if (node.right != null) callStack.push(node.right);
                if (node.left != null) callStack.push(node.left);
            }
        }
    }

    private void recursiveInOrderTraversal(BTNode root) {
        if (root == null) return;
        recursiveInOrderTraversal(root.left);
        System.out.print(root.value + ",");
        recursiveInOrderTraversal(root.right);
    }

    private void iterativeInOrderTraversal(BTNode root) {
        if (root != null) {
            Stack<BTNode> callStack = new Stack<>();

            while (true) {
                if (root != null) {
                    callStack.push(root);
                    root = root.left;
                } else {
                    if (callStack.isEmpty()) break;

                    root = callStack.pop();
                    System.out.print(root.value + ",");
                    root = root.right;
                }
            }
        }
    }

    private void recursivePostOrderTraversal(BTNode root) {
        if (root == null) return;
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);
        System.out.print(root.value + ",");
    }

    private void iterativePostOrderTraversal(BTNode root) {
        if (root != null) {
            Stack<BTNode> callStack = new Stack<>();
            Stack<BTNode> orderedStack = new Stack<>();

            callStack.push(root);
            while (!callStack.isEmpty()) {
                BTNode node = callStack.pop();
                orderedStack.push(node);

                if (node.left != null) callStack.push(node.left);
                if (node.right != null) callStack.push(node.right);
            }

            while (!orderedStack.isEmpty()) System.out.print(orderedStack.pop().value + ",");
        }
    }

    private void leverOrderTraversal(BTNode root) {
        if (root != null) {

            Queue<BTNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                BTNode visitedNode = queue.poll();
                System.out.print(visitedNode.value + ",");
                if (visitedNode.left != null) queue.offer(visitedNode.left);
                if (visitedNode.right != null) queue.offer(visitedNode.right);
            }
        }
    }
}


