package com.billkalin.sourcecode.common;

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
        TreeHelper.printTreeLayerNode(node);
    }
}
