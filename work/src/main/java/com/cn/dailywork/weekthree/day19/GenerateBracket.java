package com.cn.dailywork.weekthree.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣22题 生成括号
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/11 11:31 PM
 */
public class GenerateBracket {
    List<String> cache = new ArrayList<>();

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * @param n 需要生成的括号的对数
     * @return java.util.List<java.lang.String>
     * @author guxuhua
     * @date 2022/3/11 11:32 PM
     **/
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    public List<String> generate(int n) {
        if (cache.get(n) != null) {
            return cache;
        }
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache = ans;
        return ans;
    }
}
