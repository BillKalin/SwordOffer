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

        for (int i = 0; i < num; i++) {
            System.out.print(i + ",");
        }
    }

    private static void printMaxNum2(int n) {
        if (n <= 0) {
            return;
        }
    }
}
