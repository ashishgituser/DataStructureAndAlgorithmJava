package com.dsalgo.tree.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieUsingHashMap {

    Node head;

    public static void main(String[] arg) {
        TrieUsingHashMap t = new TrieUsingHashMap();
        String[] strs = {"hello", "hell", "hellss"};
        System.out.println(t.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        // Dummy node
        head = new Node();

        // Prepare trie
        for (String s : strs) {
            insert(s);
        }

        StringBuilder lcp = new StringBuilder();
        Node curr = head;

        while (curr != null && !curr.isLeaf && (curr.character.size() == 1)) {
            for (Map.Entry entry : curr.character.entrySet()) {
                // append current char to LCP
                lcp.append(entry.getKey());

                // update `curr` pointer to the child node
                curr = (Node) entry.getValue();
            }
        }

        return lcp.toString();
    }

    public void insert(String str) {
        Node curr = head;
        for (Character c : str.toCharArray()) {
            curr.character.putIfAbsent(c, new Node());
            curr = curr.character.get(c);
        }
        curr.isLeaf = true;
    }

    class Node {
        boolean isLeaf;
        Map<Character, Node> character = new HashMap<>();
    }
}
