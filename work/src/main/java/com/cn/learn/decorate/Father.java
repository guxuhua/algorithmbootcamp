package com.cn.learn.decorate;

/**
 * 向家长汇报个人成绩
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/13 10:36 AM
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport sr = new MyReport();
        // 直接汇报，这成绩肯定要遭殃
        sr.report();
        sr.sign();

        // 使用装饰器装饰一下，避免被毒打～～
        SchoolReport decorator = new SortReport(sr);
        decorator.report();
        decorator.sign();
        String approvedBandWidth = "5,6";
        String[] approvedBandWidthS = approvedBandWidth.split("\\,");
        for (int j = 0; j < approvedBandWidthS.length; j++) {
            System.out.println(Integer.parseInt(approvedBandWidthS[j]));
        }
    }
}
