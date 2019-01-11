package com.billkalin.sourcecode.question40;

public class Main {

    public static void main(String[] args) {
        String str = "I am a student.";
        String revStr = reverseStr(str);
        System.out.println(str + " 翻转之后 " + revStr);

        str = "abcdefg";
        revStr = reverseStr2(str, 2);
        System.out.println(str + " 翻转之后 " + revStr);
    }

    private static String reverseStr(String string) {
        if (null == string)
            return "";

        char[] srcCh = string.toCharArray();
        int lenth = srcCh.length;
        //先翻转整个字符串
        srcCh = reverseWord(srcCh, 0, lenth - 1);
        int start = 0;
        int end;
        while (start < lenth) {
            while (start < lenth && srcCh[start] == ' ') {
                start++;
            }
            end = start + 1;
            while (end < lenth && srcCh[end] != ' ') {
                end++;
            }
            reverseWord(srcCh, start, end - 1);
            start = end;
        }

        return new String(srcCh);
    }

    private static char[] reverseWord(char[] chs, int start, int end) {
        if (null == chs || chs.length == 0)
            return null;
        //这里也可以用栈来翻转
        while (start < end) {
            char ch = chs[start];
            chs[start] = chs[end];
            chs[end] = ch;
            start++;
            end--;
        }
        return chs;
    }

    private static String reverseStr2(String str, int n) {
        if (null == str || str.length() < n || n == 0)
            return str;

        char[] chars = str.toCharArray();
        int length = chars.length;
        reverseWord(chars, 0, n - 1);
        reverseWord(chars, n, length - 1);
        reverseWord(chars, 0, length - 1);
        return new String(chars);
    }
}
