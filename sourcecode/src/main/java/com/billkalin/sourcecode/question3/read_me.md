### 从尾到头打印链表

##### 题目：
  <p>输入一个链表的头结点，从尾到头反过来打印每个结点的值。</p>

##### 解题思路：
    (1)方法1, 前提是可以翻转链表
       先反转链表，然后依次打印各个结点的值。
    (2)方法2，使用栈
       遍历链表，使用栈来保存，然后弹出栈中结点即可。
    (3)方法3，使用递归方式
       递归遍历链表，打印结点的值。

##### 参考
[源码](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question3/Main.java)