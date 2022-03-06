package com.cn.dailywork.weektwo.day12;

/**
 * leetcode 53题：最大子数组和
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/4 11:20 PM
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 判断极值:数组为空
        if (null == nums) {
            return 0;
        }
        // 数组只有1项
        if (nums.length == 1) {
            return nums[0];
        }
        // 默认第一位为最大值
        int value = nums[0];
        // 前n位的最大和
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            value = Math.max(pre, value);
        }

        return value;

    }
}
