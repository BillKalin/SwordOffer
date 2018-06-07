package com.billkalin.sourcecode.common;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeHelper {
    //递归方法前序、中序、后序遍历
    public static void circlePrintPreOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        System.out.print("" + node.t + ",");
        circlePrintPreOrder(node.left);
        circlePrintPreOrder(node.right);
    }

    public static void circlePrintMiddleOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        circlePrintPreOrder(node.left);
        System.out.print("" + node.t + ",");
        circlePrintPreOrder(node.right);
    }

    public static void circlePrintAfterOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        circlePrintPreOrder(node.left);
        circlePrintPreOrder(node.right);
        System.out.print("" + node.t + ",");
    }

    //非递归方法前序、中序、后序遍历
    public static void loopPrintPreOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;
        while (null != curr || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print("" + curr.t + ",");
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }
    }

    public static void loopPrintMiddleOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;
        while (null != curr || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print("" + curr.t + ",");
            curr = curr.right;
        }
    }

    public static void loopPrintAfterOrder(TreeNode<Integer> node) {
        if (null == node)
            return;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;
        TreeNode<Integer> lastVisited = node;
        while (null != curr || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right == null || curr.right == lastVisited) {
                stack.pop();
                lastVisited = curr;
                System.out.print("" + curr.t + ",");
                curr = null;
            } else {
                curr = curr.right;
            }
        }
    }

    /**
     * 广度遍历二叉树
     *
     * @param node
     */
    public static void printTreeLayerNode(TreeNode<Integer> node) {
        if (null != node) {
            Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
            queue.add(node);
            while (node != null) {
                node = queue.poll();
                if (null != node) {
                    System.out.print("" + node.t + ",");
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
}
