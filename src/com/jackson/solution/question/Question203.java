package com.jackson.solution.question;

/**
 * 203.移除链表元素
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 */
public class Question203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.val == val) {
                head = head.next;
                ptr = head;
                continue;
            }

            if (ptr.next != null && ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }

        }
        return head;
    }

    // 增加一个头结点的优化
}
