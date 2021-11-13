package com.dsalgo.crackingthecode.chapter01.string;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {

    public static void main(String[] arg) {
        System.out.println(compressString("aabcccccaaa"));
    }

    public static String compressString(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            frequency.merge(str.charAt(i), 1, Integer::sum);
        }
        StringBuilder newStr = new StringBuilder();
        frequency.entrySet().stream().forEach(entry -> {
            newStr.append(entry.getKey() + "" + entry.getValue());
        });
        return newStr.toString();
    }
}
