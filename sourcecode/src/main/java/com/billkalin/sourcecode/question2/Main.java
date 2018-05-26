package com.billkalin.sourcecode.question2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] a = {'a', ' ', 'c', ' '};
        a = replaceWhitespace(a);
        System.out.print(Arrays.toString(a));

        int[] arr1 = {1,2,3,4,0,0,0,0};
        int[] arr2 = {5,6,7};

        arr1 = mergeSortedArray(arr1, 4, arr2, 3);
        System.out.println("合并后的有序数组：" + Arrays.toString(arr1));
    }

    private static char[] replaceWhitespace(char[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            int blankLength = 0;
            for (int i = 0; i < length; i++) {
                char ch = array[i];
                if (ch == ' ') {
                    blankLength++;
                }
            }

            int totalLen = 2 * blankLength + length;
            //这里使用了额外的空间，如果不能使用的话，
            // 需要假设这个字符串数组长度大于等于容纳替换后的长度
            char[] newArray = new char[totalLen];
            int p1 = length - 1;
            int p2 = totalLen - 1;
            while (p2 >= 0) {
                char ch = array[p1];
                if (ch == ' ') {
                    newArray[p2] = '0';
                    p2--;
                    newArray[p2] = '2';
                    p2--;
                    newArray[p2] = '%';
                } else {
                    newArray[p2] = ch;
                }
                p1--;
                p2--;
            }

            return newArray;
        }
        return array;
    }

    /**
     * 合并两个有序数组
     * 假设array1有足够的空间容纳array2的长度
     * 从尾部开始合并
     * @param array1 数组1，容量大于或等于len1+len2
     * @param len1   数组1有效数字长度
     * @param array2 数组2
     * @param len2   数组2 有效数字长度
     */
    private static int[] mergeSortedArray(int[] array1, int len1, int[] array2, int len2) {
        //做简单的检验
        if (array2 == null || array2.length == 0) {
            return array1;
        }

        if (array1 == null || array1.length == 0) {
            return array2;
        }

        int newLength = len1 + len2;
        if (newLength > array1.length) {
            return array1;
        }
        int newPointer = newLength - 1;
        int arrPointer1 = len1 - 1;
        int arrPointer2 = len2 - 1;

        while (arrPointer1 >= 0 && arrPointer2 >= 0) {
            if (array1[arrPointer1] >= array2[arrPointer2]) {
                array1[newPointer--] = array1[arrPointer1--];
            } else {
                array1[newPointer--] = array2[arrPointer2--];
            }
        }

        while (arrPointer1 >= 0) {
            array1[newPointer--] = array1[arrPointer1--];
        }

        while (arrPointer2 >= 0) {
            array1[newPointer--] = array2[arrPointer2--];
        }

        return array1;
    }
}
