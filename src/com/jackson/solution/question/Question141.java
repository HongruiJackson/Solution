package com.jackson.solution.question;

import java.util.HashSet;

/**
 * 141.环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 */
public class Question141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // set集合和add方法的返回值，哈希表
    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    // 快慢指针
    public boolean hasCycle(ListNode head) {
        // 首先将慢指针放于链表头，块指针放于前一位置
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        // 追到停止循环
        while (fast != slow) {
            // 或者无环停止循环
            if (fast==null || fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
