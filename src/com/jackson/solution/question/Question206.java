package com.jackson.solution.question;

/**
 * 206.反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class Question206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, Question19.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        // 空链表和size为1的链表直接返回即可
        if (head == null || head.next == null) return head;
        // 不为null的时候始终将原头位置的下一个结点移动到头部、
        ListNode originalHead = head;
        while (originalHead.next != null) {
            ListNode temp = originalHead.next;
            originalHead.next = originalHead.next.next;
            temp.next = head;
            head = temp;

        }
        return head;

    }
}
