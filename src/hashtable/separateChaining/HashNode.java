package hashtable.separateChaining;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 11:56
 * Description :
 */
public class HashNode<K, V> {

    public K key;

    public V value;

    public HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
