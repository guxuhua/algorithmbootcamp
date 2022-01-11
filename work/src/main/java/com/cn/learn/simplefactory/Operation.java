package com.cn.learn.simplefactory;

/**
 * 调用类 - 负责测试
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/1/10 10:54 PM
 */
public class Operation {

    public static void main(String[] args) {
        // 加法操作
        IOperator operator = OperatorFactory.createOperator('+');
        System.out.println(operator.getResult(1.0, 2.2));

        // 减法
        operator = OperatorFactory.createOperator('-');
        System.out.println(operator.getResult(3.0, 1.7));

        // 积
        operator = OperatorFactory.createOperator('*');
        System.out.println(operator.getResult(1.1, 1.1));

        // 商
        operator = OperatorFactory.createOperator('/');
        System.out.println(operator.getResult(2.1, 0.3));
    }
}
