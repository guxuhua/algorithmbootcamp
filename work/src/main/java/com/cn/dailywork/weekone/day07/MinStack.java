package com.cn.dailywork.weekone.day07;

import java.util.Stack;

/**
 * leetcode 155：最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/27 11:23 PM
 */
public class MinStack {

    /**
     * 保存实际内容
     * */
    private Stack<Integer> stack = new Stack<>();
    /**
     * 保存当前操作到的最小值
     * */
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        // 压栈操作记录最小值
        int minVal = val;
        if (!minStack.isEmpty()) {
            minVal = val > minStack.peek()? minStack.peek():val;
        }
        stack.push(val);
        // 最小值也压栈
        minStack.push(minVal);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
