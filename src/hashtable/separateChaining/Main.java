package hashtable.separateChaining;

import hashtable.MyHashTable;
import hashtable.separateChaining.impl.HashTableSeparateChainingImpl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 12:14
 * Description :
 */
public class Main {

    public static void main(String[] args) {
        MyHashTable<Integer, Integer> hashTable = new HashTableSeparateChainingImpl<>();

        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);

        hashTable.print();

        hashTable.delete(21);

        hashTable.print();
    }
}
