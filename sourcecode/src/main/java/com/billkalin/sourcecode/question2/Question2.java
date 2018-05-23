package com.billkalin.sourcecode.question2;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        char[] a = {'a',' ', 'c', ' '};
        a = replaceWhitespace(a);
        System.out.print(Arrays.toString(a));
    }

    private static char[] replaceWhitespace(char[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            int blankLength = 0;
            for (int i = 0; i < length; i++) {
                char ch = array[i];
                if (ch == ' ') {
                    blankLength ++;
                }
            }

            int totalLen = 2 * blankLength + length;
            char[] newArray = new char[totalLen];
            int p1 = length - 1;
            int p2 = totalLen - 1;
            while (p2 >= 0) {
                char ch = array[p1];
                if (ch == ' ') {
                    newArray[p2] = '0';
                    p2--;
                    newArray[p2] = '2';
                    p2--;
                    newArray[p2] = '%';
                } else {
                    newArray[p2] = ch;
                }
                p1--;
                p2 --;
            }

            return newArray;
        }
        return array;
    }
}
