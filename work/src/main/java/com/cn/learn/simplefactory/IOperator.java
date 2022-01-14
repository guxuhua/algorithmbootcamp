package com.cn.learn.simplefactory;

/**
 * 计算器的抽象接口，只定义行为
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 10:40 PM
 */
public interface IOperator {

    /**
     * 对数据进行运算
     *
     * @param num1 数据1
     * @param num2 数据2
     * @return java.lang.Double
     * @author guxuhua
     * @date 2022/1/10 10:41 PM
     **/
    Double getResult(Double num1, Double num2);
}
