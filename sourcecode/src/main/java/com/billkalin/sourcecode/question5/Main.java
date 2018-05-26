package com.billkalin.sourcecode.question5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("栈模拟队列");
        StackQueue<Integer> stackQueue = new StackQueue<>();
        stackQueue.appendData(1);
        stackQueue.appendData(2);
        stackQueue.appendData(3);
        stackQueue.appendData(4);
        int t;
        while (!stackQueue.isEmpty()) {
            t = stackQueue.delFirst();
            System.out.print(t + ",");
        }

        System.out.println("队列模拟栈");
        QueueStack<Integer> queueStack = new QueueStack();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        queueStack.push(4);

        queueStack.pop();

        queueStack.push(5);

        queueStack.pop();
    }

    private static class StackQueue<E> {

        private Stack<E> stack1 = new Stack<>();
        private Stack<E> stack2 = new Stack<>();

        public void appendData(E e) {
            stack1.push(e);
        }

        public E delFirst() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                return null;
            }
            return stack2.pop();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    private static class QueueStack<E> {
        private Queue<E> queue1 = new ArrayDeque<>();
        private Queue<E> queue2 = new ArrayDeque<>();

        public void push(E e) {
            queue1.add(e);
        }

        public E pop() {
            int size = queue1.size() - 1;
            int index = 0;
            while (index < size) {
                queue2.add(queue1.poll());
                index++;
            }

            E e = null;
            if (!queue1.isEmpty()) {
                e = queue1.poll();
            }

            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }

            return e;
        }
    }
}
