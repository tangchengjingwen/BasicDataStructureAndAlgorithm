package sortAlgorithm;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 12:06
 * Description :
 */
public class CountingSort {

    /**
     * time : best : O(n)  worst : 没有意义
     *        avg : O(n + k)  k : 最大整数
     * space : O(k)
     * @param nums
     */
    public static void countingSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal input");
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1; // 记录每个元素的个数
        }

        System.out.println(Arrays.toString(count));
        //遍历count数组，读出数据

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
//            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8,20};
        countingSort(nums);
    }

}
