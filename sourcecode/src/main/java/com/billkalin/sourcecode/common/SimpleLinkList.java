package com.billkalin.sourcecode.common;

public class SimpleLinkList<T> {

    private LinkNode<T> head;

    public LinkNode<T> getHead() {
        return head;
    }

    public void add(T t) {
        LinkNode<T> newNode = new LinkNode<>();
        newNode.next = null;
        newNode.t = t;

        if (null == head) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public LinkNode<T> getNode(int index) {
        if (index < 0 || null == head)
            return null;

        LinkNode<T> curr = head;
        int i = 0;
        while (i < index) {
            if (curr != null) {
                curr = curr.next;
            } else {
                return null;
            }
            i ++;
        }

        return curr;
    }

}
