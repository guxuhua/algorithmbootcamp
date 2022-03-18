package com.cn.homework.weekthree;

/**
 * 力扣23题 合并K个升序链表
 * todo 照着解析做的，后续还要继续做
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/18 18:53
 */
public class MergeList {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * @param lists 链表数组
     * @return com.cn.homework.weekthree.MergeList.ListNode
     * @author guxuhua
     * @date 2022/3/18 18:54
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) >> 1;
        return mergeTwoLists(merge(lists, begin, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left != null ? left : right;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = left, bPtr = right;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
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
