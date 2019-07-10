package sortAlgorithm;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 17:57
 * Description :
 */
public class BubbleSort {

    /**
     * time: O(n^2)  space : O(1)
     * @param nums
     * @return
     */
    private static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("illegal input");
        }

        for (int i = 0; i < nums.length - 1; i++) {  // 每一次交换能够确定的元素的index
            for (int j = nums.length - 1; j > i; j--) { // 从后往前遍历一一比较交换位置, 小的话就往前摆
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * time : best : O(n)   worst : O(n^2)
     * space : O(1)
     * @param nums
     * @return
     */
    private static int[] bestBubbleSort(int[] nums) {
        boolean flag = false;
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("illegal input");
        }

        int temp;
        for (int i = 0; i < nums.length - 1; i++) {  // 每一次交换能够确定的元素的index
            flag = false;
            for (int j = nums.length - 1; j > i; j--) { // 从后往前遍历一一比较交换位置
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                // 说明已经是排好序的,直接返回数组即可
                return nums;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }
}
