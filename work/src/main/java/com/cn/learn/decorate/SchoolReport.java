package com.cn.learn.decorate;

/**
 * 学生成绩汇报接口
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/13 10:30 AM
 */
public interface SchoolReport {

    /**
     * 汇报个人成绩
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    void report();

    /**
     * 汇报完成绩后，需要家长签字
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    void sign();
}
