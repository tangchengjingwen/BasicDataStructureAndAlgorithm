package myList.linkedList.impl;

//import myList.linkedList.ListNode;
import myList.linkedList.MyLinkedList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 13:31
 * Description :  有头的ListNode
 */
public class LinkedListImpl<E> implements MyLinkedList<E> {

    private int size;

    private ListNode dummy;

    public LinkedListImpl() {
        this.dummy = new ListNode(0);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * time : O(n)
     * @param index
     * @param data
     */
    @Override
    public void addIndex(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is not valid");
        }

        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode node = new ListNode(data);
        // 顺序别写错了
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * time : O(n)
     * @param data
     * @return
     */
    @Override
    public boolean addElement(E data) {
        addIndex(size, data);
        return true;
    }

    /**
     * time : O(1)
     * @param data
     */
    @Override
    public void addFirst(E data) {
        addIndex(0, data);
    }

    /**
     * time : O(n)
     * @param data
     */
    @Override
    public void addLast(E data) {
        addIndex(size, data);
    }

    /**
     * time : O(1)
     * @return
     */
    @Override
    public E removeFirst() {
        return removeIndex(0);
    }

    /**
     * time : O(n)
     * @return
     */
    @Override
    public E removeLast() {
        return removeIndex(size - 1);
    }

    /**
     * time : O(n)
     * @param data
     * @return
     */
    @Override
    public boolean removeElement(E data) {
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.data.equals(data)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }
        return false;
    }

    /**
     * time : O(n)
     * @param index
     * @return
     */
    @Override
    public E removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not valid");
        }

        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return (E)delNode.data;
    }

    /**
     * time : O(n)
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not valid");
        }

        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E)cur.data;
    }

    /**
     * time : O(1)
     * @return
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * time : O(n)
     * @return
     */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    /**
     * time : O(n)
     * @param index
     * @param data
     */
    @Override
    public void set(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not valid");
        }

        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    /**
     * time : O(n)
     * @param data
     * @return
     */
    @Override
    public boolean contains(E data) {

        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy;
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



}

