### 反转链表

##### 题目：

定义一个方法，输入头结点，反转该链表，并输出反转后的头结点。

##### 解题思路：
(1) 方法1
<p>使用三个指针：一个指针指向前一个结点，一个指针指向当前结点，一个指针
指向后一个结点。先保存后一个结点，然后当前结点指向前一个结点，
前一个结点的下一个指针置空。
接着把后一个指针复制给当前结点，当前结点复制给前一个结点即可。如此循环</p>

(2) 方法2
<p>使用递归方法，找到尾结点。因为递归的特性，接下来返回的是前一个结点，
则把尾结点的下一个指针指向前一个结点，前一个结点的下一个指针置空。</p>

##### 参考
[源码](./Main.java)