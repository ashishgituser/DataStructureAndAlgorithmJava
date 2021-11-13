package com.dsalgo.leetcode.array;

public class SubRectangleQueriesMatrixUpdate {

    int[][] rectangle;

    public SubRectangleQueriesMatrixUpdate(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public static void main(String[] arg) {
        int[][] rectangle = {
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };
        SubRectangleQueriesMatrixUpdate sb = new SubRectangleQueriesMatrixUpdate(rectangle);
        sb.updateSubrectangle(0, 0, 3, 2, 5);
        sb.printMatrix();
        int val = sb.getValue(0, 2);
        System.out.println(val);
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }

    public void printMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.rectangle[i][j] + ",");
            }
            System.out.println();
        }
    }

}
