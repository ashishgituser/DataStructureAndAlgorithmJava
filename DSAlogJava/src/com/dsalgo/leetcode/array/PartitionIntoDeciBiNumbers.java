package com.dsalgo.leetcode.array;

import java.util.Comparator;

public class PartitionIntoDeciBiNumbers {

    public static void main(String[] arg) {
        String str = "27346209830709182346";
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        return n.chars().mapToObj(Character::getNumericValue).max(Comparator.naturalOrder()).get();
    }
}
