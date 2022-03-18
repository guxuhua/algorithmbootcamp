package com.cn.dailywork.weekthree.day18;

/**
 * 力扣 50题 Pow(x,n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/10 11:23 PM
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        double res = pow.myPow(2.0, 10);
        System.out.println(res);
        res = pow.myPow(2.0, -2);
        System.out.println(res);
    }

    /**
     * 示例1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * <p>
     * 示例2：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     * @param x 底数
     * @param n 幂次
     * @return double
     * @author guxuhua
     * @date 2022/3/10 11:24 PM
     **/
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / (myPow(x, -n - 1) * x);
        }
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        // 每次算一半
        double halfPow = myPow(x, n / 2);
        double ans = halfPow * halfPow;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
    }
}
