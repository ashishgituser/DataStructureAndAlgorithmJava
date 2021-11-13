package com.dsalgo.leetcode.matrix;

public class UniquePathsInMatrix {

    int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] arg) {
        UniquePathsInMatrix up = new UniquePathsInMatrix();
        int[][] grid = {
                {1,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  2, -1},
        };

        System.out.println(up.uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {

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

        return findAllPossiblePaths(grid, sourceX, sourceY, moves);
    }

    public int findPath(int[][] grid, int sourceX, int sourceY, int moves) {

        if (sourceX < 0 || sourceY < 0 || sourceX >= grid.length || sourceY >= grid[0].length || grid[sourceX][sourceY] == -1)
            return 0;

        if (grid[sourceX][sourceY] == 2 && moves == 0) return 1;

        grid[sourceX][sourceY] = -1;
        moves--;

        int path1 = findPath(grid, sourceX + 1, sourceY, moves);
        int path2 = findPath(grid, sourceX - 1, sourceY, moves);
        int path3 = findPath(grid, sourceX, sourceY + 1, moves);
        int path4 = findPath(grid, sourceX, sourceY - 1, moves);

        System.out.println(path1 + " : " + path2 + " : " + path3 + " : " + path4);

        grid[sourceX][sourceY] = 0;
        moves++;

        return path1;
    }

    public int findAllPossiblePaths(int[][] grid, int sourceX, int sourceY, int moves) {

        if (grid[sourceX][sourceY] == 2 && moves == 0) return 1;

        int val = grid[sourceX][sourceY];
        grid[sourceX][sourceY] = -1;
        moves--;

        int count = 0;

        for (int[] d : direction) {
            int r = sourceX + d[0];
            int c = sourceY + d[1];

            if (isValid(grid, r, c)) {
                count += findAllPossiblePaths(grid, r, c, moves);
            }
        }

        grid[sourceX][sourceY] = val; // Backtrack, reset to original.

        return count;
    }

    public boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != -1;
    }
}
