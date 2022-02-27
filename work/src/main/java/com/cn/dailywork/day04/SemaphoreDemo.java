package com.cn.dailywork.day04;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/24 4:37 PM
 */
public class SemaphoreDemo {

    /**
     * 初始化一个信号量
     */
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    SEMAPHORE.acquire();
                    System.out.println(Thread.currentThread().getName() + "...开始运行");
                    // 释放信号量
                    SEMAPHORE.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "第1个线程" + i).start();

            new Thread(() -> {
                try {
                    SEMAPHORE.acquire();
                    System.out.println(Thread.currentThread().getName() + "...开始运行");
                    // 释放信号量
                    SEMAPHORE.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "第2个线程" + i).start();
        }


    }
}
