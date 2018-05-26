package com.billkalin.sourcecode.question6;

public class Question6 {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 0, 1};//array = {1, 1, 1, 0, 1};
        System.out.println("min = " + findRotateArrayMin(array));
    }

    private static int findRotateArrayMin(int[] array) {
        if (null == array || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            //当第一个指针和第二个指向数字相等，并且中间的数字也相等，那就顺序查找。
            if (array[start] == array[end] && array[start] == array[mid]) {
                return min(array, start, end);
            }
            //中间数字比第一个指针指向的大，那么把第一个指针指向中间
            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                //中间数字比第二个指针指向的大，那么把第二个指针指向中间
                end = mid;
            }
        }
        return array[mid];
    }

    private static int min(int[] array, int start, int end) {
        int ret = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (ret > array[i]) {
                ret = array[i];
            }
        }
        return ret;
    }
}
