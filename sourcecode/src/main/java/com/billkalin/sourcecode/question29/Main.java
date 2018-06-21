package com.billkalin.sourcecode.question29;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int maxSub = getMaxSubArray(array);
        System.out.println("数组:" + Arrays.toString(args) + " 最大的连续子数组的和是:" + maxSub);
    }

    private static int getMaxSubArray(int[] array) {
        if (null == array || array.length == 0)
            return 0;
        if (array.length == 1) {
            return array[0];
        }

        int currMax = 0;
        int mMaxNum = 0;

        for (int i = 0; i < array.length; i++) {
            if (currMax <= 0) {
                currMax = array[i];
            } else {
                currMax += array[i];
            }

            if (currMax > mMaxNum) {
                mMaxNum = currMax;
            }
        }

        return mMaxNum;
    }
}
