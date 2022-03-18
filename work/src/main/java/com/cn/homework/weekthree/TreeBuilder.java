package com.cn.homework.weekthree;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣106题：从中序与后序遍历序列构造二叉树
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/18 18:26
 */
public class TreeBuilder {

    private Map<Integer, Integer> maps = new HashMap<>();

    private int[] postorder;

    private int postIndex = 0;

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     *
     * @param inorder   中序
     * @param postorder 后序
     * @return com.cn.homework.weekthree.TreeBuilder.TreeNode
     * @author guxuhua
     * @date 2022/3/18 18:29
     **/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        this.postorder = postorder;
        // 先根：后续的最后一位
        this.postIndex = postorder.length - 1;
        // 记录各个元素的下标
        int index = 0;
        for(Integer i : inorder) {
            maps.put(i, index++);
        }
        return recursion(0, inorder.length - 1);
    }

    private TreeNode recursion( int leftIndex, int rightIndex) {
        // 递归截止条件
        if (leftIndex > rightIndex) {
            return null;
        }
        // 找到root
        int rootVal = postorder[postIndex];
        TreeNode ans = new TreeNode(rootVal);
        // 以root为界，将当前树分成左右两个
        int index = maps.get(rootVal);
        // 下标减一
        postIndex--;
        // 构造右子树
        ans.right = recursion(index + 1, rightIndex);
        // 构造左子树
        ans.left = recursion(leftIndex, index - 1);
        return ans;
    }

    public class TreeNode {
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
