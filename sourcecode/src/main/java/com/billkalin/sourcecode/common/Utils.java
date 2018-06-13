package com.billkalin.sourcecode.common;

public class Utils {

    public static <T> void swap(T[] arr, int i, int j) {
        if (null == arr || i >= arr.length || j >= arr.length)
            return;
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void swap(int[] arr, int i, int j) {
        if (null == arr || i >= arr.length || j >= arr.length)
            return;
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 3;
        System.out.print("" + (start + (int)(Math.random() * (end - start + 1))));
    }
}
