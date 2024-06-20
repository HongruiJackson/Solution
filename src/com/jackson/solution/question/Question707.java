package com.jackson.solution.question;

import org.junit.Test;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/description/
 */
public class Question707 {
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    // 带头单向链表
    public class MyLinkedList {
        int size;
        ListNode head;

        // 初始化 MyLinkedList 对象。
        public MyLinkedList() {
            this.size = 0;
            this.head = new ListNode(0);
        }

        //  获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
        public int get(int index) {
            // 如果下标无效，则返回-1
            if (index < 0 || index >= this.size) {
                return -1;
            }
            ListNode cur = this.head;
            // 返回相应的值
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
        // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
        // 如果 index 比长度更大，该节点将不会插入到链表中。
        public void addAtIndex(int index, int val) {
            if (index > this.size) return;
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;

            size++;
        }

        //  将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = this.head.next;
            this.head.next = newNode;
            size++;
        }

        // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
        public void addAtTail(int val) {
            ListNode iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new ListNode(val);
            size++;
        }



        // 如果下标有效，则删除链表中下标为 index 的节点。
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }

}
