package com.cn.homework.weekone;

import java.util.Stack;

/**
 * leetcode 85：最大矩形
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/2/27 11:36 AM
 */
public class MaximalRectangle {
    /**
     * 暴力法
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * @param matrix 请求入参：二维数组
     * @return int
     * @author guxuhua
     * @date 2022/2/27 11:37 AM
     **/
    public int maximalRectangle(char[][] matrix) {
        // 极值：输入项为空
        if (matrix.length == 0) {
            return 0;
        }
        // 二维数组的行和列
        int rowNum = matrix.length;
        int cloNum = matrix[0].length;
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[rowNum][cloNum];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < cloNum; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = minWidth < width[up_row][col] ? minWidth : width[up_row][col];
                    //更新面积
                    maxArea = maxArea > height * minWidth ? maxArea : height * minWidth;
                }
            }
        }
        return maxArea;
    }
}
