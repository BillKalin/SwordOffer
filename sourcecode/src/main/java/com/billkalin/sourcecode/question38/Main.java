package com.billkalin.sourcecode.question38;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] nums = findNumberAppearOnce(array);
        System.out.println("数组" + Arrays.toString(array) + "中只出现一次的数字是：" + Arrays.toString(nums));
    }

    private static int[] findNumberAppearOnce(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }

        if (array.length == 1) {
            return new int[]{array[0]};
        }

        int num = 0;
        for (int i = 0; i < array.length; i++) {
            num ^= array[i];
        }
        int index = 0;
        while (((num & 1) == 0) && index < 8) {
            num = num >> 1;
            ++index;
        }
        int num1 = 0, num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                num1 ^= array[i];
            } else {
                num2 ^= array[i];
            }
        }
        return new int[]{num1, num2};
    }

    private static boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
