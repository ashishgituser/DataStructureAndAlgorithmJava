package com.dsalgo.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class ArrayManipulation {
    public static void main(String[] arg) throws IOException {
        URL path = ArrayManipulation.class.getResource("input.txt");
        File filePath = new File(path.getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);



        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                List<Integer> query = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
                queries.add(query);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(arrayManipulationTimeLimitExceed(n, queries));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] data = new long[n];
        AtomicLong max = new AtomicLong();

        queries.parallelStream().forEach(query -> {
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int k = query.get(2);

            System.out.println(k);
        });

        return max.get();
    }

    public static long arrayManipulationTimeLimitExceed(int n, List<List<Integer>> queries) {
        long[] data = new long[n];

        for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0) - 1;
            int b = queries.get(i).get(1) - 1;
            int k = queries.get(i).get(2);

            addNumbersToSegment(data, n, a, b, k);
        }
        return findMaxNumber(data, n);
    }

    public static void addNumbersToSegment(long[] segment, int n, int low, int high, int number) {
        segment[low] += number;
        if (high != n - 1) {
            segment[high + 1] -= number;
        }
    }

    public static long findMaxNumber(long[] segment, int n) {
        long max = 0;
        for (int i = 1; i < n; i++) {
            segment[i] += segment[i - 1];
            if (max < segment[i]) max = segment[i];
        }
        return max;
    }
}
