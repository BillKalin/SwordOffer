package com.billkalin.sourcecode.question33;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String string = "abaccdefff";
        char ch = getFirst1Char(string);
        System.out.println("字符串：" + string + " 第一个只出现一次的字符是：" + ch);
    }

    private static char getFirst1Char(String string) {
        if (null == string || string.length() == 0)
            return '\0';
        if (string.length() == 1)
            return string.charAt(0);

        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (char ch : string.toCharArray()) {
            if (null == charMap.get(ch)) {
                charMap.put(ch, 1);
            } else {
                int count = charMap.get(ch);
                charMap.put(ch, ++count);
            }
        }

        for (char ch : string.toCharArray()) {
            if (charMap.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }
}
