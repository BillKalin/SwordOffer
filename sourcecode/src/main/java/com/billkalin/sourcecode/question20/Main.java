package com.billkalin.sourcecode.question20;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] pushArray = {1, 2, 3, 4, 5};
        int[] popArray = {4, 5, 3, 2, 1};//{5, 4, 2, 3, 1};

        boolean isPopArray = isPopArray(pushArray, popArray);

        System.out.println("压入序列：" + Arrays.toString(pushArray));
        System.out.println("弹出序列：" + Arrays.toString(popArray));
        System.out.println("是否是弹出序列：" + isPopArray);
    }

    private static boolean isPopArray(int[] pushArray, int[] popArray) {
        if (null == pushArray || null == popArray || pushArray.length != popArray.length)
            return false;

        Stack<Integer> helpStack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popArray.length; i++) {
            while (j < pushArray.length && (helpStack.isEmpty() || helpStack.peek() != popArray[i])) {
                //辅助栈为空，或者将要栈顶数字和弹出序列不同，把压入序列的数字添加到辅助栈中,直到找到或者全部遍历完成
                helpStack.push(pushArray[j]);
                j++;
            }

            if (helpStack.peek() != popArray[i]) {//要弹出的数字和弹出序列不等，那就不是弹出序列
                break;
            }
            helpStack.pop();
        }

        return helpStack.isEmpty();
    }
}
