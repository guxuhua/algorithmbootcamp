package com.cn.learn.decorate;

/**
 * 我的个人成绩
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/13 10:33 AM
 */
public class MyReport implements SchoolReport {
    /**
     * 汇报个人成绩
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    @Override
    public void report() {
        System.out.println("=====我的成绩是：");
        System.out.println("语文65，数学75，英语77，体育80");
        System.out.println("汇报结束=====");
    }

    /**
     * 汇报完成绩后，需要家长签字
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    @Override
    public void sign() {
        System.out.println("请您签字:");
    }
}
