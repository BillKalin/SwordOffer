package com.billkalin.sourcecode.question24;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static class ComplexLinkNode<T> {
        ComplexLinkNode<T> next;
        ComplexLinkNode<T> siding;
        T value;
    }

    /**
     * 创建复杂链表
     * @return
     */
    private static ComplexLinkNode<Character> createComplexNode() {
        ComplexLinkNode<Character> head = new ComplexLinkNode<>();
        head.value = 'A';

        ComplexLinkNode<Character> nodeB = new ComplexLinkNode<>();
        nodeB.value = 'B';

        ComplexLinkNode<Character> nodeC = new ComplexLinkNode<>();
        nodeC.value = 'C';

        ComplexLinkNode<Character> nodeD = new ComplexLinkNode<>();
        nodeD.value = 'D';

        ComplexLinkNode<Character> nodeE = new ComplexLinkNode<>();
        nodeE.value = 'E';

        head.next = nodeB;

        nodeB.next = nodeC;
        nodeB.siding = nodeC;

        nodeC.next = nodeD;

        nodeD.next = nodeE;

        nodeE.siding = nodeD;

        return head;
    }

    private static void printLinkNode(ComplexLinkNode<Character> head) {
        if (null == head)
            return;

        ComplexLinkNode<Character> curr = head;
        while (curr != null) {
            System.out.print("" + curr.value + "("+ (curr.siding == null? null: curr.siding.value) + ")" + " -> ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ComplexLinkNode<Character> head = createComplexNode();
        printLinkNode(head);

        ICopyLinkNode<Character> copy = new CopyMethodA();//new CopyMethodB();new CopyMethodC()
        ComplexLinkNode<Character> cloneHead = copy.copyComplexLinNode(head);
        System.out.println("\n 复制链表:\n");
        printLinkNode(cloneHead);

    }

    interface ICopyLinkNode<T> {
        ComplexLinkNode<T> copyComplexLinNode(ComplexLinkNode<T> src);
    }

    /**
     * 使用常规办法
     * 1、先复制next结点
     * 2、再复制side结点，使用循环查找
     */
    private static class CopyMethodA implements ICopyLinkNode<Character> {

        @Override
        public ComplexLinkNode<Character> copyComplexLinNode(ComplexLinkNode<Character> src) {
            if (null == src)
                return src;
            ComplexLinkNode<Character> dest = null;
            ComplexLinkNode<Character> pre = null;
            ComplexLinkNode<Character> srcCurr = src;
            //先复制next指针的结点
            while (srcCurr != null) {
                ComplexLinkNode<Character> newNode = new ComplexLinkNode<>();
                newNode.value = srcCurr.value;
                newNode.next = null;
                if (null == pre) {
                    dest = newNode;
                    pre = newNode;
                } else {
                    pre.next = newNode;
                    pre = newNode;
                }
                srcCurr = srcCurr.next;
            }
            //再复制side指针的结点
            copySideNode(src, dest);
            return dest;
        }

        private void copySideNode(ComplexLinkNode<Character> src, ComplexLinkNode<Character> dest) {
            ComplexLinkNode<Character> pre = dest;
            ComplexLinkNode<Character> srcCurr = src;
            while (srcCurr != null) {
                if (null != srcCurr.siding) {
                    ComplexLinkNode<Character> s = src;
                    ComplexLinkNode<Character> t = dest;
                    while (s != null) {
                        if (s == srcCurr.siding) {
                            break;
                        }
                        s = s.next;
                        t = t.next;
                    }

                    pre.siding = t;
                }
                srcCurr = srcCurr.next;
                pre = pre.next;
            }
        }
    }


    /**
     * 使用常规办法
     * 1、先复制next结点
     * 2、再复制side结点，使用map查找
     */
    private static class CopyMethodB implements ICopyLinkNode<Character> {

        @Override
        public ComplexLinkNode<Character> copyComplexLinNode(ComplexLinkNode<Character> src) {
            if (null == src)
                return src;
            ComplexLinkNode<Character> dest = null;
            ComplexLinkNode<Character> pre = null;
            ComplexLinkNode<Character> srcCurr = src;
            Map<ComplexLinkNode<Character>, ComplexLinkNode<Character>>  copyMap = new HashMap<>();
            //先复制next指针的结点
            while (srcCurr != null) {
                ComplexLinkNode<Character> newNode = new ComplexLinkNode<>();
                newNode.value = srcCurr.value;
                newNode.next = null;
                if (null == pre) {
                    dest = newNode;
                    pre = newNode;
                } else {
                    pre.next = newNode;
                    pre = newNode;
                }
                copyMap.put(srcCurr, newNode);
                srcCurr = srcCurr.next;
            }
            copySideNode(src, dest, copyMap);
            return dest;
        }

        private void copySideNode(ComplexLinkNode<Character> src, ComplexLinkNode<Character> dest,
                                  Map<ComplexLinkNode<Character>, ComplexLinkNode<Character>> copyMap) {
            ComplexLinkNode<Character> pre = dest;
            ComplexLinkNode<Character> srcCurr = src;
            while (srcCurr != null) {
                if (null != srcCurr.siding) {
                    pre.siding = copyMap.get(srcCurr.siding);
                }
                srcCurr = srcCurr.next;
                pre = pre.next;
            }
        }
    }

    /**
     *
     * 1、先复制next结点到原结点后面
     * 2、再复制side结点
     * 3、偶数位为复制结点的链表
     */
    private static class CopyMethodC implements ICopyLinkNode<Character> {

        @Override
        public ComplexLinkNode<Character> copyComplexLinNode(ComplexLinkNode<Character> src) {
            if (null == src)
                return src;
            ComplexLinkNode<Character> srcCurr = src;
            //先复制next指针的结点到原结点后面
            while (srcCurr != null) {
                ComplexLinkNode<Character> cloneNode = new ComplexLinkNode<>();
                cloneNode.value = srcCurr.value;

                cloneNode.next = srcCurr.next;
                srcCurr.next = cloneNode;

                srcCurr = cloneNode.next;
            }

            srcCurr = src;
            //再复制side结点
            while (srcCurr != null) {
                ComplexLinkNode<Character> cloneNode = srcCurr.next;
                if (srcCurr.siding != null) {
                    cloneNode.siding = srcCurr.siding.next;
                }
                srcCurr = cloneNode.next;
            }

            //偶数位是复制结点
            srcCurr = src;
            ComplexLinkNode<Character> cloneHead = srcCurr.next;
            ComplexLinkNode<Character> clone = cloneHead;
            srcCurr = cloneHead.next;

            while (srcCurr != null) {
                clone.next = srcCurr.next;
                clone = clone.next;
                srcCurr.next = clone.next;
                srcCurr = srcCurr.next;
            }
            return cloneHead;
        }
    }
}
