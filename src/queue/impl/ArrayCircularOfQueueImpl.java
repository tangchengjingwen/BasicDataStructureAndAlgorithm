package queue.impl;

import queue.MyQueue;

import java.util.EmptyStackException;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 20:49
 * Description :
 */
public class ArrayCircularOfQueueImpl<E> implements MyQueue<E> {

    private E[] data;
    private int head;
    private int tail;

    public ArrayCircularOfQueueImpl() {
        this(10);
    }

    public ArrayCircularOfQueueImpl(int capacity) {
        this.data = (E[])new Object[capacity];
        head = 0;
        tail = 0;
    }
    @Override
    public int size() {
        return (tail - head + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean offer(E e) {
        data[tail] = e;
        tail = (tail + 1) % data.length;
        if (tail == head) {
            resize(data.length * 2);
        }
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        return data[head];
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        E obj = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("size : " + size());
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[(i + head) % data.length];
        }
        head = 0;
        tail = data.length;
        data = temp;
    }
}
