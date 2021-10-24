package com.dsalgo.tree;


public class BinarySearchTree {

    public static void main(String[] arg) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode rootNode = null;

        rootNode = bst.recursiveInsert(rootNode, 12);
        rootNode = bst.recursiveInsert(rootNode, 22);
        rootNode = bst.recursiveInsert(rootNode, 10);
        rootNode = bst.recursiveInsert(rootNode, 11);
        rootNode = bst.recursiveInsert(rootNode, 9);
        rootNode = bst.recursiveInsert(rootNode, 23);
        rootNode = bst.recursiveInsert(rootNode, 19);

        System.out.print("\nTraversal : \n");
        bst.preOrderTraversal(rootNode);

        bst.iterativeInsert(rootNode, 333);
        System.out.print("\nTraversal : \n");
        bst.preOrderTraversal(rootNode);

        System.out.print("\nSearch key using recursion: \n");
        System.out.print(bst.searchRecursion(rootNode, 55));

        System.out.print("\nSearch key using iterative: \n");
        System.out.print(bst.iterativeSearch(rootNode, 23));

        System.out.print("\nFind max: \n");
        System.out.print(bst.max(rootNode).value);

        System.out.print("\nFind min: \n");
        System.out.print(bst.min(rootNode).value);

        System.out.print("\nDelete Node: \n");
        rootNode = bst.delete(rootNode, 23);
        bst.preOrderTraversal(rootNode);
    }

    public BSTNode delete(BSTNode root, int key) {
        if (root == null) return null;
        else if (root.value > key) root.left = delete(root.left, key);
        else if (root.value < key) root.right = delete(root.right, key);
        else {
            // Case 1: If it is leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: If node has right child
            else if (root.left == null) {
                root = root.right;
            }
            // Case 2: If node has left child
            else if (root.right == null) {
                root = root.left;
            }
            // Case 3: If node has two child
            else {
                BSTNode minNode = min(root.right);
                root.value = minNode.value;
                root.right = delete(root.right, minNode.value);
            }
        }
        return root;
    }

    public BSTNode recursiveInsert(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
        } else if (root.value > value) {
            root.left = recursiveInsert(root.left, value);
        } else {
            root.right = recursiveInsert(root.right, value);
        }
        return root;
    }

    public void iterativeInsert(BSTNode root, int value) {
        if (root != null) {
            if (root.value > value) {
                while (root.left != null) root = root.left;
                root.left = new BSTNode(value);
            } else {
                while (root.right != null) root = root.right;
                root.right = new BSTNode(value);
            }
        }
    }

    public int searchRecursion(BSTNode root, int key) {
        if (root == null || root.value == key) {
            return root != null ? root.value : -1;
        } else if (root.value > key) {
            return searchRecursion(root.left, key);
        } else {
            return searchRecursion(root.right, key);
        }
    }

    public BSTNode max(BSTNode root) {
        BSTNode maxNode = null;
        if (root != null) {
            while (root.right != null) root = root.right;
            maxNode = root;
        }
        return maxNode;
    }

    public BSTNode min(BSTNode root) {
        BSTNode minNode = null;
        if (root != null) {
            while (root.left != null) root = root.left;
            minNode = root;
        }
        return minNode;
    }

    public int iterativeSearch(BSTNode root, int key) {
        int numberToFind = -1;
        while (root != null) {
            if (root.value == key) {
                numberToFind = root.value;
                break;
            } else if (root.value > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return numberToFind;
    }

    public void preOrderTraversal(BSTNode root) {
        if (root == null) return;

        System.out.print(root.value + ",");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}

class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.value = value;
    }
}
