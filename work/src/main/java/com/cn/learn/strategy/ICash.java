package com.cn.learn.strategy;

/**
 * 商场收银的抽象接口
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 11:26 PM
 */
public interface ICash {

    /**
     * 获取商品的实际支付价格
     *
     * @param price 商品价格
     * @return double
     * @author guxuhua
     * @date 2022/1/10 11:27 PM
     **/
    double getPrice(double price);
}
