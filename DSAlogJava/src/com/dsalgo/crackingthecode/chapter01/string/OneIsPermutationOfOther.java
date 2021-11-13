package com.dsalgo.crackingthecode.chapter01.string;

import java.util.Arrays;

public class OneIsPermutationOfOther {

    public static void main(String[] arg) {
        System.out.println(isPermutation("abc", "cba"));
    }

    public static String sortString(String str) {
        char[] strA = str.toCharArray();
        Arrays.sort(strA);
        return new String(strA);
    }

    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) return false;
        return sortString(s).equals(sortString(t));
    }
}
