package com.billkalin.sourcecode.question19;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        StackPro stackPro = new StackPro();
        stackPro.push(3);
        stackPro.push(4);
        stackPro.push(2);
        stackPro.push(5);
        stackPro.push(1);

        System.out.println("min = " + stackPro.min());

        stackPro.pop();

        System.out.println("min = " + stackPro.min());

        stackPro.pop();
        stackPro.pop();
        stackPro.pop();
        stackPro.pop();
        stackPro.pop();

    }

    private static class StackPro {
        private Stack<Integer> srcStack;
        private Stack<Integer> helpStack;

        public StackPro() {
            srcStack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void push(int value) {
            if (helpStack.empty() || helpStack.peek() > value) {
                helpStack.push(value);
            } else {
                helpStack.push(helpStack.peek());
            }
            srcStack.push(value);
        }

        public int pop() {
            if (!helpStack.empty()) {
                helpStack.pop();
            } else {
                return -1;
            }
            return srcStack.pop();
        }

        public int min() {
            if (!helpStack.empty()) {
                helpStack.peek();
            } else {
                return -1;
            }
            return helpStack.peek();
        }
    }
}
