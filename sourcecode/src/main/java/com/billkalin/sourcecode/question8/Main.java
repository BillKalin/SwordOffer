package com.billkalin.sourcecode.question8;

public class Main {

    public static void main(String[] args) {
        int testNumber = 12;
        int count = getNumberOf1(testNumber);
        int count2 = getNumberOf1_2(testNumber);
        int count3 = getNumberOf1_3(testNumber);
        boolean expand1 = expand1(16);
        int modifyCount = changeBitCount(10, 13);
        System.out.println(testNumber + " 二进制表示中1的个数为：" + count + " & count2 = " + count2 + " & count3 = " + count3);
        System.out.println(" 8 是不是2的整数次方：" + expand1);
        System.out.println(" 10到13二进制位需要改变的位数：" + modifyCount);
    }

    /**
     * 有缺陷的解法
     *
     * @param n
     * @return
     */
    private static int getNumberOf1(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 较好的解法1
     *
     * @param n
     * @return
     */
    private static int getNumberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag <= n) {
            if ((n & flag) == flag) {
                count++;
            }
            flag = flag << 1;//标记左移1位，然后做与运算等于flag的话，那么就是数字1
        }
        return count;
    }

    /**
     * 较好的解法2
     *
     * @param n
     * @return
     */
    private static int getNumberOf1_3(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = (n - 1) & n;//整数减1和原数字做与运算，相当于把右边的1，变成0
        }
        return count;
    }

    /**
     * 判断一个整数是不是2的整数次方
     *
     * @param n
     * @return
     */
    private static boolean expand1(int n) {
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 输入一个整数m和n，计算m要改变二进制中多少位才能变成n
     *
     * @param m
     * @param n
     * @return
     */
    private static int changeBitCount(int m, int n) {
        //先做异或运算，得到对应位置需要改变的数字
        int modify = m ^ n;
        int count = 0;
        //计算异或运算后二进制中1的个数
        while (modify > 0) {
            count++;
            modify = modify & (modify - 1);
        }
        return count;
    }
}
