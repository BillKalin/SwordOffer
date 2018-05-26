### 重建二叉树

##### 题目：
  <p>输入某二叉树的前序遍历和中序遍历，请重建出该二叉树。假设输入的前序遍历和中序遍历都不包含重复数字。例如输入前序遍历{1,2,4,7,3,5,6,8}
  和中序遍历{4,7,2,1,5,3,8,6}重建二叉树，并输出头结点。</p>
<br/>        &nbsp;&nbsp;&nbsp;1
<br/>       &nbsp;&nbsp;&nbsp;/ \
<br/>&nbsp;2 &nbsp;  3
<br/>     &nbsp;/ &nbsp;&nbsp;&nbsp;/  \
<br/>    4   &nbsp;&nbsp;5&nbsp;&nbsp;6
<br/>&nbsp;\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\
<br/>&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8

##### 解题思路：
    分析前序遍历的根结点始终是第一个。在中序遍历中，根结点在中间位置，左子树在这个结点的左边，右子树在该结点的右边。
    那么可以遍历中序遍历，利用递归找到左子树和右子树。

##### 参考
[Question4](https://github.com/BillKalin/SwordOffer/blob/master/sourcecode/src/main/java/com/billkalin/sourcecode/question4/Question4.java)