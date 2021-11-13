package com.dsalgo.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArrayLeftNTimes {

    public static void main(String[] arg) {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateLeft(4, elements));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> result = new ArrayList<>(arr);
        int mod = d % arr.size();

        for (int i = 0; i < arr.size(); i++) {
            int index = ((i + mod) % arr.size());
            result.set(i, arr.get(index));
        }
        return result;
    }
}
