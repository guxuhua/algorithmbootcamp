package com.cn.dailywork.weekthree.day20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣 297题 二叉树的序列化和反序列化
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/12 11:06 PM
 */
public class CodeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return doSerialize(root, "");
    }

    private String doSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = doSerialize(root.left, str);
            str = doSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return doDeserialize(dataList);
    }


    public TreeNode doDeserialize(List<String> input) {
        if (input.get(0).equals("None")) {
            input.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(input.get(0)));
        input.remove(0);
        root.left = doDeserialize(input);
        root.right = doDeserialize(input);

        return root;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
