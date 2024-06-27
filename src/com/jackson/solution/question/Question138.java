package com.jackson.solution.question;

import java.util.HashMap;
import java.util.Map;

/**
 * 138.随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
public class Question138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    };

    // 全局哈希+递归
    Map<Node, Node> map = new HashMap<>(); // key 为旧的结点，value为新的结点
    public Node copyRandomList1(Node head) {
        if (head == null) return null; // 空链表直接返回
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            // 放入哈希表当中
            map.put(head,newNode);
            // 新结点的next就是就旧结点next的新结点，random同理
            newNode.next = copyRandomList1(head.next);
            newNode.random = copyRandomList1(head.random);
        }
        return map.get(head);
    }
}
