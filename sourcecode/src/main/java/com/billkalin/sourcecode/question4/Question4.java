package com.billkalin.sourcecode.question4;

import com.billkalin.sourcecode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question4 {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode<Integer> root = recreateTree(preOrder, inOrder);
        displayNode(root);
    }

    private static TreeNode<Integer> recreateTree(int[] preOrder, int[] inOrder) {
        if (null == preOrder || inOrder == null
                || preOrder.length != inOrder.length
                || preOrder.length == 0
                || inOrder.length == 0)
            return null;
        int startPre = 0;
        int endPre = preOrder.length - 1;
        int startIn = startPre;
        int endIn = endPre;

        TreeNode<Integer> root = null;
        try {
            root = create(preOrder, startPre, endPre, inOrder, startIn, endIn);
//            root = create2(preOrder, startPre, endPre, inOrder, startIn, endIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    private static TreeNode<Integer> create(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;

        TreeNode<Integer> root = new TreeNode<>();
        root.t = preOrder[startPre];
        for (int i = startIn; i <= endIn; i++) {
            //找到中序遍历的根结点
            if (preOrder[startPre] == inOrder[i]) {
                int leftLength = i - startIn;
                //构建左子树
                root.left = create(preOrder, startPre + 1, startPre + leftLength, inOrder, startIn, i - 1);
                root.right = create(preOrder, startPre + leftLength + 1, endPre, inOrder, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    private static TreeNode<Integer> create2(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) throws Exception {
        int rootValue = preOrder[startPre];
        TreeNode<Integer> root = new TreeNode<>();
        root.t = rootValue;
        root.left = root.right = null;

        if (startPre == endPre) {
            if (startIn == endIn &&
                    rootValue == inOrder[startIn]) {
                return root;
            } else {
                throw new Exception("Invalid Input:");
            }
        }

        int rootIn = startIn;
        //找到中序遍历的根结点
        while (rootIn <= endIn && rootValue != inOrder[rootIn]) {
            rootIn++;
        }

        if(rootIn == endIn && inOrder[rootIn] != rootValue) {
            throw new Exception("Invalid Input:");
        }

        int leftChildLength = rootIn - startIn;
        if (leftChildLength > 0) {
            //构建左子树
            root.left = create2(preOrder, startPre + 1, startPre + leftChildLength, inOrder, startIn, rootIn - 1);
        }

        if (leftChildLength < endPre - startPre) {
            //构建右子树
            root.right = create2(preOrder, startPre + leftChildLength + 1, endPre, inOrder, rootIn + 1, endIn);
        }

        return root;
    }

    /**
     * 广度遍历二叉树
     *
     * @param node
     */
    private static void displayNode(TreeNode<Integer> node) {
        if (null != node) {
            Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
            queue.add(node);
            while (node != null) {
                node = queue.poll();
                if (null != node) {
                    System.out.print("" + node.t + ",");
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
}
