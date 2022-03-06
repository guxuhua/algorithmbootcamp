package com.cn.dailywork.weektwo.day13;

import java.util.*;

/**
 * leetcode 15 三数之和
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/5 11:00 PM
 */
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums 包含n个整数的数组
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author guxuhua
     * @date 2022/3/5 11:01 PM
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        // 去除极值情形
        if (null == nums || nums.length < 3) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        // 最左侧指针
        for (int left = 0; left < nums.length; ++left) {
            // 需要和上一次枚举的数不相同
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            // 最右侧指针
            int right = nums.length - 1;
            // 目标值 --- 》两数之和
            int target = -nums[left];
            // 枚举 b
            for (int move = left + 1; move < nums.length; ++move) {
                // 需要和上一次枚举的数不相同
                if (move > left + 1 && nums[move] == nums[move - 1]) {
                    continue;
                }
                // 移动指针
                while (move < right && nums[move] + nums[right] > target) {
                    --right;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (move == right) {
                    break;
                }
                if (nums[move] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[left]);
                    list.add(nums[move]);
                    list.add(nums[right]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
