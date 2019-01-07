package com.billkalin.sourcecode.question37;

import com.billkalin.sourcecode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>();

        TreeNode<Integer> l1 = new TreeNode<>();
        TreeNode<Integer> r1 = new TreeNode<>();

        root.left = l1;
        root.right = r1;

        TreeNode<Integer> l2 = new TreeNode<>();
        TreeNode<Integer> r2 = new TreeNode<>();
        r1.left = l2;
        r1.right = r2;

        int length = getTreeDeep(root);
        length = getTreeDeep2(root);

        System.out.println("二叉树的深度为：" + length);
    }


    //递归方法
    private static int getTreeDeep(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftLength = getTreeDeep(root.left);
        int rightLength = getTreeDeep(root.right);

        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }


    //非递归方法
    private static int getTreeDeep2(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        int count = 0, nextCount = 1;
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

            if (count == nextCount) {
                count = 0;
                nextCount = queue.size();
                ret++;
            }
        }
        return ret;
    }
}
