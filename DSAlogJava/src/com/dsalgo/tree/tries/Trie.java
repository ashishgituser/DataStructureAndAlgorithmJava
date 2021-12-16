package com.dsalgo.tree.tries;

public class Trie {

    Node root;
    int nodeIndex;

    public static void main(String[] arg) {
        Trie t = new Trie();
        String[] strs = {"hello", "hell", "hellss"};
        System.out.println(t.longestString(strs));
    }

    public String longestString(String[] strs) {
        root = new Node('\0');

        // Preparing tries
        for (String s: strs) {
            insert(s);
        }

        StringBuilder lcp = new StringBuilder();
        Node curr = root;

        // loop until we find a leaf node or a node has more than 1 child
        while (curr != null && !curr.isLeaf && (countChild(curr) == 1))
        {
            curr = curr.children[nodeIndex];
            lcp.append(curr.c);
        }

        return lcp.toString();
    }

    public void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            } else {
                curr.wordCount++;
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }

    public int countChild(Node node) {
        int count = 0;
        for (int i=0; i<node.children.length; i++) {
            if (node.children[i] != null) {
                count++;
                nodeIndex = i;
            }
        }
        return count;
    }

    class Node {
        char c;
        int wordCount;
        boolean isLeaf;
        Node[] children;

        public Node(char c) {
            this.c = c;
            this.wordCount = 1;
            this.isLeaf = false;
            this.children = new Node[26];
        }
    }
}
