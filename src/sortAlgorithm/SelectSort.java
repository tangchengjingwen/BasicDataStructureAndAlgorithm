package sortAlgorithm;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 20:01
 * Description :
 */

public class SelectSort {

    /**
     * time : O(n^2)
     * space : O(1)
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal input");
        }

        // 每次都找最小的一个元素放在最前面，并且移动第一个元素的index
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        return nums;
    }

}
