### 数值的整数次方

##### 题目：
输入数字n，按顺序打印1到最大n位十进制数。比如输入3，输出1,2,3一直到最大的3位数999。

##### 解题思路：
(1) 方法1，显然不符合要求
<br/>暴力遍历
<br/>(2）使用数组或者字符串来表示
<br/>数字n，则初始化长度为n的数组，一个索引代表相应位置的数字，
然后从最后一位开始加1，直到数字9时，则进位，直到数组第一个索引要进位时结束。
##### 参考
[源码](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question10/Main.java)