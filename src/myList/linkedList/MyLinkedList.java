package myList.linkedList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 13:30
 * Description :
 */
public interface MyLinkedList<E> {

    int size();

    boolean isEmpty();

    void addIndex(int index, E data);

    boolean addElement(E data);

    void addFirst(E data);

    void addLast(E data);

    E removeFirst();

    E removeLast();

    boolean removeElement(E data);

    E removeIndex(int index);

    E get(int index);

    E getFirst();

    E getLast();

    void set(int index, E data);

    boolean contains(E data);

    void print();
}
