package com.billkalin.sourcecode.question32;

public class Main {

    public static void main(String[] args) {
        int index = 1500;
        int uglyNum = getUglyNum(index);
        uglyNum = getUglyNum2(index);
        System.out.println("第" + index + "个丑数是：" + uglyNum);
    }


    private static boolean isUglyNum(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    private static int getUglyNum(int index) {
        if (index <= 0)
            return 0;
        int i = 0;
        int currNum = 0;
        while (i < index) {
            currNum++;
            if (isUglyNum(currNum)) {
                i++;
            }
        }
        return currNum;
    }

    private static int getUglyNum2(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int mark2 = 0;
        int mark3 = 0;
        int mark5 = 0;
        int currIndex = 1;
        while (currIndex < index) {
            int minUgly = Math.min(Math.min(uglyNumbers[mark2] * 2, uglyNumbers[mark3] * 3),
                    uglyNumbers[mark5] * 5);
            uglyNumbers[currIndex] = minUgly;
            if (uglyNumbers[mark2] * 2 == uglyNumbers[currIndex]) {
                mark2++;
            }

            if (uglyNumbers[mark3] * 3 == uglyNumbers[currIndex]) {
                mark3++;
            }

            if (uglyNumbers[mark5] * 5 == uglyNumbers[currIndex]) {
                mark5++;
            }

            currIndex++;
        }

        return uglyNumbers[index - 1];
    }
}
