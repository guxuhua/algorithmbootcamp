package com.cn.dailywork.day01;


import java.util.Arrays;

/**
 * 力扣88题
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 * 示例：
 *      输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *      输出：[1,2,2,3,5,6]
 *      解释：需要合并 [1,2,3] 和 [2,5,6] 。
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/22 2:09 PM
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution current = new Solution();
        current.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums2为空
        if (n == 0) {
            return;
        }
        // nums1为空
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1,0,n);
            return;
        }
        // 开辟新的数组，存放最终的结果
        int[] newArray = new int[m+n];
        // 新数组移动的指针
        int newPoint = 0;
        // 指向nums1的指针
        int firstPoint = 0;
        // 指向nums2的指针
        int secondPoint = 0;
        while (newPoint < newArray.length) {
            if (secondPoint >= n ||  (firstPoint < m && nums1[firstPoint] <= nums2[secondPoint])) {
                newArray[newPoint] = nums1[firstPoint];
                firstPoint++;
            } else {
                newArray[newPoint] = nums2[secondPoint];
                secondPoint++;
            }

            newPoint++;
        }

        for (int i = 0; i < newArray.length; i++) {
            nums1[i] = newArray[i];
        }

    }
}
