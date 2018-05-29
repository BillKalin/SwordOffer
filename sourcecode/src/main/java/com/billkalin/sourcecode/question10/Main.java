package com.billkalin.sourcecode.question10;

public class Main {

    public static void main(String[] args) {
        printMaxNum(2);
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

        printMaxNum2(3);
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
