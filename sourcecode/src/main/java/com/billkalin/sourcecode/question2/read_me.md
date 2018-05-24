### 替换空格

##### 题目：
  <p>实现一个函数，把字符串中的每个空格替换成%20，例如输入"We are happy."，则输出"We%20are%20happy."</p>

##### 解题思路：
    (1)方法1,时间复杂度O(N^2)
       从头开始替换，遇到空格，把字符串数组往后挪2个位置，直到替换为止
    (2)方法2，时间复杂度O(N)
        先遍历一遍字符串，把空格的数量记录，每替换一个空格，新增两个位置，那么总长度为length+2*blankLength。
        然后一个索引指向新的末尾位置，一个指向原有效字符串末尾，遇到空格就替换，直到原字符串遍历完毕。

##### 扩展
    合并两个有序数组A1和A2，A1的长度能容纳A1和A2的所有数字，A1和A2都是有序。请在原有A1数组上合并这两个数组(即不能使用额外空间)。

##### 参考
[Question2](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question1/Question2.java)