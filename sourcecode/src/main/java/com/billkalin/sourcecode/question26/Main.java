package com.billkalin.sourcecode.question26;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str = "abc";
        getAllStr(str.toCharArray(), 0);
    }

    private static void getAllStr(char[] str, int start) {
        if (null == str || str.length == 0) {
            return;
        }

        if (start == str.length) {
            System.out.println(Arrays.toString(str));
            return;
        }

        for (int i = start; i < str.length; i++) {
            swap(str, i, start);
            getAllStr(str, start + 1);
            swap(str, i, start);
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
