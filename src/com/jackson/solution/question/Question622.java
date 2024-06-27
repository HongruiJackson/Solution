package com.jackson.solution.question;

/**
 * 622.设计循环队列
 * https://leetcode.cn/problems/design-circular-queue/description/
 */
public class Question622 {
    class MyCircularQueue {

        int front;
        int rear;
        int size;

        int[] array;

        public MyCircularQueue(int k) {
            front = 0;
            rear = 0;
            size = k+1;
            array = new int[k+1];
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            rear = (rear+1)%size;
            array[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            front = (front+1)%size;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return array[(front+1)%size];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return array[rear];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear+1)%(size) == front;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
