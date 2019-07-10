package queue.impl;

import queue.MyQueue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 19:52
 * Description :
 */
public class LinkedListOfQueue<E> implements MyQueue<E> {

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(E e) {
        if (tail == null) {
            tail = new ListNode(e);
            head = tail;
        } else {
            tail.next = new ListNode(e);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        return (E)head.data;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        ListNode res = head;
        head = head.next;
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return (E)res.data;
    }

    @Override
    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {
        E data;
        ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }

    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListOfQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}
