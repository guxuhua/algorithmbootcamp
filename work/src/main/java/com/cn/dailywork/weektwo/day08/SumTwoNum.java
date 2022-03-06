package com.cn.dailywork.weektwo.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1：求两数之和
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/2/28 4:04 PM
 */
public class SumTwoNum {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * @param nums   整数数组
     * @param target 整数目标值
     * @return int[]
     * @author guxuhua
     * @date 2022/2/28 4:04 PM
     **/
    public int[] twoSum(int[] nums, int target) {
        // 剔除极值:空数组或者数组长度为1
        if (null == nums || nums.length <= 1) {
            return null;
        }
        // 对数组遍历：数组当前差值为key，下标作为value
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        // 再次遍历数组，值与hash进行比较
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (nums[i] != map.get(nums[i]))) {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return null;
    }
}
