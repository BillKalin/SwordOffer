package com.billkalin.sourcecode.question3;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.SimpleLinkList;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList = new SimpleLinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        LinkNode<Integer> rootNode = linkList.getHead();
        displayLinkList1(rootNode);
        displayLinkList2(rootNode);

        LinkNode<Integer> node = reverseNode(rootNode);
        displayNode(node);
    }

    /**
     * 使用栈
     * @param rootNode
     */
    private static void displayLinkList1(LinkNode<Integer> rootNode) {
        Stack<Integer> stack = new Stack<>();
        while (rootNode != null) {
            stack.push(rootNode.t);
            rootNode = rootNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");
        }
    }

    /**
     * 递归
     * @param rootNode
     */
    private static void displayLinkList2(LinkNode<Integer> rootNode) {
        if (null == rootNode)
            return;
        displayLinkList2(rootNode.next);
        System.out.print(rootNode.t + ",");
    }

    /**
     * 反转单链表
     * @param rootNode
     * @return
     */
    private static LinkNode<Integer> reverseNode(LinkNode<Integer> rootNode) {
        if (null == rootNode || rootNode.next == null)
            return rootNode;
        LinkNode<Integer> node = reverseNode(rootNode.next);
        rootNode.next.next = rootNode;
        rootNode.next = null;
        return node;
    }

    private static void displayNode(LinkNode<Integer> rootNode) {
        while (rootNode != null) {
           System.out.print(rootNode.t + ",");
            rootNode = rootNode.next;
        }
    }
}
