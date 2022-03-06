package com.cn.dailywork.weektwo.day10;

import java.util.*;

/**
 * leetcode 146 LRU缓存
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/2 5:42 PM
 */
public class LRUCache {

    public static void main(String[] args) {
        // 测试
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));

    }

    /**
     * 一个hash散列，存储key - value的值的对应关系，确保查询效率为O(1)
     */
    private Map<Integer, Node> hash;

    /**
     * 存储实际的值的链表的头节点
     */
    private Node head = new Node();
    /**
     * 存储实际的值的链表的尾部节点
     */
    private Node tail = new Node();

    /**
     * 实际存储的值
     */
    private int size = 0;

    /**
     * 容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        hash = new HashMap<>(capacity);
        // 首尾指针互指
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("=======begin" + key);
        Set<Integer> keys = hash.keySet();
        for (Integer k :keys) {
            System.out.println(k);
        }
        System.out.println("=======end" + key);
        // 包含key，返回当前值，否则返回-1
        if (hash.containsKey(key)) {
            Node exit = hash.get(key);
            // 将当前节点放到头部 -- 先删除后插入
            remove(exit);
            insert(exit);
            return exit.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果已在，更新即可
        if (hash.containsKey(key)) {
            // 找出来并更新
            Node exit = hash.get(key);
            exit.val = value;
            remove(exit);
            insert(exit);
            hash.put(key, exit);
        } else {
            // 插入一个节点
            Node node = new Node();
            node.key = key;
            node.val = value;
            if (size == capacity) {
                // 需要删除尾部
                remove(tail.pre);
                // 在插入到头部
                insert(node);
                hash.remove(tail.pre.key);
            } else {
                // 先插入node
                insert(node);
                // 已装载的元素数量+1
                size++;
            }
            hash.put(key, node);
        }
        System.out.println("size=" + size + ",capacity=" + capacity);

    }

    /**
     * 删除节点
     *
     * @param node 待删除的节点
     * @author guxuhua
     * @date 2022/3/2 5:54 PM
     **/
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 新增一个节点
     *
     * @param node 插入一个节点
     * @author guxuhua
     * @date 2022/3/2 5:56 PM
     **/
    private void insert(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    /**
     * 用于存储LRU缓存的值的结构
     *
     * @author guxuhua
     * @date 2022/3/2 5:45 PM
     **/
    private class Node {
        private int key;
        private int val;
        private Node pre;
        private Node next;
    }
}
