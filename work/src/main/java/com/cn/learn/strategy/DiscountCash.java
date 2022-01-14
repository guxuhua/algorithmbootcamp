package com.cn.learn.strategy;

/**
 * 打折出售
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 11:28 PM
 */
public class DiscountCash implements ICash {

    /**
     * 需要传入商品的折扣
     */
    private double discount;

    public DiscountCash(double discount) {
        this.discount = discount;
    }

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
        System.out.println(String.format("对售价：%1$,.2f进行打：%2$,.2f销售", price, discount));
        return price * discount;
    }
}
