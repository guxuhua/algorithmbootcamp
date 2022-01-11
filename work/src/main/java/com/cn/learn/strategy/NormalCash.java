package com.cn.learn.strategy;

/**
 * 普通情况：不打折、不返积分、不满减
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/1/10 11:29 PM
 */
public class NormalCash implements ICash {
    /**
     * 获取商品的实际支付价格
     *
     * @param price 商品价格
     * @return double
     * @author guxuhua
     * @date 2022/1/10 11:27 PM
     **/
    @Override
    public double getPrice(double price) {
        System.out.println("通常情况下的销售行为");
        return price;
    }
}
