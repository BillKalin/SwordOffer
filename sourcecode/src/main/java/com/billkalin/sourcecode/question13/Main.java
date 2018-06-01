package com.billkalin.sourcecode.question13;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.SimpleLinkList;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList = new SimpleLinkList<>();
        for (int i = 0; i < 4; i++) {
            linkList.add(i);
        }

        LinkNode<Integer> head = linkList.getHead();
        PrintUtils.printIntegerLinkList(head);
        int k = 10;
        LinkNode<Integer> node = findSpecialNode(head, k);

        //查找中间节点
//      LinkNode<Integer> node2 = findCenterNode(head);

        //判断是否有环
//      LinkNode<Integer> last = linkList.getNode(3);
//      LinkNode<Integer> b = linkList.getNode(1);
//      last.next = b;
//      boolean isSuccess = hasCircle(head);

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

    /**
     * 查找中间节点
     * @param head
     * @return
     */
    private static LinkNode<Integer> findCenterNode(LinkNode<Integer> head) {
        if (head == null)
            return null;

        LinkNode<Integer> p1 = head;
        LinkNode<Integer> p2 = head.next;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }

    /**
     * 判断单链表是否有环
     * @param head
     * @return
     */
    private static boolean hasCircle(LinkNode<Integer> head) {
        if (head == null)
            return false;

        LinkNode<Integer> p1 = head;
        LinkNode<Integer> p2 = head.next;

        while (null != p2 && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;

        }

        return false;
    }
}
