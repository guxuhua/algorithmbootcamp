package com.cn.dailywork.weekone.day06;

/**
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/26 10:54 PM
 */
public class Solution {

    /**
     *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * @param head 目标链表
     * @param k 目标翻转的节点数量
     * @return com.cn.dailywork.day06.Solution.ListNode
     * @author guxuhua
     * @date 2022/2/26 10:55 PM
     **/
    public ListNode reverseKGroup(ListNode head, int k) {
        // 无需执行反转
        if (null == head || null == head.next || k == 1) {
            return head;
        }
        // 虚节点，标识用
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 找出翻转结束位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 开始翻转
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            // 移动到下一个
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    /**
     *  对输入的链表执行反转操作
     * @param head 待反转的链表
     * @author guxuhua
     * @date 2022/2/26 11:17 PM
     **/
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // 临时变量，存储下一个
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
