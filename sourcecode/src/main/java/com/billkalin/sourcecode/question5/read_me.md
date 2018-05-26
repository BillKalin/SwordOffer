### 用两个栈实现队列

##### 题目：
<p>用两个栈实现队列。完成从队列尾部插入数字，和从队列头部删除数字</p>

##### 解题思路：
这里考察的是栈后进先出的特点。两个栈，一个栈保存插入的数字。在删除的时候，把插入的栈弹出来到另外一个栈即可。

##### 扩展
使用两个队列模拟栈。其实主要抓住队列和栈的特点就可以。
<br/>(a) 栈的push操作：使用一个队列保存
<br/>(b) 栈的pop操作：把插入队列的元素从头部删除，插入到另外一个队列即可，插入队列最后一个元素就是要返回的。

##### 参考
[Question5](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question5/Main.java)