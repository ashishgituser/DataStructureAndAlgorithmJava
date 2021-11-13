package com.dsalgo.hackerrank;

import java.util.*;

public class SparseArray {

    public static void main(String[] arg) {
        List<String> strings = Arrays.asList("abcde",
                "sdaklfj",
                "asdjf",
                "na",
                "basdn",
                "sdaklfj",
                "asdjf",
                "na",
                "asdjf",
                "na",
                "basdn",
                "sdaklfj",
                "asdjf");
        List<String> queries = Arrays.asList("abcde",
                "sdaklfj",
                "asdjf",
                "na",
                "basdn");
        System.out.println(matchingStrings(strings, queries));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        strings.forEach(string -> {
            frequencyMap.putIfAbsent(string, 0);
            frequencyMap.put(string, frequencyMap.get(string) + 1);
        });

        queries.forEach(query -> {
            Integer frequency = frequencyMap.get(query);
            result.add(Objects.nonNull(frequency) ? frequency : 0);
        });

        return result;
    }
}
