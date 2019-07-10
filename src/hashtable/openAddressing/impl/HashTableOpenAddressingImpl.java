package hashtable.openAddressing.impl;

import hashtable.MyHashTable;
import hashtable.openAddressing.HashNode;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 12:28
 * Description :
 */
public class HashTableOpenAddressingImpl<K, V> implements MyHashTable<K, V> {

    private HashNode[] hashNodes;

    private int size;

    private int capacity;

    public HashTableOpenAddressingImpl() {
        this(5);
        hashNodes = new HashNode[capacity];
    }

    public HashTableOpenAddressingImpl(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }


    @Override
    public void put(K key, V val) {
        int index = hash(key);
        int startIndex = index;

        while (hashNodes[index] != null) {
            //已经存在就直接更新
            if (hashNodes[index].key.equals(key)) {
                hashNodes[index].value = val;
                return;
            }
            //index == capacity就放到index为0的位子
            index++;
            index %= capacity;
            if (index == startIndex) {
                resize();
                index = hash(key);
                startIndex = index;
            }
        }

        hashNodes[index] = new HashNode(key, val);
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);

        while (hashNodes[index] != null) {
            //已经存在就直接更新
            if (hashNodes[index].key.equals(key)) {
                return (V) hashNodes[index].value;
            }
            //index == capacity就放到index为0的位子
            index++;
            index %= capacity;
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);

        while (hashNodes[index] != null) {
            //已经存在就直接更新
            if (hashNodes[index].key.equals(key)) {
                V res = (V) hashNodes[index].value;
                hashNodes[index] = null;
                size--;
                return res;
            }
            //index == capacity就放到index为0的位子
            index++;
            index %= capacity;
        }
        return null;
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
                if (hashNode != null) {
                    System.out.println("key: " + hashNode.key + " value: " + hashNode.value);
                }
            }
        }
        System.out.println("size: " + size);
        System.out.println("capacity: " + capacity);
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        capacity = 2 * capacity;
        HashNode[] oldHashNodes = hashNodes;
        hashNodes = new HashNode[capacity];
        size = 0;
        for (int i = 0; i < oldHashNodes.length; i++) {
            if (oldHashNodes[i] != null) {
                put((K) oldHashNodes[i].key, (V) oldHashNodes[i].value);
            }
        }
    }
}
