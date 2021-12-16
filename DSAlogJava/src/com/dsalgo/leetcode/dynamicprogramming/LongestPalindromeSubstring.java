package com.dsalgo.leetcode.dynamicprogramming;

public class LongestPalindromeSubstring {

    static String result = "";

    public static void main(String[] arg) {
        String str = "cbbd";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String str) {
        if (isPalindrome(str)) return str;

        for (int i = str.length(); i >= 0; i--) {
            if (result.length() > 0) break;
            getMaxLengthPalindrome(str, i);
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static String maxLengthPalindrome(String str, String result, int i, int pairSize) {
        if (i + pairSize > str.length()) return result;

        String subString = str.substring(i, i + pairSize);

        if (isPalindrome(subString)) {
            if (subString.length() >= result.length()) result = subString;
        }
        return maxLengthPalindrome(str, result, i + 1, pairSize);
    }

    public static void getMaxLengthPalindrome(String str, int pairSize) {
        for (int j = 0; j < str.length(); j++) {
            if (j + pairSize > str.length()) break;
            String subString = str.substring(j, j + pairSize);
            if (isPalindrome(subString)) {
                result = subString; break;
            }
        }
    }
}
