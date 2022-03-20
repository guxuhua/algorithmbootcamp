package com.cn.dailywork.weekfour.day28;

/**
 * 力扣450：删除二叉搜索树中的节点
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/20 22:47
 */
public class NodeDelete {

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * @param root 根节点
     * @param key  目标值
     * @return com.cn.dailywork.weekfour.day28.NodeDelete.TreeNode
     * @author guxuhua
     * @date 2022/3/20 23:38
     **/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return findAndReplaceNode(root, key);
    }

    private TreeNode findAndReplaceNode(TreeNode root, int key) {
        if (key > root.val) {
            // 从右子树开始
            root.right = findAndReplaceNode(root.right, key);
        } else if (key < root.val) {
            // 从左子树开始查找
            root.left = findAndReplaceNode(root.left, key);
        } else {
            // 到底了
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = findAndReplaceNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = findAndReplaceNode(root.left, root.val);
            }

        }
        return root;

    }

    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
