package com.cn.dailywork.weekone.day03;

/**
 * leetcode 141题
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/23 2:36 PM
 */
public class Solution {
    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     * @param head 链表的头节点
     * @return boolean
     * @author guxuhua
     * @date 2022/2/23 2:37 PM
     **/
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return Boolean.FALSE;
        }
        // 快指针
        ListNode runPoint = head;
        // 跑环开始
        while (null != head && null != runPoint.next && null != runPoint.next.next) {
            // 每次跑2格
            runPoint = runPoint.next.next;
            // 每次跑1格
            head = head.next;
            if (runPoint == head) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
