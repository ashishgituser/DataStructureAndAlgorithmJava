package com.dsalgo.leetcode.topcompanies;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    TriNode root;

    public static void main(String[] arg) {
        WordBreak wb = new WordBreak();
        List<String> dict = Arrays.asList("cats","dog","sand","and","cat");
        String word = "catsandog";
        System.out.println(wb.wordBreak(word, dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TriNode('\0');

        prepareTrie(wordDict);

        TriNode curr = root;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            curr = curr.characters[s.charAt(i) - 'a'];
            System.out.println(curr.c);
            if (curr.c == s.charAt(i)) {
                count++;
            }
        }
        return count == s.length();
    }

    public void prepareTrie(List<String> wordDict) {
        TriNode curr = root;
        for (String s : wordDict) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (curr.characters[c - 'a'] == null) curr.characters[c - 'a'] = new TriNode(c);
                curr = curr.characters[c - 'a'];
            }
            curr.isWord = true;
        }
    }

    class TriNode {
        char c;
        boolean isWord;
        TriNode[] characters;

        public TriNode(char c) {
            this.c = c;
            this.isWord = false;
            characters = new TriNode[26];
        }
    }
}
