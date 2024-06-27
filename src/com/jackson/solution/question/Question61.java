package com.jackson.solution.question;

/**
 * 61.旋转链表
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class Question61 {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k==0) return head;
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        k = length-k%length; // 该题其实是倒着走的，如果是正着走直接k%length即可

        for (int i = 0; i < k ; i++) {
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }
}
