package com.billkalin.sourcecode.question9;

public class Main {

    public static void main(String[] args) {
        System.out.println("2的3次方 = " + power(2, -7));
    }

    private static double power(double base, int exponent) {
        //0 作为底数，无意义
        if (base > -0.0000001 && base < 0.0000001 && exponent < 0) {
            return 0.0;
        }

        //0次方，直接返回1，省去后面代码的执行
        if (exponent == 0) {
            return 1.0;
        }

        //考虑负数问题
        int absexponent = exponent;
        if (exponent < 0) {
            absexponent = -absexponent;
        }
        double ret = powerWithUnsigned2(base, absexponent);
        if (exponent < 0) {
            ret = 1.0 / ret;
        }
        return ret;
    }

    private static double powerWithUnsigned(double base, int exponent) {
        double ret = 1.0;
        for (int i = 1; i < exponent; i++) {
            ret *= base;
        }
        return ret;
    }

    /**
     * 较好的求一个整数次方
     * @param base
     * @param exponent
     * @return
     */
    private static double powerWithUnsigned2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double ret = powerWithUnsigned2(base, exponent >> 1);
        ret *= ret;
        if ((exponent & 0x1) == 1) {
            ret *= base;
        }

        return ret;
    }
}
