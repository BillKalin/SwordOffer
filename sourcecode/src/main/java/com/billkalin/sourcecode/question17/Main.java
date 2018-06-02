package com.billkalin.sourcecode.question17;

import com.billkalin.sourcecode.common.PrintUtils;
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

        System.out.println("二叉树：");
        PrintUtils.printTreeNode(root);
        mirrorTree(root);
//        mirrorTree2(root);
        System.out.println("\n二叉树镜像：");
        PrintUtils.printTreeNode(root);
    }

    /**
     * 递归方式
     * @param root
     */
    private static void mirrorTree(TreeNode<Integer> root) {
        if (null == root)
            return;

        if (root.left == null && root.right == null)//叶子结点
            return;

        //左右子树交换
        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(null != root.left) {
            mirrorTree(root.left);
        }

        if(null != root.right) {
            mirrorTree(root.right);
        }
    }

    /**
     * 循环方式
     * 使用队列保存每一层的结点，然后进行遍历交换
     * @param root
     */
    private static void mirrorTree2(TreeNode<Integer> root) {
        if (null == root)
            return;

        if (root.left == null && root.right == null)
            return;

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            //左右子树交换
            TreeNode<Integer> temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
