package com.billkalin.sourcecode.question18;

public class Main {

    public static void main(String[] args) {
        int[][] array = {
//                {1}//case 1
//                {1},
//                {2},
//                {3}//case 2
//                {1, 2, 3,},
//                {5, 6, 7},
//                {9, 10, 11},//case 3
                {1, 2},
                {5, 6},//case 4
        };
        printArray(array);
        System.out.print("\n");
        printArray2(array);
    }

    private static void printArray(int[][] array) {
        if (null == array)
            return;
        int minCol, minRow, maxCol, maxRow;
        minCol = 0;
        minRow = 0;
        maxCol = array[0].length - 1;
        maxRow = array.length - 1;

        if (maxCol < 0 || maxRow < 0)
            return;

        while (true) {
            if (minCol > maxCol && minRow > maxRow) {
                break;
            }

            //从左到右
            for (int i = minCol; i <= maxCol; i++) {
                System.out.print(array[minRow][i] + ",");
            }

            //从上到下
            for (int i = minRow + 1; i <= maxRow; i++) {
                System.out.print(array[i][maxCol] + ",");
            }

            //从右到左
            if (minRow != maxRow) {
                for (int i = maxCol - 1; i >= minCol; i--) {
                    System.out.print(array[maxRow][i] + ",");
                }
            }

            //从下到上
            if (minCol != maxCol) {
                for (int i = maxRow - 1; i >= minRow + 1; i--) {
                    System.out.print(array[i][minCol] + ",");
                }
            }

            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
    }

    private static void printArray2(int[][] array) {
        if (null == array)
            return;
        int cols = array[0].length;
        int rows = array.length;

        if (cols <= 0 || rows <= 0)
            return;

        int start = 0;
        while (start * 2 < cols && start * 2 < rows) {
            printByCircle(array, start, cols, rows);
            start++;
        }
    }

    private static void printByCircle(int[][] array, int start, int cols, int rows) {
        int endCols = cols - start - 1;
        int endRows = rows - start - 1;
        //从左到右
        for (int i = start; i <= endCols; i++) {
            System.out.print(array[start][i] + ",");
        }
        //从上到下
        if (start < endRows) {
            for (int i = start + 1; i <= endRows; i++) {
                System.out.print(array[i][endCols] + ",");
            }
        }
        //从右到左
        if (start < endCols && start < endRows) {
            for (int i = endRows - 1; i >= start; i--) {
                System.out.print(array[endRows][i] + ",");
            }
        }
        //从下往上
        if (start < endCols && start < endRows - 1) {
            for (int i = endRows - 1; i >= start + 1; i--) {
                System.out.print(array[i][start] + ",");
            }
        }
    }
}
