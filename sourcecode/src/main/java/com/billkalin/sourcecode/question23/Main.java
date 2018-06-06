package com.billkalin.sourcecode.question23;

import com.billkalin.sourcecode.common.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>();
        root.t = 10;
        root.left = new TreeNode<>();
        root.left.t = 5;
        root.right = new TreeNode<>();
        root.right.t  = 12;
        root.left.left = new TreeNode<>();
        root.left.left.t = 4;
        root.left.right = new TreeNode<>();
        root.left.right.t = 7;

        printPath(root, new Stack<Integer>(), 0, 22);
    }

    private static void printPath(TreeNode<Integer> root, Stack<Integer> path, int currNum, int expectedNum) {
        if (null == root)
            return;

        currNum += root.t;
        path.push(root.t);
        boolean isLeafNode = root.left == null && root.right == null;
        if (currNum == expectedNum && isLeafNode) {
            //如果是叶子结点，且等于目标整数，则打印该路径
            System.out.println("\n路径：");
            Iterator<Integer> iterator = path.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ",");
            }
        }

        if (null != root.left) {
            printPath(root.left, path, currNum, expectedNum);
        }

        if (null != root.right) {
            printPath(root.right, path, currNum, expectedNum);
        }

        currNum -= root.t;//回退到父节点
        path.pop();
    }
}
