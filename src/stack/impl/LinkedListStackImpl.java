package stack.impl;

import stack.MyLinkedListStack;

import java.util.LinkedList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 17:00
 * Description :
 */
public class LinkedListStackImpl<E> implements MyLinkedListStack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStackImpl() {
        this.linkedList = new LinkedList<>();
    }


    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void print() {
        System.out.println("size : " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
