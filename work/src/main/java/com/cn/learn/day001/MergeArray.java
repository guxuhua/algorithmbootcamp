package com.cn.learn.day001;

import java.util.Arrays;

/**
 * leetcode 88题
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 示例：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/27 12:36 PM
 */
public class MergeArray {

    public static void main(String[] args) {
        MergeArray merge = new MergeArray();
        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        // merge.merge(nums1, m, nums2, n);
        // System.out.println(">>>>>输出是：" + Arrays.toString(nums1));

        merge.mergePro(nums1, m, nums2, n);
        System.out.println(">>>>>pro输出是：" + Arrays.toString(nums1));
    }

    /**
     * 合并  -- 排序方式实现
     *
     * @param nums1 有序数组1
     * @param m     数组1的元素个数
     * @param nums2 有序数组2
     * @param n     数组2的元素个数
     * @author guxuhua
     * @date 2021/12/27 12:38 PM
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 极端情况1：nums2为空
        if (n == 0) {
            // 无序合并
            return;
        }
        // 极端情况2：nums1为空
        if (m == 0) {
            // 进行数组的值拷贝
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        // 先合并，后排序
        int count = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[count++];
        }
        if (nums1[m - 1] <= nums1[m]) {
            // 已经有序，无需处理
            return;
        }
        // 无序，需要处理排序  --- 使用插入排序(部分有序，插入效率高)
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums1[j] < nums1[j - 1]) {
                    // 进行交换
                    int temp = nums1[j];
                    nums1[j] = nums1[j - 1];
                    nums1[j - 1] = temp;
                }
            }
        }
    }


    /**
     * 合并  -- 空间换时间
     *
     * @param nums1 有序数组1
     * @param m     数组1的元素个数
     * @param nums2 有序数组2
     * @param n     数组2的元素个数
     * @author guxuhua
     * @date 2021/12/27 12:38 PM
     **/
    public void mergePro(int[] nums1, int m, int[] nums2, int n) {
        // 极端情况1：nums2为空
        if (n == 0) {
            // 无序合并
            return;
        }
        // 极端情况2：nums1为空
        if (m == 0) {
            // 进行数组的值拷贝
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        // 新数组，用于保存排序后的值
        int[] newArray = new int[m + n];
        // 新数组的起始指针
        int begin = 0;
        // 数组nums1的扫描指针
        int beginNums1 = 0;
        // 数组nums2的扫描指针
        int startNums2 = 0;
        while (begin < newArray.length) {
            if (startNums2 >= n ||  (beginNums1 < m && nums1[beginNums1] <= nums2[startNums2])) {
                newArray[begin] = nums1[beginNums1];
                beginNums1++;
            } else {
                newArray[begin] = nums2[startNums2];
                startNums2++;
            }

            begin++;
        }
        for (int i = 0; i < newArray.length; i++) {
            nums1[i] = newArray[i];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
