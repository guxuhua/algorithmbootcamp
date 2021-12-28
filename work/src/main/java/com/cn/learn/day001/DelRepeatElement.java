package com.cn.learn.day001;

import java.util.Arrays;

/**
 * leetcode 26题
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/27 9:49 PM
 */
public class DelRepeatElement {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        DelRepeatElement object = new DelRepeatElement();
        System.out.println(object.removeDuplicates(nums));

    }

    /**
     * 从静态数组中删除重复项  --- 存在重复的后移
     *
     * @param nums 目标数组
     * @return int
     * @author guxuhua
     * @date 2021/12/27 9:51 PM
     **/
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 从第二位开始扫描，和前一位相等就和后继位交换
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 留下要的
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
