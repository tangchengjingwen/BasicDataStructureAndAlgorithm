package sortAlgorithm;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 21:27
 * Description :
 */
public class QuickSort {

    /**
     * 快速排序，每次确定一个元素的最终位子，再对左右数组进行递归求解
     * time : O(nlogn)     worst : O(n^2)
     * space : O(logn ~ n)
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int piviotIndex = left;
        int pivot = nums[piviotIndex];
        int l = left + 1;
        int r = right;
        System.out.println("pivot:" + pivot + " " + Arrays.toString(nums));
        System.out.println("pivotIndex: " + piviotIndex + " " + "l,  r  " + " " + l + " " + r);
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
            System.out.println("current result: " + Arrays.toString(nums));
        }

        swap(nums, piviotIndex, r);
        System.out.println("end of this round: " + Arrays.toString(nums));
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {5,2,9,4,7,6,1,3,8};
        quickSort(nums, 0, nums.length  - 1);
    }
}
