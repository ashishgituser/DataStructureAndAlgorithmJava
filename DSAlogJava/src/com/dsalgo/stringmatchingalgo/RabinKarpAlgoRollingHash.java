package com.dsalgo.stringmatchingalgo;

public class RabinKarpAlgoRollingHash {


    public static void main(String[] arg) {
        findPattern("ababbbbaabcba", "cba");
    }

    public static void findPattern(String inputStr, String pattern) {
        int strLength = inputStr.length();
        int patternLength = pattern.length();

        int sHash = 0;
        int pHash = 0;

        int i, j = patternLength - 1;

        for (i = 0; i < patternLength; i++) {
            pHash += ((pattern.charAt(i) - 'a' + 1) * (10 * j)) % 113;
            sHash += ((inputStr.charAt(i) - 'a' + 1) * (10 * j)) % 113;
            j--;
        }

        for (i = 0; i < (strLength - patternLength); i++) {

            if (sHash == pHash) {
                System.out.println("Pattern found.");
            }

            sHash = (sHash - ((inputStr.charAt(i) - 'a' + 1) * (10 * patternLength - 1))) * 10 +
                    (inputStr.charAt(i + patternLength - 1) - 'a' + 1);
        }
    }

}
