package Sort;

import java.util.Arrays;

/**
 * 快速排序
 *  排一个元素 已该元素为基准(pivot),小于pivot放在pivot前面,大于pivot放在pivot后面
 * 时间复杂度
 * 最优:正序变正序O(nlog(n) ) 每次折半
 * 最差:倒叙变正序O( n^2 )
 * 平均的时间复杂度为：O( n^2 )；
 * 空间复杂度
 * 空间复杂度为：O(log(n))；
 * 稳定性:不稳定
 */
public class QuickSort {
    /*
      从小到大排序
      一次循环
      5,4,3,2,1
   */
    public int Sort(int[] nums,int l,int r){
        int left=l;
        int right=r;
        int pivot=left;
        int temp=nums[pivot];
        System.out.println("temp:" +temp);
       while (left<right){
           //判断当前右指针的值是否大于pivot
           //必须加入left<right ,否则最后一次进来参生的结果left>right，导致下面死循环
           //temp<=nums[right]防止pivot等于数组中的值
           while (left<right&&temp<=nums[right]){
               right--;
           }
           //判断当前右指针的值是否小于pivot,如果小于将该值移到左指针所在位置
           if (temp>nums[right]){
               nums[left]=nums[right];
           }
           //判断当前左指针的值是否大于pivot
           while (left<right&&temp>=nums[left]){
               left++;
           }
           //判断当前右指针的值是否大于pivot,如果小于将该值移到右指针所在位置
           if (temp<nums[left]){
               nums[right]=nums[left];
           }
           //8,97,9,17,1,97
           System.out.println("left:"+left+" right:"+right);
           System.out.println(Arrays.toString(nums));
       }
       nums[right]=temp;
       return right;
    }

    void quick_sort1(int[] nums,int left,int right )
    {
        if (left < right)
        {
            int i = Sort(nums,left,right);//先成挖坑填数法调整s[]
            System.out.println("分割:"+i);
            quick_sort1(nums, left, i - 1); // 递归调用
            quick_sort1(nums, i + 1, right);
        }
    }
    public static void main(String[] args) {
        QuickSort sort=new QuickSort();
        int[] nums={6,11,12,4,2,6,9,1,2};
        sort.Sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
