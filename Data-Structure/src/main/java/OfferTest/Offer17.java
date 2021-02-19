package OfferTest;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 方法:
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int count=1;
        for (int i = 0; i <n ; i++) {
           count=count*10;
        }
        int[] res=new int[count-1];
        for (int i = 1; i <=count-1 ; i++) {
            res[i-1]=i;
        }
        return res;
    }
}
