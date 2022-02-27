package com.cn.homework.weekone;

/**
 * leetcode21：合并两个有序数组
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/2/27 10:53 AM
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 先判断极值：输入项为空
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        // 存储合并后的结果
        ListNode val = new ListNode();
        // 输入项的头节点
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode prev = val;
        // 指针逐项向后扫描
        while (null != head1) {
            if (null != head2) {
                // 谁小先放谁
                if (head1.val >= head2.val) {
                    prev.next = head2;
                    head2 = head2.next;
                }else {
                    prev.next = head1;
                    head1 = head1.next;
                }
            }else {
                // 输入项1存在剩余，全部放入到尾部
                prev.next = head1;
                head1 = head1.next;
            }
            prev = prev.next;
        }
        // 输入项2存在剩余，全部放入到尾部
        while (null != head2) {
            prev.next = head2;
            head2 = head2.next;
            prev = prev.next;
        }
        return val.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
