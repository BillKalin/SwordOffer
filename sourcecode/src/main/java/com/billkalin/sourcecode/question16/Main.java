package com.billkalin.sourcecode.question16;

import com.billkalin.sourcecode.common.PrintUtils;
import com.billkalin.sourcecode.common.TreeNode;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> root1 = new TreeNode<>();
        root1.t = 8;
        root1.left = new TreeNode<>();
        root1.left.t = 8;
        root1.right = new TreeNode<>();
        root1.right.t = 7;
        root1.left.left = new TreeNode<>();
        root1.left.left.t = 9;
        root1.left.right = new TreeNode<>();
        root1.left.right.t = 2;

        System.out.println("二叉树1：");
        PrintUtils.printTreeNode(root1);

        TreeNode<Integer> root2 = new TreeNode<>();
        root2.t = 8;
        root2.left = new TreeNode<>();
        root2.left.t = 9;
        root2.right = new TreeNode<>();
        root2.right.t = 2;

        System.out.println("\n二叉树2：");
        PrintUtils.printTreeNode(root2);

        boolean has = hasSubTree(root1, root2);

        System.out.println("\n二叉树1是否包含二叉树1：" + has);
    }

    /**
     * 找到和root2头结点相同的结点
     * @param root1
     * @param root2
     * @return
     */
    private static boolean hasSubTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean ret = false;
        TreeNode<Integer> curr = root1;
        if (null != curr) {
            if (curr.t == root2.t) {
                ret = isSubTree(curr, root2);
            }
            if (!ret) {
                ret = hasSubTree(curr.left, root2);
            }
            if (!ret) {
                ret = hasSubTree(curr.right, root2);
            }
        }
        return ret;
    }

    /**
     * 依次对左子结点和右子结点做对比
     * @param root1
     * @param root2
     * @return
     */
    private static boolean isSubTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root2 == null)
            return true;

        if (root1 == null) {
            return false;
        }

        if (root1.t != root2.t) {
            return false;
        }

        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
