package heap;

import heap.impl.MaxHeapImpl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 16:24
 * Description :
 */
public class Main {

    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();

        Integer[] nums = new Integer[]{2, 23, 45, 46, 78, 91, 17, 15};
        // time : O(nlogn)
        for (Integer i : nums) {
            maxHeap.offer(i);   //
        }

        maxHeap.print();
    }
}
