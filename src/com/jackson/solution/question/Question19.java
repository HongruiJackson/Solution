package com.jackson.solution.question;

/**
 * 19.删除链表的倒数第N个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */

public class Question19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slow_pre = null;
        // 指针两点变为一线，也就是用一根棍子去在数组移动
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow_pre = slow;
            slow = slow.next;
        }
        // 若慢指针前一个的为null，则代表删除的是第一节点
        if (slow_pre == null) {
            head = head.next;
            return head;
        }
        // 其他情况是用pre
        slow_pre.next = slow.next;
        return head;


    }
}
