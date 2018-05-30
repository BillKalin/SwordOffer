package com.billkalin.sourcecode.question11;

import com.billkalin.sourcecode.common.LinkNode;
import com.billkalin.sourcecode.common.SimpleLinkList;

public class Main {

    public static void main(String[] args) {
        SimpleLinkList<Integer> linkList = new SimpleLinkList<>();
        for (int i = 0; i < 1; i++) {
            linkList.add(i);
        }
        printLinkList(linkList.getHead());
        LinkNode<Integer> head = linkList.getHead();
        LinkNode<Integer> delNode = linkList.getNode(0);

        System.out.println("\n删除后的结点:");
        head = delNode(head, delNode);
        printLinkList(head);
    }

    private static LinkNode<Integer> delNode(LinkNode<Integer> head, LinkNode<Integer> delNode) {
        if (null == head || delNode == null)
            return null;
        if (delNode.next != null) {//中间结点
            LinkNode<Integer> next = delNode.next;
            delNode.t = next.t;
            delNode.next = next.next;
            next.next = null;
        } else if (head.next == null && head == delNode) {
            //只有一个结点
            head = null;
            delNode = null;
        } else {//删除尾结点
            LinkNode<Integer> parent = head;
            while (parent.next != delNode) {
                parent = parent.next;
            }
            parent.next = null;
            delNode = null;
        }
        return head;
    }

    private static void printLinkList(LinkNode<Integer> head) {
        LinkNode<Integer> curr = head;
        while (curr != null) {
            System.out.print(curr.t + ", ");
            curr = curr.next;
        }
    }
}
