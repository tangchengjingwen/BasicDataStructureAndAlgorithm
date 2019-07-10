package hashtable.openAddressing;

import hashtable.MyHashTable;
import hashtable.openAddressing.impl.HashTableOpenAddressingImpl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 12:42
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, Integer> hashTable = new HashTableOpenAddressingImpl<>();

        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);

        hashTable.print();

        hashTable.put(45, 1);

        hashTable.print();

        hashTable.delete(21);

        hashTable.print();
    }
}
