package com.cn.learn.simplefactory;

/**
 * 简单工厂类 - 负责对象的创建
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 10:48 PM
 */
public class OperatorFactory {

    /**
     * 根据传入的类型，返回实际的对象
     *
     * @param type 实际的类型
     * @return com.cn.learn.simplefactory.IOperator
     * @author guxuhua
     * @date 2022/1/10 10:49 PM
     **/
    public static IOperator createOperator(char type) {
        IOperator operator = null;
        switch (type) {
            case '+':
                operator = new AddOperator();
                break;
            case '-':
                operator = new SubOperator();
                break;
            case '*':
                operator = new MultiOperator();
                break;
            case '/':
                operator = new DivisionOperator();
                break;
            default:
                throw new IllegalArgumentException("非法的操作类型");
        }

        return operator;


    }
}
