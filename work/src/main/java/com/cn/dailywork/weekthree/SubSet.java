package com.cn.dailywork.weekthree;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣 78 子集
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/7 9:34 PM
 */
public class SubSet {

    /**
     * 内部数组
     */
    private List<Integer> inner = new ArrayList<>();
    /**
     * 返回的结果集
     */
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * @param nums 整数数组
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author guxuhua
     * @date 2022/3/7 9:35 PM
     **/
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int begin, int[] nums) {
        if (begin == nums.length) {
            ans.add(inner);
            return;
        }
        inner.add(nums[begin]);
        dfs(begin + 1, nums);
        inner.remove(inner.size() - 1);
        dfs(begin + 1, nums);
    }
}
