package com.billkalin.sourcecode.common;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintUtils {

    public static void printIntegerLinkList(LinkNode<Integer> head) {
        if (null == head) {
            return;
        }

        LinkNode<Integer> curr = head;
        while (null != curr) {
            System.out.print(curr.t + ", ");
            curr = curr.next;
        }
    }

    /**
     * 广度遍历二叉树
     *
     * @param node
     */
    public static void printTreeNode(TreeNode<Integer> node) {
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
