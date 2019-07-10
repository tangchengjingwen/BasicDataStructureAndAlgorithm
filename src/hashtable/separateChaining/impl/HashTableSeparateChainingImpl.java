package hashtable.separateChaining.impl;

import hashtable.MyHashTable;
import hashtable.separateChaining.HashNode;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 11:57
 * Description :
 */
public class HashTableSeparateChainingImpl<K, V> implements MyHashTable<K, V> {

    private HashNode[] hashNodes;

    private int size;

    private int capacity;

    public HashTableSeparateChainingImpl() {
        this(5);
        hashNodes = new HashNode[capacity];
    }

    public HashTableSeparateChainingImpl(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    @Override
    public void put(K key, V val) {
        HashNode<K, V> hashNode = new HashNode<>(key, val);
        int index = hash(key);

        HashNode curNode = hashNodes[index];
        HashNode prevNode = null;
        if (curNode == null) {              // 当前bucket没有node的话
            hashNodes[index] = hashNode;
        } else {
            //先找当前bucket node里面有没有key，有的话就更新，没有就插入到最后
            while (curNode != null) {
                if (curNode.key.equals(key)) {
                    curNode.value = val;
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode.next = hashNode;
        }
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        while (curNode != null) {
            if (curNode.key.equals(key)) {
                return (V)curNode.value;
            }
            curNode = curNode.next;
        }

        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        HashNode prevNode = null;


        while (curNode != null) {
            if (curNode.key.equals(key)) {
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        if (curNode == null) {
            return null;
        } else if (prevNode == null) {
            hashNodes[index] = curNode.next;
        } else {
            prevNode.next = curNode.next;
        }

        size--;
        return (V)curNode.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> hashNode : hashNodes) {
            if (hashNode != null) {
                while (hashNode != null) {
                    System.out.print("key: " + hashNode.key + " value: " + hashNode.value + " -> ");
                    hashNode = hashNode.next;
                }
                System.out.println(" null");
            }
        }
        System.out.println("size: " + size);
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }
}
