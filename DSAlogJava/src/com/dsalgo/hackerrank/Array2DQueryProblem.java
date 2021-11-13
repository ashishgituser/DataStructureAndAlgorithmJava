package com.dsalgo.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Array2DQueryProblem {

    public static void main(String[] arg) throws IOException, URISyntaxException {

        URL path = Array2DQueryProblem.class.getResource("input.txt");
        File filePath = new File(path.getFile());
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String[] firstMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(br.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        List<Integer> resultArray = dynamicArray(n, queries);

        System.out.println(resultArray);
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        Map<Integer, List<Integer>> problemArray = new HashMap<>();
        List<Integer> resultArray = new ArrayList<>();

        int lastAnswer = 0;

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> query = queries.get(i);

            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int idx = ((x ^ lastAnswer) % n);
            int size = problemArray.get(idx) != null ? problemArray.get(idx).size() : 0;

            if (queryType == 1) {
                addData(problemArray, idx, y);
            }

            if (queryType == 2) {
                if (size > 0) {
                    int location = (y % problemArray.get(idx).size());
                    lastAnswer = problemArray.get(idx).get(location);
                    resultArray.add(lastAnswer);
                }
            }
        }

        return resultArray;
    }

    public static void addData(Map<Integer, List<Integer>> result, int key, int value) {
        List<Integer> data = result.get(key);
        if (Objects.isNull(data)) {
            data = new ArrayList<>();
        }
        data.add(value);
        result.put(key, data);
    }
}
