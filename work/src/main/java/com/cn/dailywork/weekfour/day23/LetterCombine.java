package com.cn.dailywork.weekfour.day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 力扣17题 电话号码的字母组合
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/15 11:24 PM
 */
public class LetterCombine {

    private List<String> ans = new ArrayList<>();


    // 确定数字和字母的映射关系
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        // 去除极值
        if (null == digits || "".equals(digits) || "1".equals(digits)) {
            return ans;
        }
        // 正常递归求值
        recursion(digits, new StringBuilder(), 0);
        return ans;
    }

    private void recursion(String str, StringBuilder letter, int index) {
        // 终止条件
        if (index == str.length()) {
            ans.add(letter.toString());
            return;
        }
        char c = str.charAt(index);

        int pos = c - '0';

        String mapString = phone.get(pos);
        for (int i = 0; i < mapString.length(); i++) {
            letter.append(mapString.charAt(i));
            recursion(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }

    public static void main(String[] args) {
        char c = '1';
        System.out.println(c - '0');
    }
}
