package com.cn.learn.strategy;

/**
 * 满减活动  -- 需传入满多少减多少
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 11:31 PM
 */
public class FullReduceCash implements ICash {

    /**
     * 每满多少进行扣除
     */
    private double fullCash;

    /**
     * 减少的金额
     */
    private double reduceCash;

    public FullReduceCash(double fullCash, double reduceCash) {
        this.fullCash = fullCash;
        this.reduceCash = reduceCash;
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
        System.out.println(String.format("对销售价格：%1$,.2f进行满%2$,.2f减去%3$,.2f的操作", price, fullCash, reduceCash));
        double num = fullCash / price;

        return price - num * reduceCash;
    }
}
