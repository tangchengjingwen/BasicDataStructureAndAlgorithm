package stack;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 17:00
 * Description :
 */
public interface MyLinkedListStack<E> {

    int size();

    boolean isEmpty();

    void push(E e);

    E peek();

    E pop();

    void print();

}
