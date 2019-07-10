package sortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 11:56
 * Description :
 */
public class BucketSort {

    /**
     * n : len of nums, m : number of buckets
     * time : best : O(n)   worst : 没有意义
     *        avg : O(n + c)    c = n * (logn ~ logm);
     * space : O(n + m);
     * @param nums
     */
    public static void bucketSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal input");
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketNum = (max - min) / nums.length + 1;  // avoid bucketNum == 0

        System.out.println("max: " + max + ", min: " + min + ", bucketNum: " + bucketNum);

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / nums.length;
            bucket.get(bucketIndex).add(nums[i]);
        }

        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        System.out.println(bucket.toString());
    }


    public static void main(String[] args) {
        int[] nums = {5,2,9,4,7,6,1,3,8,20};
        bucketSort(nums);
    }
}
