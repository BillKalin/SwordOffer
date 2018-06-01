package com.billkalin.sourcecode.question15;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.SimpleLinkList;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList1 = new SimpleLinkList<>();
        SimpleLinkList<Integer> linkList2 = new SimpleLinkList<>();

        for (int i = 0; i < 10; i++) {
            if ((i & 0x01) == 0) {
                linkList1.add(i);
            } else {
                linkList2.add(i);
            }
        }

        System.out.println("合并前链表1：");
        PrintUtils.printIntegerLinkList(linkList1.getHead());
        System.out.println("\n合并前链表2：");
        PrintUtils.printIntegerLinkList(linkList2.getHead());

        LinkNode<Integer> newHead = mergeLinkList(linkList1.getHead(), linkList2.getHead());
        System.out.println("\n合并后的链表：");
        PrintUtils.printIntegerLinkList(newHead);
    }

    /**
     * 合并两个递增的链表
     * @param head1
     * @param head2
     * @return
     */
    private static LinkNode<Integer> mergeLinkList(LinkNode<Integer> head1, LinkNode<Integer> head2) {
        if(null == head1) {
            return head2;
        }

        if (null == head2) {
            return head1;
        }

        LinkNode<Integer> head = null;

        if (head1.t >= head2.t) {
            head = head1;
            head.next = mergeLinkList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeLinkList(head1, head2.next);
        }

        return head;
    }
}
