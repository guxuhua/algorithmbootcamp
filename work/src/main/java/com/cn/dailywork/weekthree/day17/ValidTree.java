package com.cn.dailywork.weekthree.day17;

/**
 * 力扣98题：验证二叉搜索树
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/9 11:18 PM
 */
public class ValidTree {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root 二叉树的根节点
     * @return boolean
     * @author guxuhua
     * @date 2022/3/9 11:19 PM
     **/
    public boolean isValidBST(TreeNode root) {
        // 使用递归求解
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return dfs(node.left, lower, node.val) && dfs(node.right, node.val, upper);
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
