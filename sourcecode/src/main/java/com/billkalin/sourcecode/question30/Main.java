package com.billkalin.sourcecode.question30;

public class Main {

    public static void main(String[] args) {
        int n = 12;

        int count = numberOf1Between1AndN(n);

        System.out.println("从1到" + n + " 1出现的次数我为：" + count);
    }


    private static int numberOf1Between1AndN(int n) {
        if (n < 1)
            return 0;
        if (n <= 9) {
            return 1;
        }
        int count = 0;
        int high = 0;
        int k = 0;
        int i = 1;
        int curr = 0;
        for (; (k = n / i) > 0; i *= 10) {
            high = k / 10;
            count += high * i;
            curr = k % 10;
            if (curr > 1) {
                count += i;
            } else if (curr == 1) {
                count += n - k * i + 1;
            }
        }

        return count;
    }
}
