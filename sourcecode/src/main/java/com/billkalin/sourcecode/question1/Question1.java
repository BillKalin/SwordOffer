package com.billkalin.sourcecode.question1;

public class Question1 {

    public static void main(String[] args) {
        int[][] testArray = {
                {1, 2, 8, 9},
                {2, 4, 9, 2},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };
        boolean found = findNumber(testArray, 3);
        System.out.println("found = " + found);
    }

    private static boolean findNumber(int[][] array, int targetValue) {
        if (null != array && array.length > 0) {
            int cols = array.length - 1;
            int row = cols;
            int col = 0;
            while (col <= cols && row >= 0) {
                if (array[row][col] == targetValue) {
                    return true;
                } else if (array[row][col] > targetValue) {
                    row --;
                } else {
                    col ++;
                }
            }
        }
        return false;
    }
}
