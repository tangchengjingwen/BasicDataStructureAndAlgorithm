package heap;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 15:51
 * Description :
 */
public interface MyMaxHeap<E> {

    int size();

    boolean isEmpty();

    boolean offer(E e);

    E peek();

    E poll();

    void print();

}
