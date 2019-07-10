package stack;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 16:28
 * Description :
 */
public interface MyArrayStack<E> {

    int capacity();

    int size();

    boolean isEmpty();

    void push(E e);

    E peek();

    E pop();

    void print();

    void resize(int capacity);
}
