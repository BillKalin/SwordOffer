package com.billkalin.sourcecode.question21;

import com.billkalin.sourcecode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>();
        root.t = 8;
        root.left = new TreeNode<>();
        root.left.t = 8;
        root.right = new TreeNode<>();
        root.right.t = 7;
        root.left.left = new TreeNode<>();
        root.left.left.t = 9;
        root.left.right = new TreeNode<>();
        root.left.right.t = 2;

        printBinaryTree(root);
    }

    private static void printBinaryTree(TreeNode<Integer> root) {
        if (null == root)
            return;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<TreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            if (null != curr) {
                System.out.print(curr.t + ",");
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}
