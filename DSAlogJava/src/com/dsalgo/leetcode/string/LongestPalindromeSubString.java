package com.dsalgo.leetcode.string;

public class LongestPalindromeSubString {

    public static void main(String[] arg) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String divide(char[] s, int low, int high) {
        if (low == high) return String.valueOf(s[low]);

        int mid = low + (high - low) / 2;

        System.out.println(mid);

        String leftSubString = divide(s, low, mid);
        String rightSubString = divide(s, mid + 1, high);

        String concat = concatSubStrings(s, low, mid, high);

        System.out.println(leftSubString + " : " + rightSubString + " : " + concat);

        return concat.length() > leftSubString.length() ? concat : leftSubString.length() > rightSubString.length() ? leftSubString : rightSubString;
    }

    public static String concatSubStrings(char[] s, int low, int mid, int high) {
        String leftSubString = new String(s, low, (mid - low) + 1);
        String rightSubString = new String(s, mid + 1, (high - (mid + 1) + 1));
        String concatString = (leftSubString + rightSubString);
        String reverse = new StringBuilder(concatString).reverse().toString();

        System.out.println(concatString + " -> " + reverse);
        return reverse.equals(concatString) ? concatString : "";
    }

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        return divide(arr, 0, arr.length - 1);
    }
}
