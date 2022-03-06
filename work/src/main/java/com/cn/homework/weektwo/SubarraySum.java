package com.cn.homework.weektwo;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560 和为K的子数组
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/6 3:52 PM
 */
public class SubarraySum {
    /**
     * [遍历累加]:给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     *
     * @param nums 整数数组
     * @param k    整数
     * @return int
     * @author guxuhua
     * @date 2022/3/6 3:53 PM
     **/
    public int subarraySum(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        // 满足条件的子数组个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 执行运算
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 散列
     *
     * @param nums 整数数组
     * @param k    整数
     * @return int
     * @author guxuhua
     * @date 2022/3/6 4:01 PM
     **/
    public int subarraySumPlus(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hash.containsKey(pre - k)) {
                count += hash.get(pre - k);
            }
            hash.put(pre, hash.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
