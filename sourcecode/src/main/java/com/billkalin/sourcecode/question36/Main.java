package com.billkalin.sourcecode.question36;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        int count = getCountOfk(array, k);
        System.out.println("数字：" + k + " 在数组" + Arrays.toString(array) + "出现了" + count + "次");
    }

    private static int getCountOfk(int[] array, int k) {
        if (null == array || array.length == 0)
            return 0;
        if (array.length == 1) {
            return array[0] == k ? 1 : 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        if (firstK >= 0 && lastK >= 0) {
            return lastK - firstK + 1;
        }

        return 0;
    }

    private static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int middle = (start + end) / 2;
        if (array[middle] == k) {
            if ((middle - 1 >= 0 && array[middle - 1] != k) || middle == 0) {
                return middle;
            } else {
                return getFirstK(array, k, start, middle - 1);
            }
        } else if (array[middle] > k) {
            return getFirstK(array, k, start, middle - 1);
        }
        return getFirstK(array, k, middle + 1, end);
    }

    private static int getLastK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int middle = (start + end) / 2;
        if (array[middle] == k) {
            if ((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1) {
                return middle;
            } else {
                return getLastK(array, k, middle + 1, end);
            }
        } else if (array[middle] > k) {
            return getLastK(array, k, start, middle - 1);
        }
        return getLastK(array, k, middle + 1, end);
    }
}
