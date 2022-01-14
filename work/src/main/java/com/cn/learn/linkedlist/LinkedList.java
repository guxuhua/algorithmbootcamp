package com.cn.learn.linkedlist;

/**
 * leetcode 203题
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 测试：
 *  对ListNode类做一次优化
 * 优化：使用虚拟头节点进行优化
 * 优化2：使用递归
 *
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/29 9:32 PM
 */
public class LinkedList {

    /**
     * 从链表中移除元素
     *
     * @param head 链表的头节点
     * @param val  满足条件的值
     * @return com.cn.learn.linkedlist.LinkedList.ListNode
     * @author guxuhua
     * @date 2021/12/29 9:33 PM
     **/
    public ListNode removeElements(ListNode head, int val) {
        // 去除链表开始时，所有节点值为val 的
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // 遍历，将满足head.val == val的节点删除
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }

        }

        return head;
    }

    public ListNode recursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            ListNode delNode = head;
            head = null;
            head = delNode.next;
        }else {
            head = head.next;
        }
        return recursion(head, val);
    }
    /**
     * 内部类形式实现的链表节点
     *
     * @author guxuhua
     * @date 2021/12/29 9:33 PM
     **/
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
