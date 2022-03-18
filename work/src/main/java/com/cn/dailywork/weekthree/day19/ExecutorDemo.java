package com.cn.dailywork.weekthree.day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/12 11:46 AM
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(8);

        exe.submit(() -> System.out.println("线程池开始执行"));
    }
}
