package Sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 通过gap将整个数主分成几个数组,排序,最后gap=1,来插入排序
 * 加强版的插入排序
 */
public class ShellSort {
    /*
          从小到大排序
          一次循环
          5,4,3,2,1
          gap=2
          5,3,1  4,2
          1,2,3,4,5
       */
    public void Sort(int[] nums){
        int temp=0;
        //分组
        for (int gap =nums.length/2; gap>=1 ; gap=gap/2) {
            //每组数据的处理
            for (int i = 0; i<gap;i++) {
                //一组数据处理
                for (int j = gap+i; j <nums.length ; j=j+gap) {
                    int index=j;
                    //当前元素与当前元素前一个做比较进行置换,全程跟踪index
                    while (index-gap>=0){
                        if (nums[index] < nums[index - gap]){
                            temp=nums[index];
                            nums[index]=nums[index-gap];
                            nums[index-gap]=temp;
                            index=index-gap;
                        }else{
                            break;
                        }
                    }
                    System.out.println(Arrays.toString(nums));
                }
            }
        }






    }
    public static void main(String[] args) {
        ShellSort sort=new ShellSort();
        int[] nums={ 1,11,12,4,2,6,9,0,3,7,8,2};
        //[1, 11, 12, 4, 2, 6, 7, 0, 3, 9, 8, 2]
        sort.Sort(nums);
       // System.out.println(Arrays.toString(nums));
    }
}
