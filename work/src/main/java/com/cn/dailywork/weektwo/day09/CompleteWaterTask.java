package com.cn.dailywork.weektwo.day09;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用CompleteFuture实现：
 * 1、洗水壶1分钟、烧开水15分钟
 * 2、洗茶壶1分钟、洗茶杯2分钟、拿茶叶
 * 3、泡茶
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/1 10:30 PM
 */
public class CompleteWaterTask {

    public static void main(String[] args) {
        // 洗水壶1分钟、烧开水15分钟
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1:洗水壶.....");
            doSleep(1, TimeUnit.SECONDS);
            System.out.println("task1:烧开水.....");
            doSleep(15, TimeUnit.SECONDS);
            return "山泉水好了";
        });
        // 洗茶壶1分钟、洗茶杯2分钟、拿茶叶
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2:洗茶壶.....");
            doSleep(1, TimeUnit.SECONDS);
            System.out.println("task2:洗茶杯.....");
            doSleep(2, TimeUnit.SECONDS);
            System.out.println("task2:拿茶叶.....");
            return "龙井";
        });
        // 任务三：泡茶
        CompletableFuture<String> mainTask = task1.thenCombine(task2, (a, b) -> {
            System.out.println("task1:水好了:" + a);
            System.out.println("task2:茶叶好了:" + b);
            System.out.println("main:泡茶...");
            return "上茶:" + b;
        });
        System.out.println(mainTask.join());
    }

    private static void doSleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }
}
