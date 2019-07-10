package queue.impl;

import queue.MyQueue;

import java.util.EmptyStackException;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 20:29
 * Description :
 */
public class ArrayOfQueueImpl<E> implements MyQueue<E> {
    private E[] data;

    private int head;
    private int tail;
    private int size;

    public ArrayOfQueueImpl() {
        this(10);
    }

    public ArrayOfQueueImpl(int capacity) {
        this.data = (E[])new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

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
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = e;
        size++;
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
            new EmptyStackException();
        }
        E obj = data[head++];

        if (head == data.length) {
            head = 0;
        }
        size--;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
