package com.jackson.solution.question;

import org.junit.Test;

/**
 * 234.回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 */
public class Question234 {
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

    // 快慢双指针的累计可以得到路径的长度
    public boolean isPalindrome(ListNode head) {
        // 1. 判断特殊情况
        if (head == null) return false;
        if (head.next == null) return true;

        // 2. 找到前半部分链表的尾结点
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 3. 反转后半部分链表
        slow = reverseList(slow.next);

        // 4. 判断是否回文
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        //
        return true;

    }

    public ListNode reverseList(ListNode head) {
        // 空链表和size为1的链表直接返回即可
        if (head == null || head.next == null) return head;
        // 不为null的时候始终将原头位置的下一个结点移动到头部
        ListNode originalHead = head;
        while (originalHead.next != null) {
            ListNode temp = originalHead.next;
            originalHead.next = originalHead.next.next;
            temp.next = head;
            head = temp;

        }
        return head;

    }

    @Test
    public void test() {
        int[] array = {1,2,2,1};
        ListNode head = generateList(array);

        isPalindrome(head);
    }

}
