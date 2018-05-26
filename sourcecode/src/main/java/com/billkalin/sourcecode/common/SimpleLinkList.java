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

}
