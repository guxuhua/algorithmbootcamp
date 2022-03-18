package com.cn.dailywork.weektwo.day14;

/**
 * leetcode 11 盛最多水的容器
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/6 4:36 PM
 */
public class MaxArea {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     *
     * @param height 容器高度对应的数组
     * @return int
     * @author guxuhua
     * @date 2022/3/6 4:36 PM
     **/
    public int maxArea(int[] height) {
        // 最大面积
        int maxArea = 0;
        // 使用首尾两个指针：谁小移动谁
        int tail = height.length - 1;
        for (int head = 0; head < height.length; head++) {
            while (tail > head) {
                if (height[head] > height[tail]) {
                    maxArea = Math.max(maxArea, (tail - head) * height[tail]);
                    tail--;
                } else {
                    maxArea = Math.max(maxArea, (tail - head) * height[head]);
                    head++;
                }
            }
        }
        return maxArea;
    }
}
