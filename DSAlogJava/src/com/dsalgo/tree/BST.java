package com.dsalgo.tree;

public class BST {

    public static void main(String[] arg) {
        BST bst = new BST();
        Node tree = null;

        tree = bst.insert(tree, new Node(1));
        tree = bst.insert(tree, new Node(4));
        tree = bst.insert(tree, new Node(7));
        tree = bst.insert(tree, new Node(3));

        bst.traverse(tree);

        tree = bst.delete(tree, 3);

        bst.traverse(tree);
    }

    public Node insert(Node tree, Node node) {
        if (tree == null) {
            tree = node;
        } else if (tree.data > node.data) {
            tree.left = insert(tree.left, node);
        } else {
            tree.right = insert(tree.right, node);
        }
        return tree;
    }

    public Node delete(Node tree, int val) {
        if (tree == null) return null;
        else if (tree.data > val) tree.left = delete(tree.left, val);
        else if (tree.data < val) tree.right = delete(tree.right, val);
        else {
            // case 1: Node to be deleted is leaf node.
            if (tree.left == null && tree.right == null) {
                tree = null;
            }
            // case 2 and 3: Node to be deleted has either left subtree or right subtree
            else if (tree.left == null) {
                tree = tree.right;
            } else if (tree.right == null) {
                tree = tree.left;
            }
            // case 4: Node to be deleted has both right and left subtree.
            else {
                Node maxNode = max(tree.left);
                tree.data = maxNode.data;
                tree.left = delete(tree.left, maxNode.data);
            }
        }
        return tree;
    }

    public Node max(Node startingNode) {
        while (startingNode.right != null) startingNode = startingNode.right;
        return startingNode;
    }

    public void traverse(Node tree) {
        if (tree == null) return;

        System.out.print(tree.data + ",");
        traverse(tree.left);
        traverse(tree.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
