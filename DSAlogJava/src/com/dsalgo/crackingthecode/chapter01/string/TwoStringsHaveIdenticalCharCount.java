package com.dsalgo.crackingthecode.chapter01.string;

public class TwoStringsHaveIdenticalCharCount {

    public static void main(String[] arg) {
        System.out.println(permutation("abcc", "abcc"));
    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] letters = new char[128];
        for (char c : s.toCharArray()) letters[c]++;

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }
}
