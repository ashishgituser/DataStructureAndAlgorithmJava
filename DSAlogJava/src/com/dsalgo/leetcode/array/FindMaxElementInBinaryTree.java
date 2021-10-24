package com.dsalgo.leetcode.array;

import com.dsalgo.tree.BTNode;
import com.dsalgo.tree.BinaryTree;

import static java.lang.Math.max;

public class FindMaxElementInBinaryTree {

    public static void main(String[] arg) {
        BinaryTree bt = new BinaryTree();

        BTNode root = new BTNode(10);
        bt.leverOrderInsert(root, 2);
        bt.leverOrderInsert(root, 1);
        bt.leverOrderInsert(root, 7);
        bt.leverOrderInsert(root, 9);
        bt.leverOrderInsert(root, 20);

        System.out.print(findMaxElementInBinaryTree(root));

    }

    public static int findMaxElementInBinaryTree(BTNode root) {
        if (root != null) {
            int leftMax = findMaxElementInBinaryTree(root.left);
            int rightMax = findMaxElementInBinaryTree(root.right);

            return leftMax > rightMax ? max(leftMax, root.value) : max(rightMax, root.value);
        }
        return -1;
    }
}
