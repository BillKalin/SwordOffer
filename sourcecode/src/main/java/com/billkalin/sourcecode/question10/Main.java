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

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append('0');
        }
        System.out.println("");
        while (!increment(n, stringBuffer)) {
            boolean begin = true;
            for (int i = 0; i < stringBuffer.length(); i++) {
                char ch = stringBuffer.charAt(i);
                if (begin && ch != '0') {
                    begin = false;
                }
                if (!begin) {
                    System.out.print(stringBuffer.charAt(i));
                }
            }
            System.out.println("");
        }
    }

    private static boolean increment(int n, StringBuffer stringBuffer) {
        for (int i = n - 1; i >= 0; i--) {
            int ch = stringBuffer.charAt(i) + 1;
            if (ch > '9') {
                if (i == 0) {
                    return true;
                }
                stringBuffer.setCharAt(i, '0');
            } else {
                stringBuffer.setCharAt(i, (char) ch);
                break;
            }
        }
        return false;
    }
}
