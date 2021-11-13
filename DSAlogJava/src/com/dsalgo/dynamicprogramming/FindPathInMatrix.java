package com.dsalgo.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindPathInMatrix {

    public static void main(String[] arg) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1},
        };
        System.out.println(isPathExists(grid));
        System.out.println(getPathList(grid));
    }

    public static List<String> getPathList(int[][] grid) {
        int sourceX = 0, sourceY = 0;
        Map<String, Integer> memo = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sourceX = i;
                    sourceY = j;
                }
            }
        }
        getPath(grid, sourceX, sourceY, memo);

        return new ArrayList<>(memo.keySet());
    }

    public static int isPathExists(int[][] grid) {
        int sourceX = 0, sourceY = 0, moves = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sourceX = i;
                    sourceY = j;
                    moves = moves + 1;
                }
                if (grid[i][j] == 0) {
                    moves = moves + 1;
                }
            }
        }
        return findPath(grid, sourceX, sourceY, moves);
    }

    public static int getPath(int[][] grid, int x, int y, Map<String, Integer> memo) {

        String key = (x + "-" + y);

        if (memo.containsKey(key)) return memo.get(key);

        if (x == 1 && y == 1) return 1;
        if (x == 0 && y == 0) return 0;

        if (grid[x][y] == 2) return 1;

        memo.put(key, getPath(grid, x + 1, y, memo) + getPath(grid, x, y + 1, memo));

        return memo.get(key);
    }

    public static int findPath(int[][] grid, int x, int y, int moves) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2 && moves == 0) return 1;

        int val = grid[x][y];
        grid[x][y] = -1;
        moves--;

        int possiblePathCount = findPath(grid, x, y - 1, moves) +
                findPath(grid, x, y + 1, moves) +
                findPath(grid, x - 1, y, moves) +
                findPath(grid, x + 1, y, moves);

        grid[x][y] = val;

        return possiblePathCount;
    }
}
