package com.cn.dailywork.weektwo.day09;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 线程1：洗水壶1分钟、烧开水15分钟
 * 线程2：洗茶壶1分钟、洗茶杯2分钟、拿茶叶
 * 最终：泡茶
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/1 9:30 PM
 */
public class WaterTask {

    public static void main(String[] args) throws Exception {
        // 创建未来任务
        FutureTask<String> task1 = new FutureTask<>(new Tea());
        FutureTask<String> task2 = new FutureTask<>(new Water(task1));
        // 创建线程并启动
        Thread t1 = new Thread(task1);
        t1.start();
        Thread t2 = new Thread(task2);
        t2.start();
        // get()方法会阻塞
        System.out.println(task1.get());
    }

    private static class Water implements Callable<String> {
        private FutureTask<String> task;

        public Water(FutureTask<String> task) {
            this.task = task;
        }

        @Override
        public String call() throws Exception {
            // 洗水壶1分钟、烧开水15分钟
            System.out.println("~~~~~洗水壶~~~~~");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("~~~~~烧开水~~~~~");
            TimeUnit.SECONDS.sleep(1);
            // 等待线程2执行完，执行泡茶
            task.get();
            System.out.println(">>>>>开始泡茶<<<<<<");
            return "请用茶";
        }
    }

    private static class Tea implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(".....洗茶壶.....");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(".....洗茶杯.....");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(".....拿茶叶.....");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }
}
