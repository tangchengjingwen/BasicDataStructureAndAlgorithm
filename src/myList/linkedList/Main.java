package myList.linkedList;

import myList.linkedList.impl.LinkedListImpl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 14:56
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new LinkedListImpl<>();

        linkedList.addElement(1);
        linkedList.addElement(2);
        linkedList.addElement(3);
        linkedList.addElement(4);
        linkedList.addElement(5);
        linkedList.print();
        linkedList.addIndex(0, 5);
        linkedList.print();
    }
}
