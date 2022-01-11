package com.cn.learn.simplefactory;

/**
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/1/10 10:45 PM
 */
public class DivisionOperator implements IOperator {
    /**
     * 对数据进行运算
     *
     * @param num1 数据1
     * @param num2 数据2
     * @return java.lang.Double
     * @author guxuhua
     * @date 2022/1/10 10:41 PM
     **/
    @Override
    public Double getResult(Double num1, Double num2) {
        System.out.println(String.format("计算数据：%1$,.2f和%2$,.2f的商", num1, num2));
        try {
            return num1 / num2;
        } catch (Exception e) {
            throw new IllegalArgumentException("除数不允许为0");
        }
    }
}
