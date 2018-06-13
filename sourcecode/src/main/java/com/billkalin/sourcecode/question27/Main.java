package com.billkalin.sourcecode.question27;

import com.billkalin.sourcecode.common.Utils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int num = findHalfNum(array);
        System.out.println("arr = " + Arrays.toString(array) + " & 出现次数超过数组长度一半的数字是：" + num);
    }

    private static int findHalfNum(int[] array) {
        if (null == array || array.length == 0)
            return 0;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, array.length, start, end);
        int middle = array.length >> 1;
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(array, array.length, start, end);
            } else {
                start = index + 1;
                index = partition(array, array.length, start, end);
            }
        }

        int result = array[middle];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count * 2 <= array.length) {
            result = 0;
        }
        return result;
    }

    private static int partition(int[] array, int len, int start, int end) {
        if (end >= len || start < 0)
            return start;

        int index = start + (int) (Math.random() * (end - start + 1));
        Utils.swap(array, index, end);

        int small = start - 1;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                if (small != index) {
                    Utils.swap(array, small, index);
                }
            }
        }
        small++;
        Utils.swap(array, index, small);
        return small;
    }
}
