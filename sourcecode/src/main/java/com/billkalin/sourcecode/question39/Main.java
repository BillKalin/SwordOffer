package com.billkalin.sourcecode.question39;

public class Main {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 4, 7, 11, 15};
        int s1 = 15;

        printTwoNumTotal(num1, s1);

        int s = 15;
        printNumTotal(s);
    }

    private static void printTwoNumTotal(int[] array, int s) {
        if (null == array || array.length == 0)
            return;

        int pre = 0;
        int last = array.length - 1;
        boolean found = false;
        while (pre < last) {
            int n1 = array[pre];
            int n2 = array[last];

            if (n1 + n2 > s) {
                last--;
            } else if (n1 + n2 < s) {
                pre++;
            } else {
                found = true;
                System.out.println("和为" + s + "的两个数字为：" + n1 + "," + n2);
                break;
            }
        }

        if (!found) {
            System.out.println("和为" + s + "的两个数字没有找到");
        }
    }

    private static void printNumTotal(int s) {
        if (s < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (s + 1) / 2;
        int currSum = small + big;
        while (small < middle) {
            if (currSum == s) {
                printSum(small, big);
            }

            while (currSum > s && small < middle) {
                currSum -= small;
                small ++;
                if (currSum == s) {
                    printSum(small, big);
                }
            }

            big ++;
            currSum += big;
        }
    }

    private static void printSum(int s, int b) {
        for (int i = s; i <= b; i++) {
            System.out.print("" + i);
        }
        System.out.println("");
    }
}
