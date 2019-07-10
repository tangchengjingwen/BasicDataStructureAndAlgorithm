package myList.ArrayList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 15:01
 * Description :
 */


public interface MyArrayList {

    int capacity();

    int size();

    boolean isEmpty();

    /**
     * add element to the end
     */
    void add(int element);

    /**
     * insert element
     * @param index
     * @param element
     */
    void add(int index, int element);

    /**
     * search element exist or not
     * @param element
     * @return
     */
    boolean contains(int element);

    /**
     * get a element
     * @param index
     * @return
     */
    int get(int index);

    /**
     * set a element
     * @param index
     * @param element
     */
    void set(int index, int element);

    /**
     * remove element based on index
     * @param index
     * @return
     */
    int remove(int index);

    /**
     * remove element based on element
     * @param element
     * @return
     */
    void removeElement(int element);

    void print();

    /**
     * change capacity when array is full
     */
    void resize(int capacity);
}
