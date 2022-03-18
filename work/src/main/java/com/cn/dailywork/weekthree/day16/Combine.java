package com.cn.dailywork.weekthree.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣 77题：组合
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/8 2:56 PM
 */
public class Combine {
    private List<Integer> inner = new ArrayList<>();

    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {

        int i = 0;
        int j = i++;

        // 字符串常量池
        String str1 = "abc";
        // 堆区
        String str2 = new String("abc");
        // 复用str1
        String str3 = str2.intern();
        // false
        System.out.println(str1 == str2);
        // false
        System.out.println(str2 == str3);
        // true
        System.out.println(str1 == str3);
    }

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * <p>
     * 示例：
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n 数组的最大边界
     * @param k 组合的个数
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author guxuhua
     * @date 2022/3/8 2:57 PM
     **/
    public List<List<Integer>> combine(int n, int k) {
        // 从1开始，截止到n，每次k个
        recursion(1, n, k);
        return ans;
    }

    private void recursion(int begin, int end, int size) {
        // 剪枝：inner 长度加上区间 [begin, end] 的长度小于 size，不可能构造出长度为 k 的 inner
        if (inner.size() + (end - begin + 1) < size) {
            return;
        }
        // 记录合法的答案
        if (inner.size() == size) {
            ans.add(new ArrayList<>(inner));
            return;
        }
        // 包含当前
        inner.add(begin);
        recursion(begin + 1, end, size);
        // 还原
        inner.remove(inner.size() - 1);
        // 不包含当前
        recursion(begin + 1, end, size);
    }
}
