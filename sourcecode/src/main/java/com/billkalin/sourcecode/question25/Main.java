package com.billkalin.sourcecode.question25;

import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.TreeNode;

public class Main {

    private static TreeNode<Integer> createTree() {
        TreeNode<Integer> root = new TreeNode<Integer>();
        root.t = 10;

        root.left = new TreeNode<>();
        root.left.t = 6;

        root.right = new TreeNode<>();
        root.right.t = 14;

        root.left.left = new TreeNode<>();
        root.left.left.t = 4;
        root.left.right = new TreeNode<>();
        root.left.right.t = 8;

        root.right.left = new TreeNode<>();
        root.right.left.t = 12;
        root.right.right = new TreeNode<>();
        root.right.right.t = 16;

        return root;
    }

    private static TreeNode<Integer> mPreNode = null;

    public static void main(String[] args) {
        TreeNode<Integer> root = createTree();
        System.out.println("转换前的树：");
        PrintUtils.printTreeNode(root);
        mPreNode = convertTree(root);
        TreeNode<Integer> newRoot = mPreNode;
        while (mPreNode != null) {
            if (mPreNode.left == null) {
                newRoot = mPreNode;
                break;
            }
            mPreNode = mPreNode.left;
        }
        System.out.println("\n转换后的树：");
        while (newRoot != null) {
            System.out.print( newRoot.t + " -> ");
            newRoot = newRoot.right;
        }
    }

    private static TreeNode<Integer> convertTree(TreeNode<Integer> node) {
        if (null == node)
            return null;

        TreeNode<Integer> curr = node;

        if (curr.left != null) {
            convertTree(curr.left);
        }

        curr.left = mPreNode;
        if (null != mPreNode) {
            mPreNode.right = curr;
        }

        mPreNode = curr;

        if (curr.right != null) {
            convertTree(curr.right);
        }

        return node;
    }

}
