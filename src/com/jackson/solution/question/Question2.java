package com.jackson.solution.question;

import org.junit.Test;

/**
 * 2.两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/
 */
public class Question2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode generateList(int[] array) {
        ListNode nodeHead = new ListNode(array[0],null);
        ListNode ptr = nodeHead;
        for (int i = 1; i < array.length; i++) {
            ptr.next = new ListNode(array[i],null);
            ptr = ptr.next;
        }
        return nodeHead;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerHead = new ListNode();
        ListNode ptr = answerHead;
        int next = 0;
        // 1. 先将短的给遍历完
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + next;
            next = val/10;
            val = val%10;
            ptr.next = new ListNode(val);
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int val = + l2.val + next;
                next = val/10;
                val = val%10;
                ptr.next = new ListNode(val);
                ptr = ptr.next;
                l2 = l2.next;

            }
        } else {
            while (l1 != null) {
                int val = l1.val + next;
                next = val/10;
                val = val%10;
                ptr.next = new ListNode(val);
                ptr = ptr.next;
                l1 = l1.next;
            }
        }

        if (next!=0) ptr.next = new ListNode(next);

        return answerHead.next;
    }

    @Test
    public void test() {
        int[] array = {2,4,3};
        int[] array2= {5,6,4};
        ListNode head = generateList(array);
        ListNode head2 = generateList(array2);
        addTwoNumbers(head,head2);
    }
}
