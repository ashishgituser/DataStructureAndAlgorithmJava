package com.dsalgo.leetcode.topcompanies;

public class LongestCommonPrefix {

    public static void main(String[] arg) {
        String[] strs = {"doggg", "dogggg", "doggggg"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        int minLengthString = minLength(strs);
        String result = "";
        char current;

        for (int i = 0; i < minLengthString; i++) {
            current = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return result;
                }
            }

            result += current;
        }
        return result;
    }

    public static int minLength(String[] strs) {
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) min = strs[i].length();
        }
        return min;
    }
}
