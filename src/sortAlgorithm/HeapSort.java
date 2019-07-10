package sortAlgorithm;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 17:10
 * Description :
 */
public class HeapSort {

    /**
     * time : O(nlogn)
     * space : O(1)
     * @param nums
     */
    public static void heapSort(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            /**
             * 因为最后一层是不操作的，所以最大的数直接放到后面，再找出被交换元素应该在的位子，依次进行下去
             */
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }


    /**
     *
     * @param nums
     * @param start
     * @param length
     */
    private static void heapAdjust(int[] nums, int start, int length) {
        while (2 * start + 1 < length) {
            int child = 2 * start + 1;
            // 每一层比较
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[start] > nums[child]) {
                break;
            } else {
                swap(nums, start, child);
            }
            start = child;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 23, 45, 46, 78, 91, 17, 15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
