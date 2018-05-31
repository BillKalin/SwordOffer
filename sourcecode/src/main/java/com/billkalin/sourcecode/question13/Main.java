package com.billkalin.sourcecode.question13;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.SimpleLinkList;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList = new SimpleLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        LinkNode<Integer> head = linkList.getHead();
        printLinkList(head);
        int k = 10;
        LinkNode<Integer> node = findSpecialNode(head, k);
        System.out.println(String.format("\n链表第%d个结点是：%d", k, (node == null ? -1 : node.t)));
    }

    /**
     * 查找倒数第k个结点
     *
     * @param head
     * @param k
     * @return
     */
    private static LinkNode<Integer> findSpecialNode(LinkNode<Integer> head, int k) {
        if (k <= 0 || head == null)
            return null;

        LinkNode<Integer> p1 = head;
        LinkNode<Integer> p2 = head;
        int i = 0;
        while (i < k) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            i++;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private static void printLinkList(LinkNode<Integer> head) {
        if (null == head) {
            return;
        }

        LinkNode<Integer> curr = head;
        while (null != curr) {
            System.out.print(curr.t + ", ");
            curr = curr.next;
        }
    }
}
