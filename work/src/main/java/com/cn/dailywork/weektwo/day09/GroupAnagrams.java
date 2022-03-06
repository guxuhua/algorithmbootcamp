package com.cn.dailywork.weektwo.day09;

import java.util.*;

/**
 * leetcode 49：字母异位词分组
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/1 2:59 PM
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams group = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = group.groupAnagrams(strs);
        for (List<String> r : res) {
            System.out.println(r);
        }
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * @param strs 字符串数组
     * @return java.util.List<java.util.List < java.lang.String>>
     * @author guxuhua
     * @date 2022/3/1 3:00 PM
     **/
    public List<List<String>> groupAnagrams(String[] strs) {
        // 普适情况：一个hash放置当前字符串的长度 key = 长度，value = hash 包含的字符
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            // 转为字符数组
            char[] array = str.toCharArray();
            // 排序并组成key
            Arrays.sort(array);
            String key = new String(array);
            System.out.println("key=" + key + ",str=" + str);
            if (res.containsKey(key)) {
                List<String> inner = res.get(key);
                inner.add(str);
                res.put(key, inner);
            } else {
                List<String> inner = new ArrayList<>();
                inner.add(str);
                res.put(key, inner);
            }
        }
        return new ArrayList<List<String>>(res.values());
    }
}
