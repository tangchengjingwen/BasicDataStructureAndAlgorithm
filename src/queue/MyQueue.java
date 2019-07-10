package queue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 19:51
 * Description :
 */
public interface MyQueue<E> {

    int size();

    boolean isEmpty();

    boolean offer(E e);

    E peek();

    E poll();

    void print();

}
