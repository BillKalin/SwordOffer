package com.billkalin.sourcecode.question34;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};

        int count = getCount(array, 0, array.length - 1);

        System.out.println("数组:" + Arrays.toString(array) + " 逆序对的个数为：" + count);
    }

    private static int getCount(int[] array, int start, int end) {
        if (start == end)
            return 0;

        int mid = (end + start) / 2;
        int leftCount = getCount(array, start, mid);
        int rightCount = getCount(array, mid + 1, end);

        return leftCount + rightCount + merge(array, start, mid, end);
    }

    private static int merge(int[] array, int left, int mid, int right) {
        int[] newArr = new int[right - left + 1];
        int start = left;
        int end = mid + 1;
        int i = 0;
        int count = 0;
        while (start <= mid && end <= right) {
            if (array[start] < array[end]) {
                newArr[i++] = array[start];
                start++;
            } else {
                count += end - mid;
                newArr[i++] = array[end];
                end++;
            }
        }

        while (start <= mid) {
            newArr[i++] = array[start];
            start++;
        }

        while (end <= right) {
            newArr[i++] = array[end];
            end++;
        }

        for (int j = 0; i < newArr.length; j++) {
            array[start + j] = newArr[j];
        }
        return count;
    }
}
