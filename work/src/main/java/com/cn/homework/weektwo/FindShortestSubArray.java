package com.cn.homework.weektwo;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 697题 数组的度
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/6 4:09 PM
 */
public class FindShortestSubArray {
    /**
     * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
     * <p>
     * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     *
     * @param nums 非空且只包含非负数的整数数组
     * @return int
     * @author guxuhua
     * @date 2022/3/6 4:11 PM
     **/
    public int findShortestSubArray(int[] nums) {
        // 统计元素出现的次数和第一次最后一次出现的位置
        Map<Integer, int[]> timeHash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (timeHash.containsKey(nums[i])) {
                timeHash.get(nums[i])[0]++;
                timeHash.get(nums[i])[2] = i;
            } else {
                timeHash.put(nums[i], new int[]{1, i, i});
            }
        }
        // 对统计hash进行迭代，获取最大次数和最小距离
        int counter = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : timeHash.entrySet()) {
            int[] arr = entry.getValue();
            if (counter < arr[0]) {
                // 找出出现的最大次数
                counter = arr[0];
                // 最小距离
                minLen = arr[2] - arr[1] + 1;
            } else if (counter == arr[0]) {
                // 存在多个出现最大次数一致的情况，单独筛选最小距离
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
