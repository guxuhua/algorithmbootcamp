package com.cn.learn.strategy;

/**
 * 策略模式的上下文  -- 可以与简单工厂组合使用
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/10 11:33 PM
 */
public class CashContext {
    /**
     * 抽象的策略
     */
    private ICash cash;

    public CashContext(String type) {
        switch (type) {
            case "0":
                cash = new NormalCash();
                break;
            case "满300减100":
                cash = new FullReduceCash(300.0, 100.0);
                break;
            case "8折":
                cash = new DiscountCash(0.8);
                break;
            default:
                throw new IllegalArgumentException("类型不合法");
        }
    }

    /**
     * 计算商品的支付价格
     *
     * @param price 商品原价
     * @author guxuhua
     * @date 2022/1/10 11:36 PM
     **/
    public double doCash(double price) {
        return this.cash.getPrice(price);
    }
}
