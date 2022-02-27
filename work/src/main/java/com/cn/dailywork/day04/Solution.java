package com.cn.dailywork.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣：142题
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/24 2:43 PM
 */
public class Solution {


    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     *
     * @param head 链表的头节点
     * @return com.cn.dailywork.day04.Solution.ListNode
     * @author guxuhua
     * @date 2022/2/24 2:44 PM
     **/
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        // 1 --->判断是否有环:快慢指针
        ListNode fast = head, slow = head;
        while (fast != null ) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return null;
            }

            if (slow == fast) {
                // 2 --->相遇的点:快指针重头出发，再次相遇的地方就是环开始的地方
                fast = head;
                while (fast != slow) {
                    // 3 --->快指针的速度和慢指针保持一致
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
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
