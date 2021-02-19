package OfferTest;

import Sort.QuickSort;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 方法:暴力(调用api)
 * 方法二:快排
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        merge(arr,0,arr.length-1);
        int[] res=new int[k];
        for (int i = 0; i <k ; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    /*
    调用api
     */
    public int[] getInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        for (int i = 0; i <k ; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    /*
    快排
     */
    public  static int quickSort(int[] nums,int l,int r){
        int left=l;
        int right=r;
        int pivot=nums[left];
        while (left<right){
            while (left<right&&nums[right]>=pivot){
                right--;
            }
            if (nums[right]<pivot){
                nums[left]=nums[right];
            }
            while (left<right&&nums[left]<=pivot){
                left++;
            }
            if (nums[left]>pivot){
                nums[right]=nums[left];
            }
        }
        nums[right]=pivot;
        return right;
    }
    /*
    化分小数组,选取最左边界作为pivot
     */
    public  static void merge(int[] nums,int left,int right){
        if (left<right){
            int i = quickSort(nums,left,right);
            merge(nums,left,i-1);
            merge(nums,i+1,right);
        }
    }
    public static void main(String[] args) {
        int[] nums={6,11,12,4,2,6,9,1,2};
        merge(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
