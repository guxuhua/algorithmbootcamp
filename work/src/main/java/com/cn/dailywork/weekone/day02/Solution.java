package com.cn.dailywork.weekone.day02;

/**
 * 力扣206
 *
 * 示例：
 *      输入：head = [1,2,3,4,5]
 *      输出：[5,4,3,2,1]
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/2/22 11:25 AM
 */
public class Solution {

    public static void main(String[] args) {
    }

    /**
     *  对目标链表进行反转
     * @param head 目标链表
     * @return com.cn.dailywork.day02.Solution.ListNode
     * @author guxuhua
     * @date 2022/2/22 11:27 AM
     **/
    public ListNode reverseList(ListNode head) {
        // 排除空链表的情形
        if (null == head || null == head.next){
            return head;
        }
        // 变换指针：后继指针next转为前向指针pre
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    private static class ListNode {
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
