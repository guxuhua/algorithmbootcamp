package com.cn.learn.decorate;

/**
 * 通过
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/13 10:38 AM
 */
public class SortReport implements SchoolReport {

    /**
     * 实现自同一个接口，同时聚合该接口
     */
    private SchoolReport schoolReport;

    public SortReport(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    private void showSort() {
        System.out.println(">>>>>我的排名是第23名，进步了20个名次<<<<<");
    }

    /**
     * 汇报个人成绩
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    @Override
    public void report() {
        // 汇报前先说一下排名，排名进步了，成绩不理想也能免遭毒打
        this.showSort();
        // 照常汇报
        this.schoolReport.report();
    }

    /**
     * 汇报完成绩后，需要家长签字
     *
     * @author guxuhua
     * @date 2022/1/13 10:31 AM
     **/
    @Override
    public void sign() {
        // 照常让签名
        this.schoolReport.sign();
    }
}
