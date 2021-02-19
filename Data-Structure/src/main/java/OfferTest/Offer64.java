package OfferTest;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *示例 1：
 * 输入: n = 3
 * 输出: 6
 */
public class Offer64 {
    public static int sumNums(int n) {
        int res;
        if (n==1){
            return 1;
        }
        return sumNums(n-1)+n;
    }

    public static void main(String[] args) {
        int res = sumNums(5);
        System.out.println(res);
    }
}
