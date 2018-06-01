package com.billkalin.sourcecode.question14;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.SimpleLinkList;

public class Main {

    public static void main(String[] args) {

        SimpleLinkList<Integer> linkList = new SimpleLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        System.out.println("调整前：");
        PrintUtils.printIntegerLinkList(linkList.getHead());
        LinkNode<Integer> newHead = reverseLinkNode(linkList.getHead());
//        newHead = reverseLinkNode2(linkList.getHead());
        System.out.println("\n调整后：");
        PrintUtils.printIntegerLinkList(newHead);
    }

    /**
     * 使用三个指针
     * 一个指针指向上一个结点
     * 一个指针指向当前结点
     * 一个指针指向下一个结点
     *
     * @param head
     * @return
     */
    private static LinkNode<Integer> reverseLinkNode(LinkNode<Integer> head) {
        if (null == head)
            return head;

        LinkNode<Integer> pre = null;
        LinkNode<Integer> curr = head;
        LinkNode<Integer> next = null;

        while (curr != null) {
            next = curr.next;//保留下一个指针
            curr.next = pre;//指向前一个指针
            if (null != pre) {//这里要注意，pre为空
                pre.next = null;
            }

            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     * 利用递归方法
     *
     * @param head
     * @return
     */
    private static LinkNode<Integer> reverseLinkNode2(LinkNode<Integer> head) {
        if (head == null || head.next == null) {//找到尾结点
            return head;
        }
        LinkNode<Integer> node = reverseLinkNode2(head.next);//尾结点
        head.next.next = head;//尾结点的时候，head指向的是尾结点前一个结点
        head.next = null;

        return node;
    }
}
