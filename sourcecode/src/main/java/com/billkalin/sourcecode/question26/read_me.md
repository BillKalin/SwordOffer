### 字符串的排列

##### 题目：

输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印由字符
a,b,c组成的所有字符串abc,acb,bac,bca,cab和cba。

##### 解题思路：

分成两部分来考虑，先拿出a，然后依次和后面的字符替换，使用递归，依次替换，得到全排列字符串。

##### 参考

[源码](./Main.java)