### 丑数

##### 题目：

我们把只包含2,3和5的数作丑数。求按从小到大的顺序的第1500个丑数。例如6,8都是丑数，
但14不是，因为它包含因子7。我们习惯把1当作第一个丑数。

##### 解题思路：

(1) 思路1

    从1开始递增，然后每次对2，3，5进行整数和取余数，最后剩下的是1，则是丑数，否则不是。

(2) 思路2

    由于思路1，需要每个数字进行判定，时间上不占优势。因此，我们考虑以空间换取时间来解
    这个题目。我们可以这样考虑，我们创建一个数组，数组的元素都是排好序的丑数，
    每一个丑数都是前面丑数乘以2或者3或者5得到。为了能得到排序好的数组，那么我们需要标记
    前面最大的丑数，然后对前面最大的丑数乘以2，3，5，得到小于之前最大的丑数，我们就放弃，
    第一个大于前面最大的丑数，我们才放到数组当中。

##### 参考

[源码](./Main.java)