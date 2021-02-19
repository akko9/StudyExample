package Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public void Sort(int[] nums,int left,int right){
        if (left==right){
            return;
        }
        int mid=left+(right-left)/2;
        System.out.println(mid);
        Sort(nums,left,mid);
        Sort(nums,mid+1,right);
        mergeSort(nums,left,mid,nums.length);
        System.out.println("======="+Arrays.toString(nums));
    }
    public void mergeSort(int[] nums,int leftPtr,int rightPtr,int rightBound){
        int mid =rightPtr;
        System.out.println(mid);
        int[] sum=new int[rightBound-leftPtr];
        //1,3,5,7,2,4,6,8
        int left=leftPtr;
        int right=rightPtr;
        int i=0;
        while (left<mid && right<rightBound){
            if (nums[left]>nums[right]){
                sum[i++]=nums[right++];
            }else if (nums[left]<nums[right]){
                sum[i++]=nums[left++];
            }
        }
        while (left<mid){
            sum[i++]=nums[left++];
        }
        while (right<rightBound){
            sum[i++]=nums[right++];
        }

    }

    public static void main(String[] args) {
        MergeSort sort=new MergeSort();
        int[] nums={1,3,5,7};
        sort.Sort(nums,0,nums.length);
        //System.out.println(Arrays.toString(nums));
    }
}
