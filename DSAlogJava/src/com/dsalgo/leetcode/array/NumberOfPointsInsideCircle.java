package com.dsalgo.leetcode.array;

import java.util.Arrays;

public class NumberOfPointsInsideCircle {

    public static void main(String[] arg) {
        int[][] points = {{99,113},{150,165},{23,65},{175,154},{84,83},{24,59},{124,29},{19,97},{117,182},{105,191},{83,117},{114,35},{0,111},{22,53}};
        int[][] queries = {{105,191,155},{114,35,94},{84,83,68},{175,154,28},{99,113,80},{175,154,177},{175,154,181},{114,35,134},{22,53,105},{124,29,164},{6,99,39},{84,83,35}};
        int[] result = countPoints(points, queries);
        System.out.println(Arrays.toString(result));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = countPointsInsideCircle(queries[i], points);
        }
        return result;
    }

    public static int countPointsInsideCircle(int[] circle, int[][] points) {
        double radius = Math.pow(circle[2], 2);
        int[] point;
        int pointsInsideCircle = 0;

        for (int i = 0; i < points.length; i++) {
            point = points[i];
            System.out.println((Math.pow((point[0] - circle[0]), 2) + Math.pow((point[1] - circle[1]), 2)) + " : " + radius);
            if ((Math.pow((point[0] - circle[0]), 2) + Math.pow((point[1] - circle[1]), 2)) <= radius) {
                pointsInsideCircle++;
            }
        }
        return pointsInsideCircle;
    }
}
