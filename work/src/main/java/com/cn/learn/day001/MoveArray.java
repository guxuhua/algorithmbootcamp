package com.cn.learn.day001;

import java.util.Arrays;

/**
 * leetcode 283
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 套模型：
 * 遍历+留下满足条件的
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/27 10:30 PM
 */
public class MoveArray {

    public static void main(String[] args) {
        MoveArray object = new MoveArray();
        int[] nums = {0, 1, 0, 3, 12};
        object.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        // 非0的往前挪，后继缺失的补0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }
    }
}
