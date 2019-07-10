package sortAlgorithm;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 21:02
 * Description :
 */
public class MergeSort {

    /**
     * time : O(nlogn)
     * space : O(n)
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public static int[] mergeSort(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
        System.out.println("current result: " + Arrays.toString(temp));
    }


    public static void main(String[] args) {
        int[] nums = {5,2,9,4,7,6,1,3,8};
        mergeSort(nums, 0, nums.length  - 1);
    }
}
