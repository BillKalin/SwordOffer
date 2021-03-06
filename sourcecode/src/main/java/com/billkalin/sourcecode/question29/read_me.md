### 连续子数组的最大和

##### 题目：

输入一个整型数组，数组里有正数也有负数。数字中一个或者连续的多个整数组成一个子数组。
求所有子数组的和的最大值。要求时间复杂度为O(n)。例如输入数组为{1,-2,3,10,-4,7,2,-5}，
和最大的子数组为{3,10,-4,7,2}，因此输出该数字的和是18。

##### 解题思路：

先从1开始分析，1加-2，得到-1，我们先保存最大的和是1，然后-1加3，得到2，比3本身要小，
那么从3以前得到的和没有从3开始的和大，那就放弃前面的和，从3开始累加。3加10，得到13，
保存最大的和是13，接着加-4，得到9，最大的值还是13，然后加7，是16，比目前保存最大的13还大，
那就更新最大值16，再加2，得到18，更新最大值18，再加-5，比最大值小。最后得到的最大的和是18。

##### 参考

[源码](./Main.java)