package queue;

import queue.impl.LinkedListOfQueue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 20:02
 * Description :
 */
public class Main {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new LinkedListOfQueue<>();

        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }

        queue.poll();
//        System.out.println();
        queue.peek();
        System.out.println("queue.peek(): " + queue.peek());
    }

}
