package myList.ArrayList.impl;

import myList.ArrayList.MyArrayList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 15:03
 * Description :
 */
public class ArrayListImpl implements MyArrayList {

    private int[] data;

    private int size;

    public ArrayListImpl() {
        this(10);
    }

    public ArrayListImpl(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * time : O(1)
     * @return
     */
    @Override
    public int capacity() {
        return data.length;
    }

    /**
     * time : O(1)
     * @return
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * time : O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int element) {
        // time : O(1)
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size] = element;
        size++;

        // time : O(n) 我觉得这样写不好，上面那种其实是amortized O(1) 感觉会更好
//        add(size, element);
    }

    /**
     * time : O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, int element) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组已经满了");
//        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * Time : O(n)
     * @param element
     * @return
     */
    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * time : O(1)
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
        return data[index];
    }

    /**
     * time : O(1)
     * @param index
     * @param element
     */
    @Override
    public void set(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
        data[index] = element;
    }

    /**
     * time : O(n)
     * @param index
     * @return
     */
    @Override
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
        int res = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // lazy
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return res;
    }

    /**
     * time : O(n)
     * @param element
     */
    @Override
    public void removeElement(int element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index = i;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("element is not exist");
        }
        remove(index);
    }

    @Override
    public void print() {
        System.out.println("size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     * double size when array is full
     * @param capacity
     */
    @Override
    public void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
