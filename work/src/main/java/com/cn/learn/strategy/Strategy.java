package com.cn.learn.strategy;

/**
 * 策略模式测试类
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 11:47 PM
 */
public class Strategy {

    public static void main(String[] args) {
        // 普通情况
        CashContext context = new CashContext("0");
        System.out.println(context.doCash(100.0));

        // 满减
        context = new CashContext("满300减100");
        System.out.println(context.doCash(700.0));

        // 打折
        context = new CashContext("8折");
        System.out.println(context.doCash(600.0));
    }
}
