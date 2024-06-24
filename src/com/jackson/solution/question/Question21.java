package com.jackson.solution.question;

/**
 * 21.合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class Question21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(); // 带头节点存数据
        ListNode ptr = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ptr.next = new ListNode(list1.val);
                ptr = ptr.next;
                list1 = list1.next;
            } else {
                ptr.next = new ListNode(list2.val);
                ptr = ptr.next;
                list2 = list2.next;
            }
        }

        if (list1 == null) ptr.next = list2;
        else ptr.next = list1;

        return head.next;
    }
}
