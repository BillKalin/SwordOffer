package com.billkalin.sourcecode.question12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 3, 6, 8, 7, 5, 2, 9};
        System.out.println("调整前：" + Arrays.toString(array));
//        changeNum(array);
        changeNum2(array);
//        changeNum3(array);
//        changeNum4(array);
        System.out.println("调整后：" + Arrays.toString(array));
    }

    /**
     * 基于数组遍历解法
     *
     * @param array
     */
    private static void changeNum(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }

        int size = array.length;
        int index = 0;
        for (int i = 0; i < size; i++) {
            int curr = array[i];
            if ((curr & 0x01) == 0) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = curr;
                i -= 1;//这里使要注意，有可能连续两个都是偶数，需要重新从原来的位置开始遍历
                index += 1;
                if (index == size) {
                    //这里注意，最多需要挪动数组大小的次数。因为无法判断到底有多少个偶数和奇数。
                    break;
                }
            }
        }
    }

    /**
     * 两个指针遍历
     *
     * @param array
     */
    private static void changeNum2(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (start < end && (array[start] & 0x01) == 1) {
                start++;
            }

            while (start < end && (array[end] & 0x01) == 0) {
                end--;
            }

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 扩展题目解法1
     * 借鉴冒泡排序算法
     * 比较相邻两个数字，前偶数后奇数，则交换
     */
    private static void changeNum3(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }

        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                if ((array[j] & 0x1) == 1 && (array[j - 1] & 0x1) == 0) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 扩展题目解法2
     * 使用额外的空间保存偶数，然后进行合并
     */
    private static void changeNum4(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if ((array[i] & 0x1) == 1) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }

        list1.addAll(list2);
        for (int i = 0; i < size; i++) {
            array[i] = list1.get(i);
        }
    }
}
