package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 从中选择最大值或者最小值放入数组最前面(新放入一个数组),放入该数组末尾
 * 时间复杂度
 * 最优:正序变正序O( n^2 )  都要从未排序数组中找到最小的数
 * 最差:倒叙变正序O( n^2 )
 * 平均的时间复杂度为：O( n^2 )；
 * 空间复杂度
 * 空间复杂度为：O(1)；
 * 稳定性:不稳定
 */
public class SelectSort {
    /*
   从小到大排序
   一次循环
   4,3,2,1
   1,4,3,2
   1,2,4,3
   1,2,3,4
    */
    public void Sort(int[] nums){
        //最小值的index
        int min=0;
        //临时变量
        int temp=0;
        for (int j = 0; j <nums.length-1 ; j++) {
            //i=j 为了不占用另一个数组空间 ,将最前面的数进行置换
            for (int i = j; i <nums.length-1 ; i++) {
                if (nums[min]>nums[i+1]){
                    min=i+1;
                }
            }
            temp=nums[min];
            nums[min]=nums[j];
            nums[j]=temp;
        }
    }

    public static void main(String[] args) {
        SelectSort sort=new SelectSort();
        int[] nums={1,11,12,4,2,6,9,0,3,7,8,2};
        sort.Sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
