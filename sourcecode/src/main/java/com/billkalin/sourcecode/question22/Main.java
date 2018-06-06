package com.billkalin.sourcecode.question22;

public class Main {

    public static void main(String[] args) {

        int[] afterOrder = {5, 7, 6, 9, 11, 10, 8};

        boolean isAfterOrder = isAfterOrder(afterOrder, 0, afterOrder.length - 1);

        System.out.print("isAfterOrder = " + isAfterOrder);
    }

    private static boolean isAfterOrder(int[] array, int start, int end) {
        if (array == null || array.length == 0)
            return false;

        if (start >= end)
            return true;

        int root = array[end];
        int i = start;
        for (; i < end; i++) {
            if (array[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (array[j] < root) {
                return false;
            }
        }

        boolean left = true;
        boolean right = true;
        if (i > start) {
            left = isAfterOrder(array, start, i - 1);
        }

        if (i < end) {
            right = isAfterOrder(array, i, end - 1);
        }

        return left && right;
    }
}
