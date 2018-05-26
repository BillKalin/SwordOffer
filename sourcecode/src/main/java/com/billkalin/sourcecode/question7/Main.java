package com.billkalin.sourcecode.question7;

public class Main {

    public static void main(String[] args) {
        long i = fabonacci(5);
        long j = fabonacci2(5);

        System.out.print("fabonacci = " + i + " & fabonacci2 = " + j);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    private static long fabonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fabonacci(n - 1 ) + fabonacci(n - 2);
    }

    /**
     * 使用临时变量
     * @param n
     * @return
     */
    private static long fabonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        long i = 0;
        long j = 1;
        long ret = 0;
        int index = 0;
        while (index <= n - 2) {
            ret = i + j;
            i = j;
            j = ret;
            index++;
        }

        return ret;
    }
}
