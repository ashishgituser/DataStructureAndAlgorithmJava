package com.dsalgo.leetcode.topcompanies;

import java.util.HashMap;
import java.util.Map;


/*
Solution
=============

Bes solution is to start from the end of the given string.
check the current character and previous characters and satisfy the below conditions.

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.


 */

public class RomanToInteger {

    public static void main(String[] arg) {
        System.out.println(romanToInt2("XIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if ((currentChar == 'V' || currentChar == 'X') && i > 0 && s.charAt(i - 1) == 'I') sum -= 2;
            if ((currentChar == 'L' || currentChar == 'C') && i > 0 && s.charAt(i - 1) == 'X') sum -= 20;
            if ((currentChar == 'D' || currentChar == 'M') && i > 0 && s.charAt(i - 1) == 'C') sum -= 200;
            sum += roman.get(currentChar);
        }

        return sum;
    }

    public static int romanToInt2(String s) {
        int sum = 0;
        char prev = '?';

        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            switch (current) {
                case 'I': sum += prev == 'X' || prev == 'V' ? -1 : 1; break;
                case 'X': sum += prev == 'L' || prev == 'C' ? -10 : 10; break;
                case 'C': sum += prev == 'D' || prev == 'M' ? -100 : 100; break;
                case 'V': sum += 5; break;
                case 'L': sum += 50; break;
                case 'D': sum += 500; break;
                case 'M': sum += 1000; break;
                default: break;
            }
            prev = current;
        }
        return sum;
    }
}
