package hashtable;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 11:55
 * Description :
 */
public interface MyHashTable<K, V> {

    void put(K key, V val);

    V get(K key);

    V delete(K key);

    boolean isEmpty();

    int size();

    void print();
}
