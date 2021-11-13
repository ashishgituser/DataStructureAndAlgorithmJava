package com.dsalgo.sorting;

/*
About Radix Sort and how it works
==================================

1. Makes assumptions about the data.
2. Data must have same radix and with
   radix -> if we are sorting digit then radix will be 10, because we can have 0-9 digits.
            if we are sorting characters then radix will be 26, because we can have 26 characters.
            if we are sorting binary numbers then radix will be 2, because we can have only 0-1.
   with -> width depends on individual digit or string
           number (23422) will have width -> 5
           string "hello" will have with -> 5
3. Because of this, data must be integers or strings.
4. Sort based on each individual digit or letter position.
5. Start at the right most position.
6. Must use a stable sort algorithm at each stage.

Complexity
=================



 */
public class RadixSort {
}
