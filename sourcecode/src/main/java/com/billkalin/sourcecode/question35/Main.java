package com.billkalin.sourcecode.question35;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.SimpleLinkList;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList1 = new SimpleLinkList<>();
        SimpleLinkList<Integer> linkList2 = new SimpleLinkList<>();
        for (int i = 8; i < 11; i++) {
            linkList1.add(i);
            linkList2.add(i);
        }

        linkList1.add(1);
        linkList1.add(2);
        linkList1.add(3);

        linkList2.add(4);
        linkList2.add(5);
        linkList2.add(6);
        linkList2.add(7);

        LinkNode<Integer> node1 = linkList1.getHead();
        System.out.print("\n");
        LinkNode<Integer> node2 = linkList2.getHead();

        LinkNode<Integer> node = findFirstCommonNode2(node1, node2);

        node = findFirstCommonNode3(node1, node2);

        PrintUtils.printIntegerLinkList(node1);
        System.out.print("\n");
        PrintUtils.printIntegerLinkList(node2);

        System.out.println("\n第一个公共结点为：" + node.t);
    }

    /**
     * 思路2
     * @param node1
     * @param node2
     * @return
     */
    private static LinkNode<Integer> findFirstCommonNode2(LinkNode<Integer> node1, LinkNode<Integer> node2) {
        LinkNode<Integer> node = null;

        if (null == node1 || node2 == null)
            return node;

        Stack<LinkNode<Integer>> stack1 = new Stack<>();
        Stack<LinkNode<Integer>> stack2 = new Stack<>();

        LinkNode<Integer> curr = node1;
        while (curr != null) {
            stack1.push(curr);
            curr = curr.next;
        }

        curr = node2;
        while (curr != null) {
            stack2.push(curr);
            curr = curr.next;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().t == stack2.peek().t) {
                node = stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return node;
    }

    /**
     * 思路3
     * @param node1
     * @param node2
     * @return
     */
    private static LinkNode<Integer> findFirstCommonNode3(LinkNode<Integer> node1, LinkNode<Integer> node2) {
        LinkNode<Integer> node = null;

        if (null == node1 || node2 == null)
            return node;

        int node1Len = getLinkNodeLength(node1);
        int node2Len = getLinkNodeLength(node2);

        int len = Math.abs(node1Len - node2Len);
        int i = 0;
        if (node1Len > node2Len) {
            while (node1 != null && i < len) {
                i++;
                node1 = node1.next;
            }
        } else {
            while (node2 != null && i < len) {
                i++;
                node2 = node2.next;
            }
        }

        while (null != node1 && node2 != null) {
            if (node2.t == node1.t) {
                node = node2;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return node;
    }

    private static int getLinkNodeLength(LinkNode<Integer> node1) {
        int len = 0;
        LinkNode<Integer> curr = node1;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
