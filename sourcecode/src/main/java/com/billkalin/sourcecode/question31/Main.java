package com.billkalin.sourcecode.question31;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        int[] array = {3, 32, 321};

        printMinNum(array);
    }

    private static void printMinNum(int[] array) {
        if (null == array || array.length == 0)
            return;
        if (array.length == 1) {
            System.out.println("" + array[0]);
            return;
        }

        Integer[] intes = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            intes[i] = array[i];
        }

        Arrays.sort(intes, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {

                String str1 = integer + ""+ t1;
                String str2 = t1 + "" + integer;

                return str1.compareTo(str2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i: intes) {
            stringBuilder.append(i);
        }

        System.out.println("" + stringBuilder.toString());
    }
}
