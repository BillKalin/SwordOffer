package com.billkalin.sourcecode.question28;

import com.billkalin.sourcecode.common.Utils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] smallArray = findKnum(array, k);
        System.out.println("数组:" + Arrays.toString(array) + " 最小的" + k + "个数是：" + Arrays.toString(smallArray));
    }

    private static int[] findKnum(int[] array, int k) {
        if (null == array || array.length == 0 || array.length < k)
            return new int[]{};

        int[] retArray = new int[k];
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            retArray[i] = array[i];
        }
        return retArray;
    }

    private static int partition(int[] array, int start, int end) {
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
        Utils.swap(array, small, index);
        return small;
    }
}
