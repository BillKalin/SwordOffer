### 数值的整数次方

##### 题目：
实现方法double power(double base, int exponent)，求base的exponent次方，不得使用现有api，不用考虑大数问题。
##### 解题思路：
看起来很简单的一道题目，但其实不然。得考虑边界问题，比如base的值，如果是0呢？exponent有负数、正数和0。
还需要考虑计算一个数字的N次方的效率问题。

##### 参考
[源码](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question9/Main.java)