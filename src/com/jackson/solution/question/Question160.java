package com.jackson.solution.question;

/**
 * 160.相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class Question160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    /*
    对于两个链表
    a1 a2 c1 c2 c3
    b1 b2 b3 c1 c2 c3
    有
    a1 a2 c1 c2 c3 b1 b2 b3 c1
    b1 b2 b3 c1 c2 c3 a1 a2 c1
    走过别人走的路
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!=pB) {
            if (pA == null ) {
                pA = headB;
            } else pA = pA.next;
            if (pB == null ) {
                pB = headA;
            } else pB = pB.next;
        }
        return pB;
    }
}
