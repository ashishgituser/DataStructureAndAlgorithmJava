package com.dsalgo.leetcode.tree;

import java.util.*;

public class RecoverTree {

    int index = 0;

    public static void main(String[] arg) {
        RecoverTree r = new RecoverTree();
        TreeNode root = r.recoverFromPreorder("1-2--3---4-5--6---7", 0);
        r.leverOrderTraversal(root);
    }

    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, Integer> nodeMap = new HashMap<>();
        TreeNode head = null;

        int level = 0;
        char value;

        for (int i = 0; i < traversal.length(); i++) {
            value = traversal.charAt(i);

            if (value == '-') {
                level = level + 1;
            } else {
                nodeMap.put(Character.getNumericValue(value), level);
                level = 0;
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(nodeMap.entrySet());
        list.sort((Comparator<Object>) (o1, o2) ->
                ((Comparable<Integer>) ((Map.Entry<Integer, Integer>) (o1)).getValue()).compareTo(((Map.Entry<Integer, Integer>) (o2)).getValue()));

        for (Map.Entry<Integer, Integer> tree : list) {
            TreeNode newNode = new TreeNode(tree.getKey(), null, null);
            head = addNode(head, newNode);
        }

        return head;
    }

    public TreeNode addNode(TreeNode head, TreeNode newNode) {
        if (head != null) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);

            while (!queue.isEmpty()) {
                TreeNode visitedNode = queue.poll();
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
        } else {
            head = newNode;
        }
        return head;
    }

    public TreeNode recoverFromPreorder(String traversal, int depth) {
        int numDashes = 0;
        int val = 0;

        while (index < traversal.length() && traversal.charAt(index) == '-') {
            numDashes++;
            index++;
        }

        if (numDashes != depth) {
            index -= numDashes;
            return null;
        }

        while (index < traversal.length() && traversal.charAt(index) != '-') {
            val = val * 10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);

        if (index < traversal.length()) {
            node.left = recoverFromPreorder(traversal, depth + 1);
        }

        if (index < traversal.length()) {
            node.right = recoverFromPreorder(traversal, depth + 1);
        }

        return node;
    }

    private void leverOrderTraversal(TreeNode root) {
        if (root != null) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode visitedNode = queue.poll();
                System.out.print(visitedNode.val + ",");
                if (visitedNode.left != null) queue.offer(visitedNode.left);
                if (visitedNode.right != null) queue.offer(visitedNode.right);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
