package com.dsalgo.hackerrank;

import java.util.List;

import static java.util.Arrays.asList;

public class HourGlassProblem {

    public static void main(String[] arg) {
        int[][] matrix = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        List<List<Integer>> matrix2 = asList(
                asList(-1, 1, -1, 0, 0, 0),
                asList(0, -1, 0, 0, 0, 0),
                asList(-1, -1, -1, 0, 0, 0),
                asList(0, -9, 2, -4, -4, 0),
                asList(-7, 0, 0, -2, 0, 0),
                asList(0, 0, -1, -2, -4, 0)
        );
        System.out.println(maxHourGlassSum(matrix2));

    }

    public static int maxHourGlassSum(List<List<Integer>> matrix) {
        int noOfRows = matrix.size();
        int noOfCols = matrix.get(0).size();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < noOfRows - 1; i++) {
            for (int j = 1; j < noOfCols - 1; j++) {
                int hourGlassSum = calculateHourGlassSum(matrix, i, j);
                if (max < hourGlassSum) max = hourGlassSum;
            }
        }
        return max;
    }

    public static int calculateHourGlassSum(List<List<Integer>> matrix, int n, int m) {
        return (matrix.get(n - 1).get(m - 1) + matrix.get(n - 1).get(m) + matrix.get(n - 1).get(m + 1)) + // Upper glass
                (matrix.get(n).get(m)) + // Middle glass
                (matrix.get(n + 1).get(m - 1) + matrix.get(n + 1).get(m) + matrix.get(n + 1).get(m + 1)); // Lower glass
    }
}
