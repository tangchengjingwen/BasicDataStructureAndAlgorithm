package sortAlgorithm;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 20:16
 * Description :
 */
public class InsertSort {

    /**
     * time : best : O(n)   worst : O(n^2)
     * space : O(1)
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal input");
        }

        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                     temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }


    /**
     * 二分法优化插入排序，前面的有序序列可以用binary search去查找
     * time : best O(nlogn)  worst : O(n^2)
     * space : O(1)
     * @param nums
     * @return
     */
    public int[] insertBinarySort(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal input");
        }

        int temp, low, high, mid;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = nums[i + 1];
            low = 0;
            high = i;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // 找到下一个元素该放的位子后，元素按个后移, 把元素放在该放的位子
            for (int j = i; j > high; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = temp;
        }
        return nums;
    }

}
