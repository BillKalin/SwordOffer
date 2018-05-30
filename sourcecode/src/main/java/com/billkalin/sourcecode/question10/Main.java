package com.billkalin.sourcecode.question10;

public class Main {

    public static void main(String[] args) {
        printMaxNum(2);//暴力遍历
        printMaxNum2(3);//使用数组保存对应位的数字
        printMaxNum3(3);//使用递归方式
    }

    private static void printMaxNum(int n) {
        if (n <= 0) {
            return;
        }

        int num = 1;
        int bit = 1;
        while (bit <= n) {
            num *= 10;
            bit++;
        }

        for (int i = 1; i < num; i++) {
            System.out.print(i + ",");
        }
    }

    private static void printMaxNum2(int n) {
        if (n <= 0) {
            return;
        }

        int[] numArr = new int[n];

        System.out.println("");
        while (!increment(n, numArr)) {
            printNum(numArr);
        }
    }

    /**
     * 使用数组保存对应位置的数字，同时考虑了进位的问题
     * @param n
     * @param numArr
     * @return
     */
    private static boolean increment(int n, int[] numArr) {
        for (int i = n - 1; i >= 0; i--) {
            int num = numArr[i] + 1;
            if (num > 9) {
                if (i == 0) {
                    return true;
                }
                numArr[i] = 0;
            } else {
                numArr[i] = num;
                break;
            }
        }
        return false;
    }

    private static void printMaxNum3(int n) {
        if (n <= 0) {
            return;
        }

        int[] numArr = new int[n];
        printMaxNum3(numArr, 0, n);
        System.out.println("");
    }

    /**
     * 使用递归方式,产生全排列
     * @param arr
     * @param index
     * @param len
     */
    private static void printMaxNum3(int[] arr, int index, int len) {
        if (index == len - 1) {
            printNum(arr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            arr[index + 1] = i;
            printMaxNum3(arr, index + 1, len);
        }
    }

    private static void printNum(int[] numArr) {
        boolean begin = true;
        for (int i = 0; i < numArr.length; i++) {
            int num = numArr[i];
            if (begin && num != 0) {
                begin = false;
            }
            if (!begin) {
                System.out.print(num);
            }
        }
        System.out.println("");
    }
}
