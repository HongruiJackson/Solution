package com.jackson.solution.question;

import org.junit.Test;

/**
 * 328.奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/description/
 */
public class Question328 {

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

    public void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println("]");
    }

    public ListNode oddEvenList(ListNode head) {
        // 1. 先判断特殊情况
        if (head == null || head.next == null) return head; // 当只有一个结点或者结点为空的情况直接返回
        // 2. 当有两个或者两个以上的结点
        // 3. 先给原链表加上一个头结点，使其变为有头链表
        ListNode oddHead = new ListNode();
        oddHead.next = head;
        // 4. 维护一个偶结点
        ListNode evenHead = new ListNode();
        evenHead.next = null;
        // 5. 遍历原链表
        ListNode oddPtr = null;
        ListNode evenPtr = evenHead; // 偶结点链表尾指针
        // 5.1 先将ptr移动到第一个结点
        oddPtr = head;
        while (oddPtr.next != null) {
            // 偶链表插入，并移到末尾
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
            // 原链表删除
            oddPtr.next = oddPtr.next.next;
            if (oddPtr.next != null) oddPtr = oddPtr.next;
            // 原结点断开
            evenPtr.next = null;
        }

        oddPtr.next = evenHead.next;
        return oddHead.next;

    }

    @Test
    public void test() {
        int[] array = {1,2,3,4,5,6,7,8};
        ListNode head = generateList(array);
        printList(head);
        oddEvenList(head);
    }


}
