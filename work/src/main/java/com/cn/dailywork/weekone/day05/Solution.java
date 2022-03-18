package com.cn.dailywork.weekone.day05;

import java.util.Stack;

/**
 * leetcode 20题：有效的括号
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/25 9:14 PM
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "(])";
        boolean result = solution.isValid(input);
        System.out.println(result);
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param s 给定字符串
     * @return boolean
     * @author guxuhua
     * @date 2022/2/25 9:14 PM
     **/
    public boolean isValid(String s) {
        // 先判空
        if (null == s || "".equals(s)) {
            return Boolean.FALSE;
        }
        // 存放左括号的栈
        Stack<Character> lefts = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 遇到左括号压入栈顶
            if (ch == '(' || ch == '{' || ch == '[') {
                lefts.push(ch);
            } else {
                // 右括号，与栈顶元素匹配
                if (lefts.isEmpty()) {
                    return Boolean.FALSE;
                }
                if (ch == ')' && lefts.peek() == '(') {
                    // ()的情形可以匹配,栈顶出栈，继续匹配
                    lefts.pop();
                    continue;
                }
                if (ch == '}' && lefts.peek() == '{') {
                    // {}的情形可以匹配,栈顶出栈，继续匹配
                    lefts.pop();
                    continue;
                }
                if (ch == ']' && lefts.peek() == '[') {
                    // []的情形可以匹配,栈顶出栈，继续匹配
                    lefts.pop();
                    continue;
                }
                return Boolean.FALSE;
            }
        }
        // 匹配扫描完成，若栈不为空，则括号不合法
        return lefts.isEmpty();
    }
}
