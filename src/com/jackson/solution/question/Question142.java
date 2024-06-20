package com.jackson.solution.question;

import java.util.HashSet;

/**
 * 142.环形链表II
 * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/
 */
public class Question142 {
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
    public ListNode hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // 快慢指针
    public ListNode hasCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast!=null) {
            slow = slow.next;
            if (fast.next!=null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            // 算一下快慢相遇的时候走了多少的路
            if (fast == slow) {
                ListNode ptr = head;

                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }

        return null;

    }
}
