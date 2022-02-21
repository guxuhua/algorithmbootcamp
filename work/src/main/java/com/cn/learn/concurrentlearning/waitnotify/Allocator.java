package com.cn.learn.concurrentlearning.waitnotify;

import java.util.List;

/**
 * @author guxuhua
 * @version 1.0
 * @date 2022/2/20 10:34 PM
 */
public class Allocator {
    private List<Object> als;

    /**
     *  申请资源
     * @param from 资源1
     * @param to 资源2
     * @author guxuhua
     * @date 2022/2/20 10:35 PM
     **/
    public synchronized void apply(Object from, Object to) {
        while(als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            als.add(from);
            als.add(to);
        }
    }

    /**
     *  释放资源
     * @param from 资源1
     * @param to 资源2
     * @author guxuhua
     * @date 2022/2/20 10:38 PM
     **/
    public synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        // 释放锁，并通知其他竞争该锁的线程进行锁争抢
        // notify() 是会随机地通知等待队列中的一个线程，而 notifyAll() 会通知等待队列中的所有线程
        notifyAll();
    }
}
